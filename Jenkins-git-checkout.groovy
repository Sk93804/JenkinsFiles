Pipeline{
    agent any
    stages{
        stage('checkout'){
            steps{
             checkout scmGit(branches: [[name: '*/main']], 
             extensions: [], 
             userRemoteConfigs: [[credentialsId: 'git', url: 'https://github.com/Sk93804/Git-practice.git']])   
            }
        }
        stage('Build'){
            steps{
            echo "Building the files..."
            }
        }
    }
}