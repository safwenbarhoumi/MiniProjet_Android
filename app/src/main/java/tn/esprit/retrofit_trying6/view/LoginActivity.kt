package tn.esprit.retrofit_trying6.view

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tn.esprit.retrofit_trying6.R
import tn.esprit.retrofit_trying6.api.RetrofitInterface
import tn.esprit.retrofit_trying6.model.LoginResult


class LoginActivity : AppCompatActivity() {
    private var retrofit: Retrofit? = null
    private var retrofitInterface: RetrofitInterface? = null
    private val BASE_URL = "http://10.0.2.2:3000"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_dialog)
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofitInterface = retrofit!!.create(RetrofitInterface::class.java)

        val loginBtn = findViewById<Button>(R.id.login)
        val emailEdit = findViewById<EditText>(R.id.emailEdit)
        val passwordEdit = findViewById<EditText>(R.id.passwordEdit)

        loginBtn.setOnClickListener {

            if(emailEdit.text.isEmpty()){
                emailEdit.error = "Email required"
                emailEdit.requestFocus()
                return@setOnClickListener
            }
            if(passwordEdit.text.isEmpty()){
                passwordEdit.error = "Password required"
                passwordEdit.requestFocus()
                return@setOnClickListener
            }

            if (!isValidEmail(emailEdit.text)){
                Toast.makeText(
                    this@LoginActivity, "Email invalide!",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }


            val map = HashMap<String?, String?>()
            map["email"] = emailEdit.text.toString()
            map["password"] = passwordEdit.text.toString()

            val call = retrofitInterface!!.executeLogin(map)
            call?.enqueue(object : Callback<LoginResult?> {
                override fun onResponse(
                    call: Call<LoginResult?>,
                    response: Response<LoginResult?>
                ) {
                    if (response.code() == 200) {
                        val result = response.body()
                        //val builder1 = AlertDialog.Builder(this@LoginActivity)
                        //builder1.setTitle(result!!.name)
                        //builder1.setMessage(result.email)
                        //builder1.show()
                        val i = Intent(this@LoginActivity, DashboardActivity::class.java)
                        startActivity(i)


                    } else if (response.code() == 404) {
                        Toast.makeText(
                            this@LoginActivity, "Wrong Credentials",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

                override fun onFailure(call: Call<LoginResult?>, t: Throwable) {
                    Toast.makeText(
                        this@LoginActivity, t.message,
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
        }



    }
    fun isValidEmail(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }
}