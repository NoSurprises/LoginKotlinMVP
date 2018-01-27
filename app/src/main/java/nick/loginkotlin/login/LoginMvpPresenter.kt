package nick.loginkotlin.login

interface LoginMvpPresenter {
    fun loginSubmit()
    fun openSignUp()
    fun signupSubmit()
    fun signup(username: String, password: String)
}