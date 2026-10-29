def call(String BUILD_NUMBER, String STACK_NAME) {
    sh """
        set -e

        export DH_USER="${env.DH_USER}"
        export BUILD_NUMBER="${BUILD_NUMBER}"

        cd "${REMOTE_DIR}"

        docker stack deploy \
            --with-registry-auth \
            -c docker-compose.yml \
            ${STACK_NAME}
    """
}
