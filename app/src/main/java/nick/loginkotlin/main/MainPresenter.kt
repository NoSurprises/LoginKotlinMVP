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
        view.showMessage("Logged in")
    }

    override fun onLogout() {
        view.openLoginView()
        model.setIsLoggedIn(false)
    }

}
