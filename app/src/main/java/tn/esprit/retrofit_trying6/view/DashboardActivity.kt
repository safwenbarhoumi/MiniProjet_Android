package tn.esprit.retrofit_trying6.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.NavController
import com.github.naz013.smoothbottombar.SmoothBottomBar
import com.github.naz013.smoothbottombar.Tab
import tn.esprit.retrofit_trying6.view.Fragments.FirstFragment
import tn.esprit.retrofit_trying6.view.Fragments.FourthFragment
import tn.esprit.retrofit_trying6.view.Fragments.SecondFragment
import tn.esprit.retrofit_trying6.view.Fragments.ThirdFragment
import tn.esprit.retrofit_trying6.R


class DashboardActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        //supportActionBar?.title = "Dashboard"
        //supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        supportActionBar!!.hide()

        val f1 = FirstFragment()
        val f2 = SecondFragment()
        val f3 = ThirdFragment()
        val f4 = FourthFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flfrag, f1)
            addToBackStack(null)
            commit()
        }

        findViewById<SmoothBottomBar>(R.id.bottomBar).setTabs(createTabs4())
        findViewById<SmoothBottomBar>(R.id.bottomBar).setOnTabSelectedListener { showTab(it) }

    }


    @SuppressLint("SetTextI18n")
    private fun showTab(i: Int) {
        //findViewById<TextView>(R.id.labelView).text = "Selected Tab - $i"
        //Log.d("MainActivity", "Selected Fragment : $i")

        when(i){
            0 -> {
                //findViewById<TextView>(R.id.labelView).text = "Selected ggggg Tab - $i"
                Toast.makeText(this@DashboardActivity,"azzaza",Toast.LENGTH_SHORT)
                //val m = Intent(this@DashboardActivity,AcceuilActivity::class.java)
                //startActivity(m)

                val f1 = FirstFragment()
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.flfrag, f1)
                    addToBackStack(null)
                    commit()
                }
            }
            1 -> {



                val f2 = SecondFragment()
                supportFragmentManager.beginTransaction().apply {
                        replace(R.id.flfrag, f2)
                        addToBackStack(null)
                        commit()
                    }

                //val i = Intent(this@DashboardActivity,FriendsActivity::class.java)
                //startActivity(i)
            }
            2 -> {
                //findViewById<TextView>(R.id.labelView).text = "Selected gggggg  Tab - $i"
                Toast.makeText(this@DashboardActivity,"azzaza",Toast.LENGTH_SHORT)
                val f3 = ThirdFragment()

                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.flfrag, f3)
                    addToBackStack(null)
                    commit()
                }
            }
            3 -> {
                //findViewById<TextView>(R.id.labelView).text = "Selected  gggggggTab - $i"
                //val i = Intent(this@DashboardActivity,ProfileActivity::class.java)
                //startActivity(i)

                val f4 = FourthFragment()
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.flfrag, f4)
                    addToBackStack(null)
                    commit()
                }
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.another_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.another_item_1 -> {
                Toast.makeText(this@DashboardActivity,"Another Menu Item 1 Selected",Toast.LENGTH_SHORT)
            }
            R.id.another_item_2 -> {
                Toast.makeText(this@DashboardActivity,"Another Menu Item 2 Selected",Toast.LENGTH_SHORT)
            }
            R.id.another_item_3 -> {
                Toast.makeText(this@DashboardActivity,"Another Menu Item 3 Selected",Toast.LENGTH_SHORT)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun createTabs4(): List<Tab> {
        return listOf(
            Tab(icon = R.drawable.ic_dashboard_white_24dp, title = "Acceuil"),
            Tab(icon = R.drawable.ic_multiline_chart_white_24dp, title = "Amis"),
            Tab(icon = R.drawable.ic_store_white_24dp, title = "Chat"),
            Tab(icon = R.drawable.ic_person_outline_white_24dp, title = "Profil")
        )
    }




}