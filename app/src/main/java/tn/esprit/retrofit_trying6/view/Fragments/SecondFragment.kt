package tn.esprit.retrofit_trying6.view.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tn.esprit.retrofit_trying6.CustomAdapter_Friends
import tn.esprit.retrofit_trying6.R
import tn.esprit.retrofit_trying6.model.Friend


class SecondFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(tn.esprit.retrofit_trying6.R.layout.fragment_second, container, false)
    }

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter:RecyclerView.Adapter<CustomAdapter_Friends.FriendsViewHolder>? = null

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        val r = itemView.findViewById(R.id.recyclerView) as RecyclerView
        r.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            val list = arrayListOf<Friend>(
                Friend(R.drawable.image7,"ggggg", b1 = 0, b2 =0),
                Friend(R.drawable.images__1_, name = "Ahmed Ben Salah", b1 = 0, b2 = 0),
                Friend(image = R.drawable.images__2_, name = "Feryel Ben Salah", b1 = 0, b2 = 0),
                Friend(image = R.drawable.images, name = "Ali la7mer", b1 = 0, b2 = 0),
                Friend(image = R.drawable.images__3_, name = "Sirine Ben Naser", b1 = 0, b2 = 0),
                Friend(image = R.drawable.t_l_chargement, name = "Kais Ben Ridha", b1 = 0, b2 = 0),
                Friend(image = R.drawable.images__4_, name = "Rihem Ben hmida", b1 = 0, b2 = 0),
                Friend(
                    image = R.drawable.t_l_chargement__1_,
                    name = "Mohsen Ben Salah",
                    b1 = 0,
                    b2 = 0
                ),
                Friend(image = R.drawable.images__1_, name = "salah Ben Salah", b1 = 0, b2 = 0),
                Friend(image = R.drawable.images__2_, name = "salma Ben Salah", b1 = 0, b2 = 0)
            )
            adapter = CustomAdapter_Friends(list)
        }



}}