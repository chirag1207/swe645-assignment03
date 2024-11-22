pipeline {
    agent any
    tools {
        jdk 'JDK17' // Ensure "JDK17" is configured in Jenkins under Global Tool Configuration
    }
    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub') // Replace 'dockerhub' with the ID of your Docker Hub credentials
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package' // Fixed typo ('maven' to 'mvn')
                sh 'docker build -t chiragnarkar/swe645-assignment03:latest .'
            }
        }
        stage('Login to Docker Hub') {
            steps {
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
            }
        }
        stage('Push Image to Docker Hub') {
            steps {
                sh 'docker push chiragnarkar/swe645-assignment03:latest'
            }
        }
        stage('Deploy to Kubernetes') {
            steps {
                sh 'kubectl config use-context swe645-assignment03' // Ensure this context exists in your kubeconfig
                sh 'kubectl set image deployment/swe645-assignment03 container-0=chiragnarkar/swe645-assignment03:latest -n default'
                sh 'kubectl rollout restart deployment swe645-assignment03 -n default' // Corrected minor syntax
            }
        }
    }
    post {
        always {
            sh 'docker logout'
        }
    }
}
