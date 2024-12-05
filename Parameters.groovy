pipeline{
    agent any
    triggers{
        cron('* * * * *')
    }
    // parameters{
    //   string(name: 'ENVIRONMENT', defaultValue: 'Prod'  )
    // }
    stages{
        stage('checkout'){
           steps{ echo "this is code checkout stage"
      }
        }
        stage('build'){
            // when{
            //     expression { params.ENVIRONMENT == 'Prod'  }
            // }
            steps{
                echo "this is building stage"
            }
        }
    }

}