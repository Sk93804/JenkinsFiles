@Library('SHARED_LIBRARY') _
pipeline {
    agent any
    stages {
        stage('SCM') {
            steps {
                script {
                    Map config = [
                        url: 'https://github.com/Sk93804/Maven-tomcat.git',
                        branch: 'main'
                    ]
                    gitCheckout(config) // Directly calls the shared library function
                }
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
