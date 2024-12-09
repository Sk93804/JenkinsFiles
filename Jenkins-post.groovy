pipeline{
    agent any
    stages{
        stage('checkout'){
            steps{
                echo "This is checkout stage...."
                sh 'exit 1'
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
            emailext(
                to: 'sudheesh.zx@gmail.com',
                subject: 'Build failed: ${env.JOB_NAME}',
                body: "Build has failed . take the necessary actions.."
            )
        }
    }
    
}