package nick.loginkotlin

interface SharedPreferencesMvpHelper {


    fun isLoggedIn(): Boolean
    fun setIsLoggedIn(logged: Boolean)

    fun getUsername(): String
    fun setUsername(username: String)


}