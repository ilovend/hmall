pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh '''pipeline {
    agent any
    stages {
        stage(\'Build\') {
            steps {
                sh \'mvn clean package\'
            }
        }
        stage(\'Deploy\') {
            steps {
                sh \'java -jar target/myapp.jar\'
            }
        }
    }
}
'''
        }
      }

    }
  }