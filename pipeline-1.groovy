pipeline{
    agent any
    {
        stages{
            stage('pull'){
                steps{
                    echo 'pull is done'
                }
            }
            stages{
                stage('build'){
                    steps{
                        echo 'build is done'
                    }
                }
            }
        }
    }
}