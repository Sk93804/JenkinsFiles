pipeline{
    agent any
    parameters{
      choice(name: 'ENVIRONMENT', choices: ['Dev', 'QA', 'Prod'])
    }
    stages{
        stage('checkout'){
           steps{ echo "this is code checkout stage"
      }
        }
        stage('build'){
            when{
                expression { params.ENVIRONMENT == 'Prod'  }
            }
            steps{
                echo "this is building stage"
            }
        }
    }

}