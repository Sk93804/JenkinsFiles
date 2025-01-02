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
                customBuild( goal : 'clean',  option : 'package') // Pass the required parameter
            }
        }
    }
}
