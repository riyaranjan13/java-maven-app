pipeline {

    agent any

    tools {

        maven 'Maven-3.9'

    }

    stages {


        stage('Checkout') {

            steps {

                git branch: 'main',
                url: 'https://github.com/riyaranjan13/java-maven-app.git'

            }
        }

        stage('Build') {

            steps {
                source ./hello-world
                sh 'mvn clean package'

            }
        }

        stage('Unit Test') {

            steps {

                sh 'mvn test'

            }
        }

        stage('SonarQube Analysis') {


            environment {

                scannerHome =
                tool 'SonarScanner'

            }

            steps {


                withSonarQubeEnv('SonarQube') {


                    sh '''
                    mvn sonar:sonar \
                    -Dsonar.projectKey=hello-world
                    '''

                }

            }

        }

        stage('Quality Gate') {


            steps {


                timeout(time:5, unit:'MINUTES') {


                    waitForQualityGate abortPipeline:true


                }

            }

        }

        stage('Archive Artifact') {


            steps {


                archiveArtifacts artifacts:'target/*.jar'


            }

        }

    }
}
