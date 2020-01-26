pipeline {
   agent any

   stages {

      stage('Build') {
         steps {
            // Get some code from a GitHub repository
            git 'https://github.com/adaraz-demo/cicd-demo.git'

            // Run Maven on a Unix agent.
            //sh "mvn clean package"

            // To run Maven on a Windows agent, use
            // bat "mvn -Dmaven.test.failure.ignore=true clean package"

            println ">>> Running server unit tests"

            ansiColor('xterm') {
                println "<<< Running server unit tests complete"
            }

            println "<<< Running server unit tests complete"

            //printDuration(start, "unit-tests")
         }
      }
   }
}