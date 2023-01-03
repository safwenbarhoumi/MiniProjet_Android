package tn.esprit.retrofit_trying6.view

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tn.esprit.retrofit_trying6.R
import tn.esprit.retrofit_trying6.api.RetrofitInterface
import java.util.HashMap

class SignUpActivity : AppCompatActivity() {
    private var retrofit: Retrofit? = null
    private var retrofitInterface: RetrofitInterface? = null
    private val BASE_URL = "http://10.0.2.2:3000"
    private lateinit var signin : Button
    //@SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_dialog)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }


        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofitInterface = retrofit!!.create(RetrofitInterface::class.java)

         signin = findViewById(R.id.signin)
        signin.setOnClickListener {
            val i = Intent(this@SignUpActivity,LoginActivity::class.java)
            startActivity(i)
        }


        val signupBtn = findViewById<Button>(R.id.signup)
        val nameEdit = findViewById<EditText>(R.id.nameEdit)
        val emailEdit = findViewById<EditText>(R.id.emailEdit)
        val passwordEdit =findViewById<EditText>(R.id.passwordEdit)
        val passwordEdit2 =findViewById<EditText>(R.id.passwordEdit2)
        signupBtn.setOnClickListener {

            if(nameEdit.text.isEmpty()){
                nameEdit.error = "Name required"
                nameEdit.requestFocus()
                return@setOnClickListener
            }
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
                    this@SignUpActivity, "Email invalide!",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }
            if(!(passwordEdit.text.toString().equals(passwordEdit2.text.toString()))){
                Toast.makeText(
                    this@SignUpActivity, "Passwords are not the same !",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }

            val map = HashMap<String?, String?>()
            map["name"] = nameEdit.text.toString()
            map["email"] = emailEdit.text.toString()
            map["password"] = passwordEdit.text.toString()
            val call = retrofitInterface!!.executeSignup(map)
            call?.enqueue(object : Callback<Void?> {
                override fun onResponse(call: Call<Void?>, response: Response<Void?>) {
                    if (response.code() == 404) {
                        Toast.makeText(
                            this@SignUpActivity,
                            "Signed up successfully", Toast.LENGTH_LONG
                        ).show()
                    } else   {
                        Toast.makeText(
                            this@SignUpActivity,
                            "Already registered !", Toast.LENGTH_LONG
                        ).show()
                    }
                }

                override fun onFailure(call: Call<Void?>, t: Throwable) {
                    Toast.makeText(
                        this@SignUpActivity, t.message,
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