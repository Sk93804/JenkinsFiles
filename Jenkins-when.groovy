pipeline{
    agent any
    stages{
        stage('Checkout'){
            steps{
              git branch: 'main',
                    credentialsId: 'git',
                    url: 'https://github.com/Sk93804/Git-practice.git'
              echo "checked out the code from the repository"
            }
        }
        stage("Build"){
            when{
                not{ branch 'main'}
            }
            steps{
                echo "Building"
            }
        }
    }
}