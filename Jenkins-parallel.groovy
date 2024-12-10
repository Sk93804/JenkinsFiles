pipeline{
    agent any
    options{
        buildDiscarder(logRotator(numToKeepStr: '5'))
    }
    stages{
        stage('Checkout'){
            steps{
            echo "This is code checkout stage...."
            }
        }
        stage('Parallel stage'){
            parallel{
                stage('Chrome'){
                    steps{
                        catchError(buildResult: 'FAILURE', stageResult: 'FAILURE'){
                        echo "Testing in chrome browser.."
                        sh 'exit 1'
                        }
                    }
                }
                stage('edgee'){
                    steps{
                        echo "Testing in edge browser..."
                    }
                }
                stage('firefox'){
                    steps{
                        echo "Testing in firefox browser.."
                    }
                }
                stage('Opera'){
                    steps{
                        echo "Testing in the opera browser..."
                    }
                }
            }
        }
        stage('Docker'){
            steps{
                echo "Pushing the docker image to the registry"
            }
        }
        stage('Deploy'){
            steps{
                echo "Deployment stage.."
            }
        }
    }

}