pipeline {
   environment {
        registryCredential = 'dockerhub'
        TIMESTAMP = new Date().format("yyyyMMdd_HHmmss")
    }
   agent any
   tools {
    maven 'Maven 3.9.6'
}

   stages {
    stage('Maven Clean') {
            steps {
               script{
                sh 'mvn clean'
               }
            }
        }
        stage('Maven Install') {
            steps {
               script{
                sh 'mvn install -DskipTests'
            }
            }
        }
      stage('Build Docker Image') {
         steps {
            script{
               docker.withRegistry('',registryCredential){
                  def customImage = docker.build("chiragnarkar/swe645-assignment03:${env.TIMESTAMP}")
               }
            }
         }
      }

      stage('Push Image to Dockerhub') {
         steps {
            script{
               docker.withRegistry('',registryCredential){
                  sh "docker push chiragnarkar/swe645-assignment03:${env.TIMESTAMP}"
               }
            }
         }
      }
      stage('Deploying to Rancher to single node(deployed in 3 replicas)') {
         steps {
            script{
               sh "kubectl set image deployment/swe645-assignment03 container-0=chiragnarkar/swe645-assignment03:${env.TIMESTAMP} -n default"
            }
         }
      }
   }
}
