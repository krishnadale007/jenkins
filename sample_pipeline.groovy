
pipeline {
    agent any
    stages {
        stage('pull') {
            steps {
                echo 'pull done'
            }
        }
        stage('build') {
            steps {
                echo 'build done'
            }
        }
        stage('test'){
            steps{
                echo 'test done'
            }
        }
        stage('deploy'){
            steps{
                echo 'deploy done'
            }
        }
        
    }
}
