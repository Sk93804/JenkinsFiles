pipeline{
    agent any
    parameters {
        choices (name: 'Do  you want to  run this job?' chioces: ['yes', 'No'])
    }
    stages{
        stage('chekout'){
            steps{
                echo "checkout stage"
            }
        }
    }
}