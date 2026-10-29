def call(String BUILD_NUMBER, String STACK_NAME) {
    withCredentials([
        string(credentialsId: 'greenx-db-password', variable: 'DB_PASSWORD'),
        string(credentialsId: 'greenx-mysql-root-password', variable: 'MYSQL_ROOT_PASSWORD')
    ]) {
        sh '''
            set -e

            export DH_USER="$DH_USER"
            export BUILD_NUMBER="$BUILD_NUMBER"
            export DB_PASSWORD="$DB_PASSWORD"
            export MYSQL_ROOT_PASSWORD="$MYSQL_ROOT_PASSWORD"

            docker stack deploy --with-registry-auth -c docker-compose.yml "$STACK_NAME"
        '''
    }
}
