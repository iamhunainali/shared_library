def call(String app, String tag) {
    sh """
        docker build -t ${app}:${tag} .
    """
}
