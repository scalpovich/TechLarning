echo 'Starting build...'
node ('Saikat_VM') {
	
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