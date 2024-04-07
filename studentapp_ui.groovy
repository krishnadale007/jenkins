pipeline{
    agent any
    stages{
        stages{
            steps('pull'){
                steps{
                    git branch: 'main', credentialsId: 'ssh', url: 'https://github.com/krishnadale007/jenkins.git'
                echo 'pull'
                }
            }
            stages{
                stage('build'){
                    steps{
                        echo 'build done'
                    }
                }
            }
            stages{
                stage('quality-test'){
                    steps{
                        echo 'quality-test'
                    }
                }
                stages{
                    stage('test'){
                        steps{
                            echo 'test done'
                        }
                    }
                    stages{
                        stage('deploy'){
                            steps{
                                echo 'deploy done'
                            }
                        }
                    }
                }
            }
        }
    }
}