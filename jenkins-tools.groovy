pipeline{
    agent any
    tools{
        maven 'maven'
    }
    stages{
        stage('checkout'){
            steps{
                echo "This is code checkout stage"
            }
        }
        stage('Build'){
            steps{
                sh ''' mvn --version '''
                       
            }
        }
    }
}