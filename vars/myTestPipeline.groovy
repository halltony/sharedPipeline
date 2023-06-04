/* groovylint-disable-next-line NoDef */
/* groovylint-disable-next-line MethodParameterTypeRequired, MethodReturnTypeRequired, NoDef */
def call(body) {
    // evaluate the body block, and collect configuration into the object
    /* groovylint-disable-next-line NoDef, VariableTypeRequired */
    def pipelineParams = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()
    pipeline {
        agent any
        stages {
            stage('Hello') {
                steps {
                    sh "${libraryResource('helloWorld.sh')} ${pipelineParams.forename} ${pipelineParams.surname}"
                }
            }
        }
    }
}
