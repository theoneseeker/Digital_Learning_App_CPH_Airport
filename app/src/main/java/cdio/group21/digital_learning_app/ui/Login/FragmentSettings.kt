package cdio.group21.digital_learning_app.ui.Login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import cdio.group21.digital_learning_app.databinding.FragmentSettingsBinding
import cdio.group21.digital_learning_app.ui.App.LandingActivity
import cdio.group21.digital_learning_app.ui.util.ButtonAnimations
import cdio.group21.digital_learning_app.ui.util.LocaleHelper
import java.util.*


class FragmentSettings : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.switchDarkLight.setOnCheckedChangeListener{buttonView, isChecked ->
            if(isChecked){
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
            }
            else{
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
            }

        }
        binding.langButton.setOnClickListener(){
            ButtonAnimations.clickCardView(binding.cvDanish)
            setLocale("da")
        }

        binding.cvEnglish.setOnClickListener(){
            ButtonAnimations.clickCardView(binding.cvEnglish)
            setLocale("en")
        }

        binding.tvDone.setOnClickListener(){
            ButtonAnimations.clickText(binding.tvDone)
            Handler().postDelayed({
                findNavController().popBackStack()
            }, 125)

        }
    }
    private fun setLocale(localeName: String) {
            val locale = Locale(localeName)
            val res = resources
            val dm = res.displayMetrics
            val conf = res.configuration
            conf.locale = locale
            res.updateConfiguration(conf, dm)
            val refresh = Intent(
                this.requireContext(),
                LandingActivity::class.java
            )
            refresh.putExtra("en", localeName)
            startActivity(refresh)
    }



}