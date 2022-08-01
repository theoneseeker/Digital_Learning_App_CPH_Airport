package cdio.group21.digital_learning_app.ui.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import cdio.group21.digital_learning_app.R
import cdio.group21.digital_learning_app.databinding.ActivityMainBinding
import cdio.group21.digital_learning_app.ui.App.LandingActivity


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: FragmentUsernameViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        /*
        binding.btSubmit.setOnClickListener(){
            val intent = Intent(this, LandingActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
        */

        setContentView(binding.root)


    }



}