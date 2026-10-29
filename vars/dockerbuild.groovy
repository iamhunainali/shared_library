
def call(String DH_USER, String BUILD_NUMBER) {
    sh """
        set -e

        docker build \
            -t "${DH_USER}/greenx-app:frontend" ./GreenX_DCS_Assesment_Tool_Backend

        docker build \
            -t "${DH_USER}/greenx-app:backend" ./greenX-assessment-tool-frontend
    """
}
