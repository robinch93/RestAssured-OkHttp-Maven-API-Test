pipeline {

    agent any
    tools { 
        maven 'Maven 3' 
    }

    stages {

        stage ('Build') {
            steps {
                sh 'mvn --version'
                sh 'cd RestAssuredAPITesting && mvn clean install -DskipTests=true' 
            }
        }

        stage("data-driven"){
            steps{
                echo 'testing data driven tests'
                sh 'cd RestAssuredAPITesting && mvn surefire:test -Dgroups=data-driven'
            }
        }

        stage("okhttp"){
            steps{
                echo 'testing okhttp tests'
                sh 'cd RestAssuredAPITesting && mvn surefire:test -Dgroups=okhttp'
            }
        }

        stage("rest-assured"){
            steps{
                echo 'testing rest assured tests'
                sh 'cd RestAssuredAPITesting && mvn surefire:test -Dgroups=rest-assured'
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}
