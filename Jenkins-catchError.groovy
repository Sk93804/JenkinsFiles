pipeline{
    agent any
    stages{
        stage('Checkout'){
            steps{
              catchError(buildResult: 'FAILURE', stageResult: 'SUCCESS'){
              echo "This is code checkout stage"
              sh 'exit 1'
              }
            }
        }
        stage('build'){
            steps{
            
            }
        }
    }
}