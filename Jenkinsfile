echo 'Starting build...'
node ('Saikat_VM') {
	
	stage 'Clone Repository'
		checkout scm
	
	stage 'Compile Code'
		sh 'mvn clean compile'
	
}