package nick.loginkotlin.login

class LoginPresenter(private val view: LoginMvpView): LoginMvpPresenter {
    override fun login() {
        view.openMainActivity()
    }
}
