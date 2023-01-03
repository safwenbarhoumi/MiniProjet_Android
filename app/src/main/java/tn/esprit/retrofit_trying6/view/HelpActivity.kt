package tn.esprit.retrofit_trying6.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tn.esprit.retrofit_trying6.R
import tn.esprit.retrofit_trying6.api.RetrofitInterface
import java.util.HashMap

class HelpActivity : AppCompatActivity() {
    private var retrofit: Retrofit? = null
    private var retrofitInterface: RetrofitInterface? = null
    private val BASE_URL = "http://10.0.2.2:3000"

    private lateinit var question : EditText
    private lateinit var btn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)

        btn = findViewById(R.id.button3)
        question = findViewById(R.id.editTextTextPersonName2)


        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofitInterface = retrofit!!.create(RetrofitInterface::class.java)

        btn.setOnClickListener {

            if(question.text.isEmpty()){
                question.error = "Write something to send  !"
                question.requestFocus()
                return@setOnClickListener
            }

            val map = HashMap<String?, String?>()
            map["question"] = question.text.toString()
            val call = retrofitInterface!!.executeQuestion(map)
            call?.enqueue(object : Callback<Void?> {
                override fun onResponse(call: Call<Void?>, response: Response<Void?>) {
                    if (response.code() == 200) {
                        val builder1 = AlertDialog.Builder(this@HelpActivity)
                        //builder1.setTitle(result!!.name)
                        builder1.setMessage("Your message is send succefully !")
                        builder1.show()
                    } else if (response.code() == 400) {
                        Toast.makeText(
                            this@HelpActivity,
                            "Please try again !", Toast.LENGTH_LONG
                        ).show()
                    }
                }
                override fun onFailure(call: Call<Void?>, t: Throwable) {
                    Toast.makeText(
                        this@HelpActivity, t.message,
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
        }





    }
}