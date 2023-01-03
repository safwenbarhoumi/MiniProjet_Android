package tn.esprit.retrofit_trying6

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tn.esprit.retrofit_trying6.api.RetrofitInterface
import tn.esprit.retrofit_trying6.model.Acceuil
import java.util.HashMap

class CustomAdapter_Acceuil(val acceuil: ArrayList<Acceuil>) : RecyclerView.Adapter<CustomAdapter_Acceuil.AcceuilViewHolder>() {
    private var retrofit: Retrofit? = null
    private var retrofitInterface: RetrofitInterface? = null
    private val BASE_URL = "http://10.0.2.2:3000"
    private lateinit var jaime: Button

    class AcceuilViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var naame: TextView? = null
        var tiitle: TextView? = null
        var coour: TextView? = null
        var imaage: ImageView? = null
        var b1: ImageView? = null
        var b2: ImageView? = null
        var b3: ImageView? = null
        var diislike: ImageView? = null
        var tiime: TextView? = null
        var ediitcoment: EditText? = null

        init {
            naame = itemView.findViewById(R.id.name)
            tiitle = itemView.findViewById(R.id.title)
            imaage = itemView.findViewById(R.id.img)
            b1 = itemView.findViewById(R.id.jaime)
            b2 = itemView.findViewById(R.id.coment)
            b3 = itemView.findViewById(R.id.share)
            tiime = itemView.findViewById(R.id.time)
            diislike = itemView.findViewById(R.id.dislike)
            ediitcoment = itemView.findViewById(R.id.editcoment)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AcceuilViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_recycle_view_acceuil, parent, false)
        return CustomAdapter_Acceuil.AcceuilViewHolder(v)
    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: AcceuilViewHolder, position: Int) {
        val c = acceuil[position]
        holder.naame!!.text = c.name
        holder.tiitle!!.text = c.title

        holder.imaage!!.setImageResource(c.image)
        //holder.tiime!!.text = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        holder.tiime!!.text = c.time

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofitInterface = retrofit!!.create(RetrofitInterface::class.java)

        holder.b1!!.setOnClickListener {
            //val i = Intent(it.context, DashboardActivity::class.java)
            //(it.context as FriendsActivity).startActivity(i)
            //if (holder.b1!!.text == "like") {
                //holder.b1!!.setBackgroundColor(Color.parseColor("#ff1744"))
                //holder.diislike!!.setBackgroundColor(R.drawable.radius2)
                //holder.b1!!.setTextColor(Color.parseColor("#c4001d"))
                //holder.diislike!!.setTextColor(Color.parseColor("#FF000000"))
            holder.b1!!.setImageDrawable(ContextCompat.getDrawable(it.context,R.drawable.ic_blue_like))
            holder.diislike!!.setImageDrawable(ContextCompat.getDrawable(it.context,R.drawable.ic_dislike))
                val map = HashMap<String?, String?>()
                map["name_person"] = holder.naame!!.text.toString()
                map["name_cour"] = holder.tiitle!!.text.toString()
                map["time"] = holder.tiime!!.text.toString()
                val call = retrofitInterface!!.executeJaime(map)
                call?.enqueue(object : Callback<Void?> {
                    override fun onResponse(call: Call<Void?>, response: Response<Void?>) {
                        if (response.code() == 200) {
                            //holder.b1!!.setBackgroundColor(Color.BLUE)
                            //var drawable = null
                            //holder.b1!!.setColorFilter(Color.RED)

                            //holder.b1!!.setImageDrawable(ContextCompat.getDrawable(it.context,R.drawable.ic_send))

                        } else if (response.code() == 400) {
                           // holder.b1!!.text = "like"
                        }
                    }
                    override fun onFailure(call: Call<Void?>, t: Throwable) {
                        //holder.b1!!.text = "like"
                    }
                })
            //}
            val map2 = HashMap<String?, String?>()
            map2["name_person"] = holder.naame!!.text.toString()
            map2["name_cour"] = holder.tiitle!!.text.toString()
            map2["time"] = holder.tiime!!.text.toString()
            val call2 = retrofitInterface!!.executeDislikeDelete(map2)
            call2?.enqueue(object : Callback<Void?> {
                override fun onResponse(call: Call<Void?>, response: Response<Void?>) {
                    if (response.code() == 200) {
                        //holder.diislike!!.setColorFilter(R.color.black)

                    } else if (response.code() == 400) {
                        // holder.b1!!.text = "like"
                    }
                }
                override fun onFailure(call: Call<Void?>, t: Throwable) {
                    //holder.b1!!.text = "like"
                }
            })
        }
        holder.diislike!!.setOnClickListener {
            holder.b1!!.setImageDrawable(ContextCompat.getDrawable(it.context,R.drawable.ic_like))
            holder.diislike!!.setImageDrawable(ContextCompat.getDrawable(it.context,R.drawable.ic_blue_dislike))
            val map = HashMap<String?, String?>()
            map["name_person"] = holder.naame!!.text.toString()
            map["name_cour"] = holder.tiitle!!.text.toString()
            map["time"] = holder.tiime!!.text.toString()
            val call = retrofitInterface!!.executeDislike(map)
            call?.enqueue(object : Callback<Void?> {
                override fun onResponse(call: Call<Void?>, response: Response<Void?>) {
                    if (response.code() == 200) {

                        holder.diislike!!.setColorFilter(R.color.black)
                    } else if (response.code() == 400) {
                        // holder.b1!!.text = "like"
                    }
                }
                override fun onFailure(call: Call<Void?>, t: Throwable) {
                    //holder.b1!!.text = "like"
                }
            })



        }

        holder.b2!!.setOnClickListener {

            if (!(holder.ediitcoment!!.text.isEmpty())) {
            val map = HashMap<String?, String?>()
            map["coment"] = holder.ediitcoment!!.text.toString()
            map["name_person"] = holder.naame!!.text.toString()
            map["name_cour"] = holder.tiitle!!.text.toString()
            map["time"] = holder.tiime!!.text.toString()
            val call = retrofitInterface!!.executeComment(map)
            call?.enqueue(object : Callback<Void?> {

                override fun onResponse(call: Call<Void?>, response: Response<Void?>) {
                    if (response.code() == 200) {
                        //Toast.makeText(this@CustomAdapter_Acceuil,"send it !",Toast.LENGTH_LONG)
                    } else if (response.code() == 400) {

                    }
                }

                override fun onFailure(call: Call<Void?>, t: Throwable) {

                }

            })
            holder.ediitcoment!!.setText("")
                    if (holder.ediitcoment!!.hasFocusable()){
                        holder.b2!!.setColorFilter(R.color.white)
                    }

            }
        }


    }

    override fun getItemCount(): Int {
        return acceuil.size

    }
}