echo 'Starting build...'
node {
	
	stage 'Clone Repository'
		checkout scm
	
	stage 'Compile Code'
		sh 'mvn clean compile'
	
}