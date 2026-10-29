
def call(String DH_TOKEN, String DH_USER, String BUILD_NUMBER) {
    sh """
        set -e

        echo "\$DH_TOKEN" | docker login \
            -u "\$DH_USER" --password-stdin

        docker push "${DH_USER}/greenx-backend:${BUILD_NUMBER}"
        docker push "${DH_USER}/greenx-frontend:${BUILD_NUMBER}"

        docker logout
    """
}
