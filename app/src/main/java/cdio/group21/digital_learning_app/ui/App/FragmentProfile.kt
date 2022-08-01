package cdio.group21.digital_learning_app.ui.App

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import cdio.group21.digital_learning_app.R
import cdio.group21.digital_learning_app.databinding.FragmentHomeBinding
import cdio.group21.digital_learning_app.databinding.FragmentProfileBinding
import cdio.group21.digital_learning_app.ui.util.ButtonAnimations


class FragmentProfile : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fragmentPersonalProfilePicture.setImageResource(R.drawable.woman2)

        binding.btBack.setOnClickListener(){
            ButtonAnimations.clickButton(binding.btBack)
            Handler().postDelayed({
                findNavController().popBackStack()
            }, 125)
        }


    }


}