def call(String DOCKERHUB_USERNAME, String DOCKERHUB_PASSWORD) {
    withCredentials([
        usernamePassword(
            credentialsId: 'dockerhub-credentials',
            usernameVariable: DOCKERHUB_USERNAME,
            passwordVariable: DOCKERHUB_PASSWORD
        )
    ]) {
        sh """
            docker login -u ${DOCKERHUB_USERNAME} -p ${DOCKERHUB_PASSWORD}
            docker build -t ${DOCKERHUB_USERNAME}/django-notes-app .
            docker push ${DOCKERHUB_USERNAME}/django-notes-app
        """
    }
}
