package nick.loginkotlin

interface SharedPreferencesMvpHelper {


    fun isLoggedIn(): Boolean
    fun setIsLoggedIn(logged: Boolean)

    fun getUsername(): String
    fun setUsername(username: String)

    fun userExists(username: String): Boolean
    fun passwordMatch(username: String, password: String): Boolean

    fun signup(username: String, password: String)


}