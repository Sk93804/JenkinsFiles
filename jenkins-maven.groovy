pipeline {
    agent {
        label 'Slave1'
    }
    environment {
        GIT_BRANCH = 'main'
        SC_URL = 'https://github.com/Azure-Samples/tomcat10-jakartaee9.git'
        TOMCAT_URL = 'http://15.206.179.7:8080/manager/text'
        WAR_FILE = '/home/ubuntu/tomcat10-jakartaee9/target/*.war' // Updated to use Jenkins wildcard syntax for files
        CONTEXT_PATH = '/helloworld'
        CREDENTIALS_ID = 'tomcat-credentials'
    }
    stages {
        stage('SCM') {
            steps {
                git branch: "${env.GIT_BRANCH}", url: "${env.SC_URL}"
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
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
}
