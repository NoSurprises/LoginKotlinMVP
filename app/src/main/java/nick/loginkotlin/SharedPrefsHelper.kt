package nick.loginkotlin

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class SharedPrefsHelper(packageModel: PackageModel): SharedPreferencesMvpHelper {

    companion object {
        private val FILENAME = "default.prefs"
        private val LOGGED_IN = "loggedIn"
        private val USERNAME = "username"
    }

    private val sharedPreferences: SharedPreferences = packageModel.context.getSharedPreferences(FILENAME, MODE_PRIVATE)

    override fun isLoggedIn(): Boolean {
        return sharedPreferences.getBoolean(LOGGED_IN, false)
    }

    override fun setIsLoggedIn(logged: Boolean) {
        sharedPreferences.edit().putBoolean(LOGGED_IN, logged).apply()
    }

    override fun setUsername(username: String) {
        sharedPreferences.edit().putString(USERNAME, username).apply()
    }

    override fun getUsername(): String {
        return sharedPreferences.getString(USERNAME, "default username")
    }
}