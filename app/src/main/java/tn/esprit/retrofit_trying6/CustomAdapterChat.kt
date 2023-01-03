package tn.esprit.retrofit_trying6

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tn.esprit.retrofit_trying6.api.RetrofitInterface
import tn.esprit.retrofit_trying6.model.Chat
import tn.esprit.retrofit_trying6.model.Friend
import tn.esprit.retrofit_trying6.view.Chat_InsideActivity
import tn.esprit.retrofit_trying6.view.DashboardActivity
import tn.esprit.retrofit_trying6.view.Fragments.ThirdFragment
import tn.esprit.retrofit_trying6.view.RecycleViewChat
import java.security.AccessController.getContext

class CustomAdapterChat (val chat: ArrayList<Chat>): RecyclerView.Adapter<CustomAdapterChat.ChatViewHolder>(){

    private var retrofit: Retrofit? = null
    private var retrofitInterface: RetrofitInterface? = null
    private val BASE_URL = "http://10.0.2.2:3000"
    private lateinit var jaime: Button

    class ChatViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView)  {
        var imaage: ImageView? = null
        var name: TextView? = null
        var card:CardView? = null
        init {
            name = itemView.findViewById(R.id.name2)
            imaage = itemView.findViewById(R.id.img2)
            card = itemView.findViewById(R.id.card_chat)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.chat_recycleview, parent, false)
        return CustomAdapterChat.ChatViewHolder(v)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val c = chat[position]
        holder.name!!.text = c.name
        holder.imaage!!.setImageResource(c.image)

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofitInterface = retrofit!!.create(RetrofitInterface::class.java)

        holder.card!!.setOnClickListener {
            val i = Intent(it.context, Chat_InsideActivity::class.java)
            (it.context as ThirdFragment).startActivity(i)



        }


    }

    override fun getItemCount(): Int {
        return chat.size
    }
}