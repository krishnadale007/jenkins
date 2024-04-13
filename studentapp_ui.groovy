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
                sh '''/opt/apache-maven-3.9.6/bin/mvn sonar:sonar \
  -Dsonar.projectKey=studentapp_ui \
  -Dsonar.host.url=http://13.232.97.136:9000 \
  -Dsonar.login=f334f08ff1c87dccfb093e3d1be6d86d21ae283e '''
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
