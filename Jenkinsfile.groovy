node {
    
    stage('git clone') {
        git branch: 'main', credentialsId: 'github', url: 'https://github.com/Yogivishnu95/tomcat-project.git'
  }
    

    stage('Build') {
        sh 'mvn clean package'
    }

    stage('Push') {
        echo 'This is Push Stage'
    }

    stage('Deploy') {
        sh 'sudo cp /home/ec2-user/git/tomcat-project/target/TomcatMavenApp-2.0.war /home/ec2-user/apache-tomcat-9.0.83/webapps'
    }
}
