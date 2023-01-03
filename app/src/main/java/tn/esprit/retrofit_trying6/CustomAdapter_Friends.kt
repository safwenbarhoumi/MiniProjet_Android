package tn.esprit.retrofit_trying6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tn.esprit.retrofit_trying6.api.RetrofitInterface
import tn.esprit.retrofit_trying6.model.Friend
import java.util.HashMap


class CustomAdapter_Friends(val friends: List<Friend>) : RecyclerView.Adapter<CustomAdapter_Friends.FriendsViewHolder>(){
    private var retrofit: Retrofit? = null
    private var retrofitInterface: RetrofitInterface? = null
    private val BASE_URL = "http://10.0.2.2:3000"
    private lateinit var signin : Button





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendsViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycleview_friends, parent, false)
        return FriendsViewHolder(v)
    }

    override fun onBindViewHolder(holder: FriendsViewHolder, position: Int) {
        val c = friends[position]
        holder.naame!!.text = c.name
        holder.imaage!!.setImageResource(c.image)
        holder.b1!!.text = "Suivre "
        holder.b2!!.text = "Supprimer"

        /*
        holder.itemView.setOnClickListener {
            val i = Intent(it.context, DetailActivity::class.java)
            (it.context as MainActivity).startActivity(i)
        }
       */

        holder.b1!!.setOnClickListener {
            //val i = Intent(it.context, DashboardActivity::class.java)
            //(it.context as FriendsActivity).startActivity(i)
            holder.b1!!.text = "Suivi! "
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofitInterface = retrofit!!.create(RetrofitInterface::class.java)

            val map = HashMap<String?, String?>()
            map["name"] = holder.naame!!.text.toString()
            val call = retrofitInterface!!.executeSuivre(map)
            call?.enqueue(object : Callback<Void?> {

                override fun onResponse(call: Call<Void?>, response: Response<Void?>) {
                    if (response.code() == 200) {
                        holder.b1!!.text = "Suivi"
                    } else if (response.code() == 400) {
                        holder.b1!!.text = "Suivre"
                    }
                }
                override fun onFailure(call: Call<Void?>, t: Throwable) {
                        holder.b1!!.text = "Suivre"
                }
            })
        }
        holder.b2!!.setOnClickListener {

            /*
            alert(it.context, R.string.del_edu_title, R.string.edu_prompt) {

                    Friend(it.context).eduDao()
                        .deleteOne(c[position])
                    c.removeAt(position)
                    notifyItemRemoved(position)
                }

             */

        }




    }

    override fun getItemCount(): Int {
        return friends.size

    }

    class FriendsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var naame: TextView? = null
        var imaage: ImageView? = null
        var b1 : Button? = null
        var b2 : Button? = null

        init {
            naame = itemView.findViewById(R.id.name)
            imaage = itemView.findViewById(R.id.img)
            b1 = itemView.findViewById(R.id.button)
            b2 = itemView.findViewById(R.id.button2)
        }
    }
}