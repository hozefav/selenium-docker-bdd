pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                //sh
                bat "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                //sh
                bat "docker build -t hozefavakanerwala/selenium-docker ."
            }
        }
        stage('Push Image') {
            steps {
			    //withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
                    //sh
			        //bat "docker login --username ${user} --password ${pass}"
			        bat "docker login --username hozefavakanerwala --password Crazy@123"
			        bat "docker push hozefavakanerwala/selenium-docker:latest"
			    //}
            }
        }
    }
}