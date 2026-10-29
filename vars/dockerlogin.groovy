
def call(String DH_TOKEN, String DH_USER, String BUILD_NUMBER) {
    withEnv([
        "DH_TOKEN=${DH_TOKEN}",
        "DH_USER=${DH_USER}",
        "BUILD_NUMBER=${BUILD_NUMBER}"
    ]) {
        sh '''
            set +x

            echo "$DH_TOKEN" | docker login \
                -u "$DH_USER" --password-stdin


            docker logout
        '''
    }
}
