pipeline{
    agent any
    stages{
        stage('Checkout'){
            steps{
            script{
              catchError(buildResult: 'FAILURE', stageResult: 'FAILURE'){
              echo "This is code checkout stage"
              sh 'exit 1'
              }
            }
            }
        }
        stage('build'){
            steps{
             echo "Building this stage irrespective of the errors "
            }
        }
    }
}