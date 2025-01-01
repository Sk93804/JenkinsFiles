pipeline{
    agent any
    environment{
         GIT_BRANCH = 'main'
        SC_URL = 'https://github.com/Sk93804/Maven-tomcat.git'
    }
    stages{
        stage('SCM'){
            steps{
                git branch: "${env.GIT_BRANCH}", url: "${env.SC_URL}"
               sh ' ls -lrt'
            }
        }
    }
}