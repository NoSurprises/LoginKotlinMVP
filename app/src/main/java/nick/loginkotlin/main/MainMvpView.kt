package nick.loginkotlin.main

interface MainMvpView {
    fun showMessage(message: String)

    fun openLoginView()

    fun setUsername(username: String)
}
