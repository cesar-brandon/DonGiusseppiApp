package dongiusseppi.com

import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.VideoView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import dongiusseppi.com.databinding.ActivityMainBinding
import dongiusseppi.com.ui.home.PizzaFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val imageView: ImageView = findViewById(R.id.imageView5)

        imageView.setOnClickListener {
            // Reemplaza MiFragmento::class.java con el nombre de tu fragmento
            val fragment = PizzaFragment()
            val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()

            // Puedes agregar cualquier animación o transición aquí si lo deseas
            transaction.replace(R.id.nav_host_fragment_activity_main, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

    }
}