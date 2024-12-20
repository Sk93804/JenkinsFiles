pipeline{
    agent {
        label 'Slave1'
    }
    stages{
        stage('SCM'){
            steps{
            git branch: 'main', url: 'https://github.com/Sk93804/JenkinsFiles.git'
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