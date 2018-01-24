package nick.loginkotlin.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import nick.loginkotlin.PackageModel
import nick.loginkotlin.R
import nick.loginkotlin.main.MainActivity

class LoginActivity : AppCompatActivity(), LoginMvpView {

    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(this, PackageModel(this))

        findViewById<Button>(R.id.login).setOnClickListener({ presenter.login() })
    }

    override fun openMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
