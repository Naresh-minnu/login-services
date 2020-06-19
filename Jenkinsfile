pipeline {
   agent any
   tools {
        maven 'maven3'
    }
   stages{
        stage('build'){
            steps{
                sh script: 'mvn clean package'
            }
       }
       stage('Upload War To Nexus'){
            steps{
                script{
                    def mavenPom= readMavenPom file: 'pom.xml'
                    def nexusRepoName = mavenPom.endsWith("SNAPSHOT") ? "users-login-snpshot": "users-login-release"
                        nexusArtifactUploader artifacts:[
                    [
                        artifactId: 'users-login',
                        classifier: '',
                        file: "target/users-login${mavenPom.version}.war",
                        type:'war'
                    ]
                ],
                 credentialsId: 'nexus3',
                 groupId: 'com.naresh',
                 nexusUrl:'172.31.15.204:8081',
                 nexusVersion:'nexus2',
                 protocol: 'http',
                 repository: nexusRepoName,
                 version: "${mavenPom.version}"
                }
                
            }
       }
   }
}