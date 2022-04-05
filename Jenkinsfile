pipeline {
    agent any
    environment {
        DOCKER_PASSWORD = credentials("docker_password")
    }

    stages {
        stage('Build & Test') {
            steps {
                bat './gradlew clean build'
            }
        }
        stage('Tag image') {
              steps {
                script {
                    GIT_TAG = bat([script: 'git fetch --tag && git tag', returnStdout: true]).trim()
                    MAJOR_VERSION = bat([script: 'git tag | cut -d . -f 1', returnStdout: true]).trim()
                    MINOR_VERSION = bat([script: 'git tag | cut -d . -f 2', returnStdout: true]).trim()
                    PATCH_VERSION = bat([script: 'git tag | cut -d . -f 3', returnStdout: true]).trim()
                }
                bat "docker build -t tudoranita/restaurant-img:${MAJOR_VERSION}.\$((${MINOR_VERSION} + 1)).${PATCH_VERSION} ."
              }
        }
    }
}
