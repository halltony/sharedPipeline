def call(body) {
    // evaluate the body block, and collect configuration into the object
    def pipelineParams = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()
    pipeline {
        agent any
        stages {
            stage('Hello') {
                steps {
                    echo pipelineParams.forename
                    echo pipelineParams.surname
                    sh "/bin bash ${(libraryResource('helloWorld.sh')}"
                }
            }
        }
    }
}
