pipeline{
    agent any
    tools{
        maven 'Maven-3.9.9'
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