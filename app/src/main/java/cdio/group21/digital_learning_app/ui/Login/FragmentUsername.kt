package cdio.group21.digital_learning_app.ui.Login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import cdio.group21.digital_learning_app.R
import cdio.group21.digital_learning_app.databinding.FragmentHomeBinding
import cdio.group21.digital_learning_app.databinding.FragmentUsernameBinding
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import cdio.group21.digital_learning_app.ui.data.user
import cdio.group21.digital_learning_app.ui.util.ButtonAnimations
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class FragmentUsername : Fragment() {

    private val viewModel: FragmentUsernameViewModel by activityViewModels()

    private var _binding: FragmentUsernameBinding? = null
    private val binding get() = _binding!!

    private lateinit var db: FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUsernameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btNext.setOnClickListener(){
            ButtonAnimations.clickButton(binding.btNext)
            viewModel.setUsername(binding.username.text.toString())
            findNavController().navigate(R.id.action_fragmentUsername_to_fragmentPassword)


        }

        binding.username.addTextChangedListener() {
            if(it.toString().isNotEmpty()){
                ButtonAnimations.fadeIn(binding.btNext)

                Log.d("Empty", "Empty")
            }
            else{
                ButtonAnimations.fadeOut(binding.btNext)

                Log.d("not", "not")
            }
        }

        viewModel.getUsername().observe(viewLifecycleOwner){
            binding.username.setText(it.toString())
        }
    }



}