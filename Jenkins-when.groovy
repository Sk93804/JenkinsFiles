pipeline{
    agent any
    environment{
    }
    stages{
        stage('Checkout'){
            when{
                branch 'main'
            }
            steps{
              git branch: 'main',
                    credentialsId: 'git',
                    url: 'https://github.com/Sk93804/Git-practice.git'
            }
        }
        stage("Build"){
            steps{
                echo "Building"
            }
        }
    }
}