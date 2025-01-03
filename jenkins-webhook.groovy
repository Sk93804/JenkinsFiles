@Library('SHARED_LIBRARY') _
pipeline {
    agent any
    options{
        script{
            Map config = [buildNumToKeep: '10']
        }
        Options(buildNumToKeep)
    }
    stages {
        stage('SCM') {
            steps {
                script {
                    def config = [
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
                script{
                    Map command = [goal: 'clean', option:'package']
                customBuild(command) // Pass the required parameter
                }
            }
        }
    }
}
