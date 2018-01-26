package nick.loginkotlin.login

interface LoginMvpView {
    fun openMainActivity()

    fun getUsername() : String
    fun getPassword() : String

    fun showUsernameError()
    fun showPasswordError()

    fun hideErrors()
}