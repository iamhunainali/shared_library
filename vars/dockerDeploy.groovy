def call(String REMOTE_HOST, String REMOTE_DIR, String BUILD_NUMBER, String STACK_NAME) {
    sh """
        set -e

        echo "Creating remote deployment directory..."
        ssh -o StrictHostKeyChecking=accept-new ${REMOTE_HOST} \
            'mkdir -p ${REMOTE_DIR}'

        echo "Copying project files to remote server..."
        sudo scp -r -o StrictHostKeyChecking=accept-new \
            ${PRO_DIR} \
            ${REMOTE_HOST}:${REMOTE_DIR}/

        echo "Deploying Docker Swarm stack..."
        ssh -o StrictHostKeyChecking=accept-new ${REMOTE_HOST} '
            set -e
            cd ${REMOTE_DIR}

            export DH_USER="${env.DH_USER}"
            export BUILD_NUMBER="${BUILD_NUMBER}"

            docker stack deploy \
                --with-registry-auth \
                -c docker-compose.yml \
                ${STACK_NAME}
        '
    """
}
