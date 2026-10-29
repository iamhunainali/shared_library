
def call(String DH_USER, String BUILD_NUMBER) {
    sh """
        set -e

        docker build  -t "${DH_USER}/greenx-app:backend-${BUILD_NUMBER}" ./GreenX_DCS_Assesment_Tool_Backend

        docker build  -t "${DH_USER}/greenx-app:frontend-${BUILD_NUMBER}" ./greenX-assessment-tool-frontend
    """
}

