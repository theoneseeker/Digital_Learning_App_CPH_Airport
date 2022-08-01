package cdio.group21.digital_learning_app.ui.Login

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import cdio.group21.digital_learning_app.R
import cdio.group21.digital_learning_app.databinding.FragmentPasswordBinding
import cdio.group21.digital_learning_app.databinding.FragmentUsernameBinding
import cdio.group21.digital_learning_app.ui.App.LandingActivity
import cdio.group21.digital_learning_app.ui.util.ButtonAnimations

class FragmentPassword : Fragment() {

    private var _binding: FragmentPasswordBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FragmentUsernameViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btPrev.setOnClickListener(){
            ButtonAnimations.clickButton(binding.btPrev)
            if(binding.password.text.isNotEmpty()) {
                viewModel.setPassword(binding.password.text.toString())
            }
            findNavController().navigate(R.id.action_fragmentPassword_to_fragmentUsername)
        }

        viewModel.getPassword().observe(viewLifecycleOwner){
            binding.password.setText(it.toString())
        }

        binding.password.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                ButtonAnimations.fadeIn(binding.btSubmit)

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })

        binding.btSubmit.setOnClickListener(){
            binding.prograssBar.visibility = View.VISIBLE
            Handler().postDelayed({
                startLandingActivity()
            }, 1000)

        }
    }


    private fun startLandingActivity(){
        val intentCreateProfile = Intent(this@FragmentPassword.requireContext(), LandingActivity::class.java)
        this.requireActivity().intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        this.requireActivity().intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY or Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intentCreateProfile)
        this.requireActivity().finish()
    }


}