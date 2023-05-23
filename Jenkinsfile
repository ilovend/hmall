pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh '''mvn 
clean 
source.jar 
package'''
      }
    }

  }
}