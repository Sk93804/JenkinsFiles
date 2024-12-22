pipeline{
    agent {
        label 'Slave1'
    }
    environment{
        GIT_BRANCH = 'main'
        SC_URL = 'https://github.com/Azure-Samples/tomcat10-jakartaee9.git'
        TOMCAT_URL = 'http://15.206.179.7:8080/manager/text'
        WAR_FILE = 'home/ubuntu/tomcat10-jakartaee9/target/*.war'
        CONTEXT_PATH = '/helloworld'
        CREDENTIALS_ID = 'tomcat-credentials'

    }
    stages{
        stage('SCM'){
            steps{
            git branch: '${env.GIT_BRANCH}', url: '${env.SC_URL}'
    
            }
        }
        stage('build'){
            steps{
            sh ''' mvn clean package '''
               
            }
        }
        stage('Deploy'){
            steps{
                deploy adapters: [
                    tomcat8(credentialsId: env.CREDENTIALS_ID, 
                            path: '', 
                            url: env.TOMCAT_URL)
                ], 
                contextPath: env.CONTEXT_PATH, 
                war: env.WAR_FILE
                }
            }
        }
    }
}