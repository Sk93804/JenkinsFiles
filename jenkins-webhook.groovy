@Library('SHARED_LIBRARY') _
pipeline {
    agent any
    stages {
        stage('SCM') {
            steps {
                gitCheckout()
                sh 'ls -lrt'
            }
        }
        stage('Build') {
            steps {
                customBuild( 'clean', 'package') // Pass the required parameter
            }
        }
    }
}
