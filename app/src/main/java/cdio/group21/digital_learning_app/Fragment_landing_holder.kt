package cdio.group21.digital_learning_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import cdio.group21.digital_learning_app.databinding.FragmentHomeBinding
import cdio.group21.digital_learning_app.databinding.FragmentLandingHolderBinding
import cdio.group21.digital_learning_app.ui.util.ButtonAnimations


class Fragment_landing_holder : Fragment() {


    private var _binding: FragmentLandingHolderBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLandingHolderBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val navHost = childFragmentManager.findFragmentById(binding.frament.id) as NavHostFragment
        val navController = navHost.navController
        binding.bottomNavView.setupWithNavController(navController)

        binding.ivSettings.setOnClickListener(){
            ButtonAnimations.clickImageButton(binding.ivSettings)
            findNavController().navigate(R.id.action_fragment_landing_holder2_to_fragmentSettings)
        }

        binding.ivProfile.setOnClickListener(){
            ButtonAnimations.clickImageButton(binding.ivProfile)
            findNavController().navigate(R.id.action_fragment_landing_holder2_to_fragmentProfile2)
        }
    }


}