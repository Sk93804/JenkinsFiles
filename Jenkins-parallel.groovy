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
                        echo "Testing in chrome browser.."
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
            }
        }
        stage('Deploy'){
            steps{
                echo "Deployment stage.."
            }
        }
    }

}