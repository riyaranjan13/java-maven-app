pipeline {
    agent any
    tools {
        maven 'Maven-3.9'
    }
    stages {
        stage('Build') {
            steps {
                dir('hello-world') {
                    sh 'mvn clean compile'
                }
            }
        }
        stage('Unit Test') {
            steps {
                dir('hello-world') {
                    sh 'mvn test'
                }
            }
        }
        stage('SonarQube Analysis') {
            steps {
                dir('hello-world') {
                    withSonarQubeEnv('SonarQube') {
                        sh 'mvn sonar:sonar'
                    }
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
        stage('Package') {
            steps {
                dir('hello-world') {
                    sh 'mvn package -DskipTests'
                }
            }
        }
        stage('Archive Artifact') {
            steps {
                archiveArtifacts artifacts: 'hello-world/target/*.jar'
            }
        }
    }
}
