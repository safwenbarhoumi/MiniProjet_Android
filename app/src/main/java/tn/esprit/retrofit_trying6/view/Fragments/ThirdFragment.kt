package tn.esprit.retrofit_trying6.view.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tn.esprit.retrofit_trying6.CustomAdapterChat
import tn.esprit.retrofit_trying6.CustomAdapter_Acceuil
import tn.esprit.retrofit_trying6.CustomAdapter_Friends
import tn.esprit.retrofit_trying6.R
import tn.esprit.retrofit_trying6.model.Chat
import tn.esprit.retrofit_trying6.model.Friend

class ThirdFragment : Fragment() {
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<CustomAdapter_Acceuil.AcceuilViewHolder>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val r = view.findViewById(R.id.recyclerView3) as RecyclerView
        r.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            val list = arrayListOf<Chat>(
                Chat(image = R.drawable.images__2_, name = "Feryel Ben Salah"),
                Chat(image = R.drawable.images, name = "Ali la7mer"),
                Chat(image = R.drawable.images__3_, name = "Sirine Ben Naser"),
                Chat(image = R.drawable.t_l_chargement, name = "Kais Ben Ridha"),
                Chat(image = R.drawable.images__4_, name = "Rihem Ben hmida"),
                Chat(image = R.drawable.t_l_chargement__1_, name = "Mohsen Ben Salah"),
                Chat(image = R.drawable.images__1_, name = "salah Ben Salah"),
                Chat(image = R.drawable.images__2_, name = "salma Ben Salah")
            )
            adapter = CustomAdapterChat(list)
        }

    }


}