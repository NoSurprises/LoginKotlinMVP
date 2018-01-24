package nick.loginkotlin.login

import nick.loginkotlin.PackageModel
import nick.loginkotlin.SharedPrefsHelper

class LoginPresenter(private val view: LoginMvpView,
                     packageModel: PackageModel): LoginMvpPresenter {

    private val model = SharedPrefsHelper(packageModel)
    
    override fun login() {
        model.setIsLoggedIn(true)
        view.openMainActivity()
    }
}
