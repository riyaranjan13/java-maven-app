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

        stage('Archive Artifact') {
            steps {
                archiveArtifacts artifacts: 'hello-world/target/*.jar'
            }
        }
    }
}
