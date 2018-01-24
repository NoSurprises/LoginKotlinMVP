package nick.loginkotlin

class MainPresenter(val view: MainMvpView): MainMvpPresenter {

    override fun onLogout() {
        view.showMessage("Logging out")
    }

}
