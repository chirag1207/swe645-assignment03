pipeline {
    agent any
    tools {
        jdk 'JDK17' // Ensure JDK17 is configured in Jenkins
    }
    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub') // Use DockerHub credentials
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
                sh 'docker build -t chiragnarkar/swe645-assignment03:latest .'
            }
        }
        stage('Login') {
            steps {
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
            }
        }
        stage('Push Image to DockerHub') {
            steps {
                sh 'docker push chiragnarkar/swe645-assignment03:latest'
            }
        }
        stage('Deploying on Kubernetes') {
            steps {
                sh 'kubectl config use-context swe645-assignment03' // Ensure correct Kubernetes context
                sh 'kubectl set image deployment/swe645-assignment03 container-0=chiragnarkar/swe645-assignment03:latest -n default'
                sh 'kubectl rollout restart deployment/swe645-assignment03 -n default' // Fixed typo in deployment restart
            }
        }
    }
    post {
        always {
            sh 'docker logout' // Logout from DockerHub
        }
    }
}
