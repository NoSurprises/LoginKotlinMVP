package nick.loginkotlin.main

class MainPresenter(private val view: MainMvpView): MainMvpPresenter {

    override fun onLogout() {
        view.openLoginView()
    }

    override fun onCreate() {
        view.showMessage("Logged in")
    }

}
