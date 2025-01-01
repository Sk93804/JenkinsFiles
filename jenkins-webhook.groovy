@Library('SHARED_LIBRARY') _
pipeline{
    agent any
    stages{
        stage('SCM'){
            steps{
               gitCheckout('main', 'https://github.com/Sk93804/Maven-tomcat.git')
               sh ' ls -lrt'
            }
        }
    }
}   