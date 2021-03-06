package nick.loginkotlin.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import nick.loginkotlin.PackageModel
import nick.loginkotlin.R
import nick.loginkotlin.main.MainActivity

class LoginActivity : AppCompatActivity(), LoginMvpView {

    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(this, PackageModel(this))

        findViewById<Button>(R.id.submit).setOnClickListener({ presenter.loginSubmit() })
        findViewById<TextView>(R.id.sign_up).setOnClickListener({ presenter.openSignUp()})
    }

    override fun openMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun getUsername(): String {
        return (findViewById<EditText>(R.id.username) as EditText).text.toString()
    }

    override fun getPassword(): String {
        return (findViewById<EditText>(R.id.password) as EditText).text.toString()
    }

    override fun setUsername(username: String) {
        findViewById<EditText>(R.id.username).setText(username)
    }

    override fun setPassword(password: String) {
        findViewById<EditText>(R.id.password).setText(password)
    }

    override fun showUsernameError() {
        findViewById<TextView>(R.id.username_error).visibility = View.VISIBLE
    }

    override fun showPasswordError() {
        findViewById<TextView>(R.id.password_error).visibility = View.VISIBLE
    }

    override fun hideErrors() {
        findViewById<TextView>(R.id.username_error).visibility = View.GONE
        findViewById<TextView>(R.id.password_error).visibility = View.GONE
    }

    override fun openSignUp() {
        setContentView(R.layout.signup)
    }

    override fun initBack() {

    }

    override fun getPasswordConfirm(): String {
        return (findViewById<EditText>(R.id.password_confirm) as EditText).text.toString()
    }

    override fun initSignupListener() {
        findViewById<Button>(R.id.sign_up).setOnClickListener({ presenter.signupSubmit() })
    }
}
