package ru.pulsar.jenkins.library

import org.jenkinsci.plugins.workflow.support.actions.EnvironmentAction

class StepExecutor implements IStepExecutor {

    private steps

    StepExecutor(steps) {
        this.steps = steps
    }

    @Override
    boolean isUnix() {
        return steps.isUnix()
    }

    @Override
    int sh(String script, boolean returnStatus, String encoding) {
        steps.sh script: script, returnStatus: returnStatus, encoding: encoding
    }

    @Override
    int bat(String script, boolean returnStatus, String encoding) {
        steps.bat script: script, returnStatus: returnStatus, encoding: encoding
    }

    @Override
    String libraryResource(String path) {
        steps.libraryResource path
    }

    @Override
    String readFile(String file, String encoding) {
        steps.readFile encoding: encoding, file: file
    }

    @Override
    void echo(Object message) {
        steps.echo message
    }

    @Override
    int cmd(String script, boolean returnStatus = false) {
        return steps.cmd(script, returnStatus)
    }

    @Override
    void tool(String toolName) {
        steps.tool toolName
    }

    @Override
    void withSonarQubeEnv(String installationName, Closure body) {
        steps.withSonarQubeEnv(installationName) {
            body()
        }
    }

    @Override
    EnvironmentAction env() {
        return steps.env
    }

    @Override
    void createDir(String path) {
        steps.createDir(path)
    }

    @Override
    def withEnv(List<String> strings, Closure body) {
        steps.withEnv(strings) {
            body()
        }
    }

    @Override
    def archiveArtifacts(String path) {
        steps.archiveArtifacts path
    }

    @Override
    def stash(String name, String includes) {
        steps.stash name: name, includes: includes
    }

    @Override
    def unstash(String name) {
        steps.unstash name
    }

    @Override
    def zip(String dir, String zipFile, String glob = '') {
        steps.zip dir: dir, zipFile: zipFile, glob: glob
    }

    @Override
    def unzip(String dir, String zipFile, quiet = true) {
        steps.unzip dir: dir, zipFile: zipFile, quiet: quiet
    }

    @Override
    def catchError(Closure body) {
        steps.catchError body
    }
}
