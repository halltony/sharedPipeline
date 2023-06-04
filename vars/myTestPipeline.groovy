def call(Map pipelineParams) {
    pipeline {
        agent any

        stages {
            stage('Hello') {
                steps {
                    sh(libraryResource('helloWorld.sh'))
                }
            }
        }
    }
}