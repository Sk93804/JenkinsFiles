pipeline{
    agent any
    stages{
        stage('checkout'){
            steps{
                echo "This is checkout stage...."
            }
        }
        stage('Build'){
            steps{
            echo "This is build stage....."
            }
        }
        stage('Deploy'){
            steps{
                echo "This is Deploy stage"
            }
        }
    }
    post{
        failure{
            echo 'pipeline failed sending alerts...'
        }
    }
    
}