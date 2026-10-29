
def call(String DH_TOKEN, String DH_USER, String BUILD_NUMBER) {
    withEnv([
        "DH_USER=${DH_USER}",
        "DH_TOKEN=${DH_TOKEN}",
        "BUILD_NUMBER=${BUILD_NUMBER}"
    ]) {
        sh '''
            set +x

            echo "$DH_TOKEN" | docker login \
                -u "$DH_USER" --password-stdin

            //docker push "$DH_USER/greenx-app:backend-$BUILD_NUMBER"
            //docker push "$DH_USER/greenx-app:frontend-$BUILD_NUMBER"

            docker logout
        '''
    }
}
