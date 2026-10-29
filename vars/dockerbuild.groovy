
def call(String DH_USER, String BUILD_NUMBER) {
    sh """
        set -e

        docker build --no-cache -t "${DH_USER}/greenx-app:backend" ./GreenX_DCS_Assesment_Tool_Backend

        docker build --no-cache -t "${DH_USER}/greenx-app:frontend" ./greenX-assessment-tool-frontend
    """
}

