pipeline{
    agent any
    environment{
        ENV = 'production'
    }
    stages{
        stage('Checkout'){
            steps{
              git branch: 'main',
                    credentialsId: 'git',
                    url: 'https://github.com/Sk93804/Test.git'
              echo "checked out the code from the repository"
            }
        }
        stage("Build"){
            steps{
                echo "Building"
            }
        }
        stage("Deploy"){
            when{
               any off{ environment name: 'ENV', value: 'Production'
                        environment name: 'ENV', value: 'production' }
            }
            steps{
                echo "Deploying to production"
            }
        }
    }
}