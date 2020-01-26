pipeline {
   agent any

   stages {

      stage('Build') {
         steps {
          script {
            // Get some code from a GitHub repository
            git 'https://github.com/adaraz-demo/cicd-demo.git'

            // Run Maven on a Unix agent.
            //sh "mvn clean package"

            // To run Maven on a Windows agent, use
            // bat "mvn -Dmaven.test.failure.ignore=true clean package"

            println ">>> Running server unit tests"

            ansiColor('xterm') {
                println "<<< Running server unit tests complete"

                try {
                    sh 'mvn test'
                } catch(e) {
                    println "Cancelling build because something failed while running server unit tests " + e
                    //cancelCurrentBuild(e, 'server:test')
                } finally {
                    sh "cd cicd-demo/target && mv reports/tests/test reports/tests/unit-tests"
                    junit allowEmptyResults: true, keepLongStdio: true, testResults: '**/test-results/**/*.xml'
                    archiveArtifacts allowEmptyArchive: true, artifacts: "**/jacoco/**", caseSensitive: false, defaultExcludes: false
                    stash allowEmpty: true, includes: "**/jacoco/**", name: 'unit-test-reports'
                }
            }

            println "<<< Running server unit tests complete"

            //printDuration(start, "unit-tests")
          }
         }
      }
   }
}