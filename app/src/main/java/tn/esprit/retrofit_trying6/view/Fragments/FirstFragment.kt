package tn.esprit.retrofit_trying6.view.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tn.esprit.retrofit_trying6.CustomAdapter_Acceuil
import tn.esprit.retrofit_trying6.R
import tn.esprit.retrofit_trying6.model.Acceuil


class FirstFragment : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter:RecyclerView.Adapter<CustomAdapter_Acceuil.AcceuilViewHolder>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }







    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        /*
        val  a= "Un texte répond de façon plus ou moins pertinente à des critères qui en déterminent la qualité littéraire. On retient en particulier la structure d ensemble, la syntaxe et la ponctuation, l orthographe lexicale et grammaticale, la pertinence et la richesse du vocabulaire, la présence de figures de style, le registre de langue et la fonction recherchée (narrative, descriptive, expressive, argumentative, injonctive, poétique). C est l objet de l analyse littéraire.\n" +
                "Les formes anciennes du Moyen Âge désignent au xiie siècle le volume qui contient le texte sacré des Évangiles, puis au xiiie siècle, le texte original d'un livre saint ou des propos de quelqu'un. Au xviie siècle le mot s’applique au passage d'un ouvrage pris comme référence et au début du xixe siècle le mot texte a son sens général d'« écrit »6.\n"
        val b= " Le sens figuré d éléments de langage organisés et enchaînés apparaît avant l Empire romain : il désigne un agencement particulier du discours. Exemple : « epistolas texere = composer des épîtres » - Cicéron (ier siècle av. J.-C.)4 ou plus nettement chez Quintilien (ier siècle apr. J.-C.) : « verba in textu jungantur = l agencement des mots dans la phrase »5.\n" +
                "\n" +
                "Les formes anciennes du Moyen Âge désignent au xiie siècle le volume qui contient le texte sacré des Évangiles, puis au xiiie siècle, le texte original d'un livre saint ou des propos de quelqu'un. Au xviie siècle le mot s’applique au passage d'un ouvrage pris comme référence et au début du xixe siècle le mot texte a son sens général d'« écrit »6."
         */
        val r = itemView.findViewById(R.id.recyclerView2) as RecyclerView
        r.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            val list = arrayListOf<Acceuil>(

                Acceuil(R.drawable.images__4_,"Tarek ben Ridha","le complexe",
                    R.drawable.image7.toString(),"2021-12-02 17:17:03"),
                Acceuil(R.drawable.images__1_,"Riadh ben Ridha","l'antideplacement","cour8","2021-12-02 17:17:03"),
                Acceuil(R.drawable.images__3_,"Maryem ben Masoud","le complexe","cour8","2021-12-02 17:17:03"),
                Acceuil(R.drawable.images__2_,"Rim ben Salah","le deplacement","cour8","2021-12-02 17:17:03"),
                Acceuil(R.drawable.images__4_,"Riadh ben Ridha","le conique","cour8","2021-12-02 17:17:03"),
                Acceuil(R.drawable.images__3_,"Riadh ben Ridha","le complexe","cour8","2021-12-02 17:17:03"),
                Acceuil(R.drawable.images__2_,"Feryel ben hmida","Suite arithmetique","cour8","2021-12-02 17:17:03"),
                Acceuil(R.drawable.images__1_,"Ahmed ben Ridha","L'hyperbole","cour8","2021-12-02 17:17:03"),
            )
            adapter = CustomAdapter_Acceuil(list)
        }
    }










}