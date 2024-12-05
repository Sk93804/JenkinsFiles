pipeline{
    agent any
    parameters {
        booleanParam(name: 'Do  you want to  run this job?', defaultValue: true)
    }
    stages{
        stage('chekout'){
            steps{
                echo "checkout stage"
            }
        }
    }
}