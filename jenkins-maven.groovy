pipeline{
    agent {
        label 'Slave1'
    }
    stages{
        stage('SCM'){
            steps{
            git branch: 'main', url: 'https://github.com/jabedhasan21/java-hello-world-with-maven.git'
            sh ''' pwd
            ls -lrt '''
    
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