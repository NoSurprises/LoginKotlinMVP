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
        view.openMainActivity()
    }

    private fun isPasswordValid(pass: String): Boolean {
        return pass.length >= 6
    }

    private fun isUsernameValid(username: String): Boolean {
        return username.isNotEmpty()
    }
}
