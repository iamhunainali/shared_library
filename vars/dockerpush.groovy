def call(String DOCKERHUB_USERNAME, String DOCKERHUB_PASSWORD){
  withCredentials([usernamePassword(
    credentialsId: 'dockerhub-credentials'.
    usernameVariable: '${DOCKERHUB_USERNAME}',
    passwordVariable: '${DOCKERHUB_PASSWORD}'
  )
                 ]) {
    sh """
          
      """
                 }
}
