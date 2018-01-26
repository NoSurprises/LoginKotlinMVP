package nick.loginkotlin.main

import nick.loginkotlin.PackageModel
import nick.loginkotlin.SharedPrefsHelper

class MainPresenter(private val view: MainMvpView,
                    private val packageModel: PackageModel) : MainMvpPresenter {

    private val model = SharedPrefsHelper(packageModel)

    override fun onCreate() {

        if (!model.isLoggedIn()) {
            view.openLoginView()
            return
        }
        val username = model.getUsername()
        view.showMessage("Logged in as $username")
        view.setUsername(username)
    }

    override fun onLogout() {
        view.openLoginView()
        model.setIsLoggedIn(false)
    }

}
