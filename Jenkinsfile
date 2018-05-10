echo 'Starting build...'
node ('master') {
	
	stage ('Clone Repository') {
		checkout scm
	}	
	
	stage ('Compile Code') {
		def mvnHome = tool 'Maven'
    	bat "${mvnHome}/bin/mvn clean compile"
	}	
		
	stage ('Cleaning up') {
		deleteDir()
	}	
}