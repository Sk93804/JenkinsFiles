@Library('SHARED_LIBRARY') _
pipeline{
    agent any
    stages{
        stage('SCM'){
            steps{
               gitCheckout()
               sh ' ls -lrt'
            }
        }
        stage('build'){
            steps{
                build(job: 'package')
            }
        }
    }
}   