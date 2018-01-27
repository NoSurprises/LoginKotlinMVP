package nick.loginkotlin.login

interface LoginMvpView {
    fun openMainActivity()

    fun getUsername() : String
    fun setUsername(username: String)

    fun getPassword() : String
    fun setPassword(password: String)

    fun getPasswordConfirm(): String

    fun showUsernameError()

    fun showPasswordError()

    fun hideErrors()

    fun openSignUp();
    fun initSignupListener()

    fun initBack()
}