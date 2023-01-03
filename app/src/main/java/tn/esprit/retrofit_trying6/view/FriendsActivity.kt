package tn.esprit.retrofit_trying6.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Retrofit
import tn.esprit.retrofit_trying6.CustomAdapter_Friends
import tn.esprit.retrofit_trying6.R
import tn.esprit.retrofit_trying6.api.RetrofitInterface
import tn.esprit.retrofit_trying6.model.Friend

class FriendsActivity : AppCompatActivity() {
    private var retrofit: Retrofit? = null
    private var retrofitInterface: RetrofitInterface? = null
    private val BASE_URL = "http://10.0.2.2:3000"

    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_second)


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this@FriendsActivity, LinearLayoutManager.VERTICAL, false)
        val list = arrayListOf<Friend>(
            Friend(image = R.drawable.images__1_, name = "Ahmed Ben Salah", b1 = 0, b2 = 0),
            Friend(image = R.drawable.images__2_, name = "Feryel Ben Salah", b1 = 0, b2 = 0),
            Friend(image = R.drawable.images, name = "Ali la7mer", b1 = 0, b2 = 0)
        )

        recyclerView.adapter = CustomAdapter_Friends(list)




        val view = layoutInflater.inflate(R.layout.recycleview_friends, null)
        val b1: Button = view.findViewById(R.id.button)
        b1.setOnClickListener {
            val i = Intent(this@FriendsActivity, DashboardActivity::class.java)
            startActivity(i)
        }

    }

}
