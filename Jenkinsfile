pipeline {
    agent any
    tools {
        gradle 'gradle'  
    } 

    
    stages {
        stage('Clone') {
            steps{
                git 'https://github.com/emandry/java-demo.git'
        
            }
        }
    
        stage('Build') {
            steps{   
                script {
                    def rtGradle = Artifactory.newGradleBuild()
                    def buildInfo
                    rtGradle.tool = "gradle"
                    buildInfo = rtGradle.run rootDir: './', buildFile: "build.gradle", tasks: "clean build"
                }
            }
        }
        
        stage('Deploy') {
            steps{
                sh 'rm -rf apps* ; mv build/libs/Demo-0.0.1-SNAPSHOT.war /webapps/app.war'
            }
        }
    }
    post {
      always {
        junit "build/test-results/test/*.xml"
        logstashSend failBuild: false, maxLines: 20000
      }
    }    
}
