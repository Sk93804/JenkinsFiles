pipeline{
    agent any
    stages{
        stage('Checkout'){
            when{
                branch 'main'
            }
            steps{
              git branch: 'main',
                    credentialsId: 'git',
                    url: 'https://github.com/Sk93804/Git-practice.git'
              echo "checked out the code from the repository"
            }
        }
        stage("Build"){
            steps{
                echo "Building"
            }
        }
    }
}