package org.devops



//扫描
def SonarScan(sonarServer,projectName,projectDesc,projectPath){
    
    //定义服务器列表
    def server = ["test":"sonarqube","prod":"sonarqube-prod"]
    withSonarQubeEnv("{server[sonarServer]}") {
        def  SonarHome = "/usr/local/sonar-scanner"
        def  SonarDate = sh  returnStdout: true, script: 'date +%Y%m%d-%H%M'
        SonarDate = SonarDate - "\n"

        sh  """
            ${SonarHome}/bin/sonar-scanner -Dsonar.projectKey=${projectName}  \
            -Dsonar.projectName=${projectName}  \
            -Dsonar.projectVersion=${SonarDate} \
            -Dsonar.ws.timeout=30 \
            -Dsonar.projectDescription=${projectDesc}  \
            -Dsonar.links.homepage=http://www.baidu.com \
            -Dsonar.sources=${projectPath} \
            -Dsonar.sourceEncoding=UTF-8 \
            -Dsonar.java.binaries=target/classes \
            -Dsonar.java.test.binaries=target/test-classes \
            -Dsonar.java.surefire.report=target/surefire-reports
        
        """
     }   
}
