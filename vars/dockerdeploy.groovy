
def call(String REMOTE_HOST, String REMOTE_DIR, String BUILD_NUMBER, String STACK_NAME) {
    sh """
        set -e

        sudo ssh -o StrictHostKeyChecking=accept-new ${REMOTE_HOST} '
            set -e
            sudo cd ${REMOTE_DIR}

            sudo export DH_USER="${env.DH_USER}"
            sudo export BUILD_NUMBER="${BUILD_NUMBER}"

            sudo docker stack deploy \
                --with-registry-auth \
                -c docker-compose.yml \
                ${STACK_NAME}
        '
    """
}
