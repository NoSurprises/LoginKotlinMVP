package nick.loginkotlin.login

import nick.loginkotlin.PackageModel
import nick.loginkotlin.SharedPrefsHelper

class LoginPresenter(private val view: LoginMvpView,
                     packageModel: PackageModel): LoginMvpPresenter {

    private val model = SharedPrefsHelper(packageModel)
    
    override fun loginSubmit() {
        view.hideErrors()
        val username = view.getUsername()
        val password = view.getPassword()

        val usernameValid = isUsernameValid(username)
        val passwordValid = isPasswordValid(password)

        if (usernameValid && passwordValid) {
            if (model.userExists(username) && model.passwordMatch(username, password))
                login()
        }
        else {
            if (!usernameValid) {
                view.showUsernameError()
            }
            if (!passwordValid) {
                view.showPasswordError()
            }
        }


    }

    private fun login() {
        model.setIsLoggedIn(true)
        model.setUsername(view.getUsername())
        view.openMainActivity()
    }

    private fun isPasswordValid(pass: String): Boolean {
        return pass.length >= 6
    }

    private fun isUsernameValid(username: String): Boolean {
        return username.isNotEmpty()
    }

    private fun isPasswordsMatch(password1: String, password2: String): Boolean {
        return password1 == password2
    }

    override fun openSignUp() {
        val username = view.getUsername()
        val password = view.getPassword()

        view.openSignUp()

        view.setUsername(username)
        view.setPassword(password)

        view.initSignupListener()
        view.initBack()

    }

    override fun signupSubmit() {
        view.hideErrors()

        val usernameValid = isUsernameValid(view.getUsername())
        val password1 = view.getPassword()
        val password2 = view.getPasswordConfirm()
        val passwordValid = isPasswordValid(password1)
        val passwordsMatch = isPasswordsMatch(password1, password2)

        if (usernameValid && passwordValid && passwordsMatch) {
            signup(view.getUsername(), view.getPassword())
        }
        else {
            if(!usernameValid) {
                view.showUsernameError()
            }
            if (!passwordValid || !passwordsMatch) {
                view.showPasswordError()
            }
        }
    }

    override fun signup(username: String, password: String) {
        model.signup(username, password)
        login()
    }
}
