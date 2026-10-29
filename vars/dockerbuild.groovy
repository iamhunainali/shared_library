
def call(String DH_USER, String BUILD_NUMBER) {
    sh """
        set -e

        sudo docker build \
            -t "${DH_USER}/greenx-backend:${BUILD_NUMBER}" ./GreenX_DCS_Assesment_Tool_Backend

        sudo docker build \
            -t "${DH_USER}/greenx-frontend:${BUILD_NUMBER}" ./greenX-assessment-tool-frontend
    """
}
