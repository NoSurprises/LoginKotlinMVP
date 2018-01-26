package nick.loginkotlin.main

import android.app.LauncherActivity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import nick.loginkotlin.PackageModel
import nick.loginkotlin.R
import nick.loginkotlin.login.LoginActivity

class MainActivity : AppCompatActivity(), MainMvpView {

    private lateinit var presenter: MainMvpPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this, PackageModel(this))

        presenter.onCreate()
        findViewById<Button>(R.id.logout).setOnClickListener{ presenter.onLogout() }
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun setUsername(username: String) {
        findViewById<TextView>(R.id.name).setText(username)
    }

    override fun openLoginView() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}
