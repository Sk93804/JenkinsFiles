pipeline{
    agent any
    stages{
        stage('Checkout'){
            steps{
                echo "code checkout stage...."
            }
        }
        stage('Build'){
            steps{
               script{
                try{
                    echo "This is build stage"
                    sh "exit 1"
                }
                catch (Exception e){
                    echo "build failed: ${e.getMessage()}"
                }
               }
            }
        }
        stage('Deploy'){
            steps{
                echo "Deploying application..."
            }
        }
    }
}