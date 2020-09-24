pipeline {
    agent any
    stages {
        stage('Build test code') {
            steps {
                sh 'mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/all_tests_suite.xml'
            }
        }
        stage('Execute test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Generate allure report') {
            steps {
                script {
                    allure([
                            includeProperties: false,
                            jdk              : '',
                            properties       : [],
                            reportBuildPolicy: 'ALWAYS',
                            results          : [[path: './allure-results']]
                    ])
                }
            }
        }
    }
}