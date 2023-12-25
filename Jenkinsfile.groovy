pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Yogivishnu95/tomcat-project.git'                checkout scm
            }
        }
        stage('Build') {
            stage('Build') {
            steps {
				 sh 'mvn clean install'
			}
			post{
				success{
					echo "Archiving the Artifacts"
					archiveArtifacts artifacts: '**/target/*.war'
				}
			}
        }
        }
        stage('Test') {
            steps {
                // Run tests
                sh 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                deploy adapters: [tomcat9(credentialsId: 'dc6546fc-d520-4402-8c40-9160a8549f30', path: '', url: 'http://3.111.171.118:8080/')], contextPath: null, war: '**/*.war'
                sh 'deploy.sh'
            }
        }
    }
}
