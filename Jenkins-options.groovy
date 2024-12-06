pipeline {
    agent any
    options {
        buildDiscarder(logRotator(numToKeepStr: '5')) // Keep the logs of only the last 5 builds
        retry(2) // Retry the failed stages up to 2 times
        timeout(time: 1, unit: 'MINUTES') // Set a timeout of 1 minute for the pipeline
    }
    stages {
        stage('Checkout') {
            steps {
                echo "Checkout stage"
            }
        }
        stage('Build')
        steps{
             echo "Job Name: ${env.JOB_NAME}"
                echo "Build Number: ${env.BUILD_NUMBER}"
                echo "Workspace: ${env.WORKSPACE}"
                echo "Git Branch: ${env.GIT_BRANCH}"
                echo "Triggered By: ${env.BUILD_USER}"
        }
    }
}
