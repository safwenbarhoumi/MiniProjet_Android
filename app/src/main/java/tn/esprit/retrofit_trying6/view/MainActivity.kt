package tn.esprit.retrofit_trying6.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Retrofit
import android.os.Bundle
import android.os.Handler
import retrofit2.converter.gson.GsonConverterFactory
import tn.esprit.retrofit_trying6.R
import tn.esprit.retrofit_trying6.api.RetrofitInterface

class MainActivity : AppCompatActivity() {
    private var retrofit: Retrofit? = null
    private var retrofitInterface: RetrofitInterface? = null
    private val BASE_URL = "http://10.0.2.2:3000"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofitInterface = retrofit!!.create(RetrofitInterface::class.java)


        Handler(mainLooper).postDelayed({
            val i = Intent(this@MainActivity, SignUpActivity::class.java)
            startActivity(i)
            finish()
        }, 3000)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }




    }


}