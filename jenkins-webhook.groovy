@Library('SHARED_LIBRARY') _
pipeline {
    agent any
    stages {
        stage('SCM') {
            steps {
                script{
                    def config = [
                        url: 'https://github.com/Sk93804/Maven-tomcat.git'
                        branch: 'main'
                    ]
                }
                gitCheckout()
                sh 'ls -lrt'
            }
        }
        stage('Build') {
            steps {
                customBuild() // Pass the required parameter
            }
        }
    }
}
