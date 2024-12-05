pipeline{
    agent any
    tools{
        maven 'apache-maven-3.0.1'
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