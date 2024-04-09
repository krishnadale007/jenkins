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
                sh '/opt/apache-maven-3.9.3/bin/mvn clean package'
                echo 'build done'
            }
        }
        stage('quality-test') {
            steps {
                echo 'quality-test'
            }
        }
        stage('test') {
            steps {
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
