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
                build('clean', 'package', 'myjob') // Pass the required parameter
            }
        }
    }
}
