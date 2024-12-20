pipeline{
    agent {
        label 'Slave1'
    }
    stages{
        stage('SCM'){
            steps{
            checkout scmGit(branches: [[name: '*/main']], 
            extensions: [], 
            userRemoteConfigs: [[url: 'https://github.com/jabedhasan21/java-hello-world-with-maven.git']])
            sh ''' ls -lrt '''
    
            }
        }
        stage('build'){
            steps{
                sh '''
                cd  ./java-hello-world-with-maven.git 
                mvn clean  package 
                '''
            }
        }
    }
}