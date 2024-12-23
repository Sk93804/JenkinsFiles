pipeline {
    agent {
        label 'Slave1'
    }
    options {
        buildDiscarder(logRotator(numToKeepStr: '5'))
    }
    // triggers {
    //     pollSCM('*/2 * * * *')
    // }
    environment {
        GIT_BRANCH = 'main'
        SC_URL = 'https://github.com/Sk93804/Maven-tomcat.git'
        TOMCAT_URL = 'http://15.206.179.7:8080/manager/text'
        WAR_FILE = '**/target/*.war' // Updated to use Jenkins wildcard syntax for files
        CONTEXT_PATH = '/helloworld'
        CREDENTIALS_ID = 'tomcat-credentials'
    }
    stages {
        stage('SCM') {
            steps {
                script {
                    if (env.GIT_BRANCH == 'main') {
                        git branch: "${env.GIT_BRANCH}", url: "${env.SC_URL}"
                    } else {
                        echo "Branch is not main, skipping the checkout"
                    }
                }
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
                sh 'ls /target'
            }
        }
        stage('Deploy') {
            steps {
                deploy adapters: [
                    tomcat9(credentialsId: env.CREDENTIALS_ID, 
                            path: '', 
                            url: env.TOMCAT_URL)
                ], 
                contextPath: env.CONTEXT_PATH, 
                war: env.WAR_FILE
            }
        }
    }
    post{
        success{
            echo 'The pipeline has completed successfully'
        }
    }
}
