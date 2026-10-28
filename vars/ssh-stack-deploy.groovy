
def call(String REMOTE_HOST, String REMOTE_DIR, String BUILD_NUMBER, String STACK_NAME) {
    sh """
        set -e

        ssh "${REMOTE_HOST}" "mkdir -p '${REMOTE_DIR}'"

        scp docker-compose.yml "${REMOTE_HOST}:${REMOTE_DIR}/docker-compose.yml"

        ssh "${REMOTE_HOST}" "
            set -e
            cd '${REMOTE_DIR}'
            export IMAGE_TAG='${BUILD_NUMBER}'
            docker stack deploy --with-registry-auth -c docker-compose.yml '${STACK_NAME}'
            docker stack services '${STACK_NAME}'
        "
    """
}
