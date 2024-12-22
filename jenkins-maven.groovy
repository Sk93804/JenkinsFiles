pipeline{
    agent {
        label 'Slave1'
    }
    stages{
        stage('SCM'){
            steps{
            git branch: 'main', url: 'https://github.com/Azure-Samples/tomcat10-jakartaee9.git'
    
            }
        }
        stage('build'){
            steps{
            sh ''' mvn clean package '''
               
            }
        }
        stage('Deploy'){
            steps{
                dir(target){
                    sh ' scp target ubuntu@15.206.179.7:/home/ubuntu/tomcat10/webapps/ '
                }
            }
        }
    }
}