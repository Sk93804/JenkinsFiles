Pipeline{
    agent any
    environment{
        APP = 'Frontend'
        DB_URL = '192.64.17.1'
    }
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
        stage('Accessing the ENV variables')
        steps{
            echo "${env.APP}: ${env.DB_URL}"
        }
    }
}