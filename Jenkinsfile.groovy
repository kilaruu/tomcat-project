node {
    
    stage('Checkout') {
        git branch: 'main', credentialsId: 'github', url: 'https://github.com/Yogivishnu95/tomcat-project.git'
  }
    
    stage('Test') {
        echo 'This is Push Stage'
    }
    
    stage('Build') {
        sh 'mvn clean package'
    }
 
    stage('Deploy') {
        sh 'sudo cp /home/ec2-user/git/tomcat-project/target/TomcatMavenApp-2.0.war /home/ec2-user/apache-tomcat-9.0.83/webapps'
    }
}
