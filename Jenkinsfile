pipeline {
   agent any

   stages {

      stage('Checkout') {
          steps {
            // Get some code from a GitHub repository
            git 'https://github.com/adaraz-demo/cicd-demo.git'
          }
      }

      stage('Build') {
          steps {
            // Run Maven on a Unix agent.
            sh "mvn clean build"
          }
      }

      stage('Test') {
         steps {
          script {
            ansiColor('xterm') {
                println "<<< Running server unit tests complete"

                try {
                    sh 'mvn test'
                } catch(e) {

                    println "Cancelling build because something failed while running server unit tests " + e

                    //cancelCurrentBuild(e, 'server:test')
                } finally {
                    // sh "cd target && mv reports/tests/test reports/tests/unit-tests"
                    junit allowEmptyResults: true, keepLongStdio: true, testResults: '***/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts allowEmptyArchive: true, artifacts: "**/jacoco/**", caseSensitive: false, defaultExcludes: false
                    stash allowEmpty: true, includes: "**/jacoco/**", name: 'unit-test-reports'
                }
            }

            println "<<< Running server unit tests complete"

          }
         }
      }

      stage('JaCoCo') {
          steps {
              echo 'Code Coverage'
              jacoco()
          }
      }
   }
}