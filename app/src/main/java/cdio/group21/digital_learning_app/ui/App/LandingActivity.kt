package cdio.group21.digital_learning_app.ui.App



import android.os.Bundle
import androidx.transition.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import cdio.group21.digital_learning_app.R
import cdio.group21.digital_learning_app.databinding.ActivityLandingBinding
import cdio.group21.digital_learning_app.ui.Login.FragmentSettings
import com.google.android.material.bottomnavigation.BottomNavigationView


class LandingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLandingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingBinding.inflate(layoutInflater)




        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        /*
        val btn = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.frament) as NavHostFragment?
        val navController = navHostFragment!!.navController

        btn.setupWithNavController(navController)
        */

    }
}