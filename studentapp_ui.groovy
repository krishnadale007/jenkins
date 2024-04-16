pipeline {
    agent any
    stages {
        stage('pull') {
            steps {
                git branch: 'main', credentialsId: 'ssh', url: 'https://github.com/krishnadale007/jenkins.git'
                echo 'pull'
            }
        }
        stage('build') {
            steps {
                sh '/opt/apache-maven-3.9.6/bin/mvn clean package'
                echo 'this is build a job'
            }
        }
        stage('quality-test') {
            steps {
                echo 'quality-test'
            }
        }
        stage('test') {
            steps {
                sh '''/opt/apache-maven-3.9.6/bin/mvn sonar:sonar \\
  -Dsonar.projectKey=studentapp_ui \\
  -Dsonar.host.url=http://13.233.139.25:9000 \\
  -Dsonar.login=7a2e6d3f3062cbb78818413411e1d1c17ded19a5'''
  
                echo 'test done'
            }
        }
        stage('deploy') {
            steps {
                echo 'deploy done'
            }
        }
    }
}
