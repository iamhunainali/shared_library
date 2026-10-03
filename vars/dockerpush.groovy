def call(String DOCKERHUB_USERNAME) {
    withCredentials([
        usernamePassword(
            credentialsId: 'dockerhub-credentials',
            usernameVariable: DOCKERHUB_USERNAME,
            passwordVariable: DOCKERHUB_PASSWORD
        )
    ]) {
        sh """
            docker build -t ${DOCKERHUB_USERNAME}/django-notes-app .
            docker push ${DOCKERHUB_USERNAME}/django-notes-app
        """
    }
}
