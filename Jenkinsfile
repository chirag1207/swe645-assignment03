pipeline {
   agent any
   tools{
      jdk 'JDK17'
   }
  environment{
     DOCKERHUB_CREDENTIALS = credentials('dockerhub')
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
      stage('Push Image to Dockerhub') {
         steps {
          
                  sh 'docker push chiragnarkar/swe645-assignment03:latest'
         }
      }
      stage('Deploying on Kubernetes') {
         steps {
           sh 'kubectl config use-context swe645-assignment03'
            sh 'kubectl set image deployment/swe645-assignment03 container-0=chiragnarkar/swe645-assignment03:latest -n default'
            sh 'kubectl rollout restart deployswe645-assignment03 -n default'
         }
      }
   }
post{
   always{
      sh 'docker logout'
}
}
}
