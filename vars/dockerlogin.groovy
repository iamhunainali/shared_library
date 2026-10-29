def call(String DH_TOKEN, String DH_USER, String BUILD_NUMBER) {
    sh """
                sudo echo "$DH_TOKEN" | docker login -u "$DH_USER" --password-stdin
                sudo docker push "$DH_USER/greenx-backend:$BUILD_NUMBER"
                sudo docker push "$DH_USER/greenx-frontend:$BUILD_NUMBER"
                sudo docker logout
    """
}
