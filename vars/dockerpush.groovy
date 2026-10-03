def call(String imageName) {
    withCredentials([
        usernamePassword(
            credentialsId: 'dockerhub-credentials',
            usernameVariable: 'DOCKERHUB_USERNAME',
            passwordVariable: 'DOCKERHUB_PASSWORD'
        )
    ]) {
        sh '''
            echo "$DOCKERHUB_PASSWORD" | docker login -u "$DOCKERHUB_USERNAME" --password-stdin
            docker tag notes-app:latest "$DOCKERHUB_USERNAME/notes-app:latest"
            docker push "$DOCKERHUB_USERNAME/notes-app:latest"
        '''
    }
}
