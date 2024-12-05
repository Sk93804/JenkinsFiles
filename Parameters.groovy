pipeline{
    agent any
    parameters{
      choice(name: 'Select the environment to run this job', choices: ['Dev', 'QA', 'Prod'])
    }
    stages{
        stage('checkout'){
           steps{ echo "this is code checkout stage"
      }
        }
        stage('build'){
            steps{
                echo "this is building stage"
            }
        }
    }

}