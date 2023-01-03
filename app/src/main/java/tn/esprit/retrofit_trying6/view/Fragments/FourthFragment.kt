package tn.esprit.retrofit_trying6.view.Fragments

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.media.Image
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tn.esprit.retrofit_trying6.view.HelpActivity
import tn.esprit.retrofit_trying6.view.LoginActivity
import tn.esprit.retrofit_trying6.R
import tn.esprit.retrofit_trying6.api.RetrofitInterface


class FourthFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




         lateinit var help : ImageView
         lateinit var other : ImageView
         lateinit var gallery : ImageButton
        lateinit var gallery2 : ImageView
         val pickImage = 100
         var imageUri: Uri? = null
         lateinit var arch : TextView

         var retrofit: Retrofit? = null
         var retrofitInterface: RetrofitInterface? = null
         val BASE_URL = "http://10.0.2.2:3000"
         lateinit var signin : Button
        //@SuppressLint("MissingInflatedId")
        @SuppressLint("MissingInflatedId")
        @RequiresApi(Build.VERSION_CODES.O)




        arch = view.findViewById(R.id.archive)

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofitInterface = retrofit!!.create(RetrofitInterface::class.java)

        help = view.findViewById(R.id.help)
        help.setOnClickListener {
            //Toast.makeText(this@ProfileActivity,"azertyuioiutre",Toast.LENGTH_SHORT)
            //val i = Intent(this@FourthFragment, HelpActivity::class.java)
            //startActivity(i)
            //findNavController().navigate(R.id.action_from_fragmentA_to_fragmentB)

            activity.let {
                val intent = Intent(it, HelpActivity::class.java)
                startActivity(intent)
            }
        }
        other = view.findViewById(R.id.drop_down_option_menu)
        other.setOnClickListener {
            //val builder1 = AlertDialog.Builder(it.context)
            //builder1.setNegativeButtonIcon()
            //val a: AlertDialog = AlertDialog.Builder(it.context)
            val a = AlertDialog.Builder(it.context)
                .setTitle("Déconnecté ?")
                //.setView(layoutInflater.inflate(R.layout.fragment, null))
                .setPositiveButton("Ok", DialogInterface.OnClickListener { dialog, which ->
                    activity.let {
                        val intent = Intent(it, LoginActivity::class.java)
                        startActivity(intent)
                        activity?.finish()
                    }

                // ok button
                })
            a.show()

        }

        gallery = view.findViewById(R.id.user_profile_photo)
        gallery2 = view.findViewById(R.id.header_cover_image)

        gallery2.setOnClickListener {
            //gallery.with(this).galleryOnly().galleryMimeTypes(arrayOf("image/*")).crop()
            //  .maxResultSize(400, 400).start()
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)


            val map = HashMap<String?, String?>()
            //gallery2  = Base64.getEncoder().encode(gallery2)
            //map["image"] = gallery2.drawable.toString() + "imagecode"
            map["image"] = arch.text.toString()
            val call = retrofitInterface!!.executeimage(map)
            call?.enqueue(object : Callback<Void?> {
                override fun onResponse(call: Call<Void?>, response: Response<Void?>) {
                    if (response.code() == 200) {
                        Toast.makeText(
                            it.context, "Importation...",
                            Toast.LENGTH_LONG
                        ).show()
                    } else if (response.code() == 400) {

                    }
                }

                override fun onFailure(call: Call<Void?>, t: Throwable) {

                }
            })
        }
        gallery.setOnClickListener {
            //gallery.with(this).galleryOnly().galleryMimeTypes(arrayOf("image/*")).crop()
            //  .maxResultSize(400, 400).start()
            val gallery2 = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery2, pickImage)

            val map = HashMap<String?, String?>()

            map["image"] = gallery2.toString()
            val call = retrofitInterface!!.executeimage(map)
            call?.enqueue(object : Callback<Void?> {
                override fun onResponse(call: Call<Void?>, response: Response<Void?>) {
                    if (response.code() == 200) {

                    } else if (response.code() == 400) {

                    }
                }

                override fun onFailure(call: Call<Void?>, t: Throwable) {

                }
            })
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        lateinit var gallery : ImageButton
        lateinit var gallery2 : ImageView
        gallery = view?.findViewById(R.id.user_profile_photo)!!
        gallery2 = requireView().findViewById(R.id.header_cover_image)!!
        val pickImage = 100
        var imageUri: Uri? = null
        if (resultCode == AppCompatActivity.RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            gallery.setImageURI(imageUri)
            gallery2.setImageURI(imageUri)
        }


    }


    /*
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val pickImage = 100
        if (resultCode == AppCompatActivity.RESULT_OK && requestCode == pickImage) {
            val imageUri = data?.data
            gallery = view.findViewById(R.id.user_profile_photo)
            gallery2 = view.findViewById(R.id.header_cover_image)
            gallery.setImageURI(imageUri)
            gallery2.setImageURI(imageUri)
        }
    }

     */


























    }


