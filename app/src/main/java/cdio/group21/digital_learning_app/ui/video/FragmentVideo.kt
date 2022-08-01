package cdio.group21.digital_learning_app.ui.video


import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.media3.common.Player
import androidx.navigation.fragment.findNavController
import cdio.group21.digital_learning_app.R
import cdio.group21.digital_learning_app.databinding.FragmentFragmentVideoBinding
import cdio.group21.digital_learning_app.ui.App.LandingActivity
import cdio.group21.digital_learning_app.ui.data.Questions
import cdio.group21.digital_learning_app.ui.util.ButtonAnimations
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FragmentVideo : Fragment(), Player.Listener {

    private var _binding: FragmentFragmentVideoBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FragmentVideoViewModel by viewModels()
    private lateinit var questionArrayList:  ArrayList<Questions>
    private var countQuestion: Int = 0

    var questions = arrayOf(
        "It is good.",
        "It is bad.",
        "I love it."
    )



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFragmentVideoBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cardThumbnail.setOnClickListener(){
            findNavController().navigate(R.id.action_fragmentVideo_to_fragmentWatch)
        }


        val q2 = arrayOf(
            "Touché.",
            "Aske them nicely.",
            "Talk down to them."
        )

        loadList(questions)
        binding.tvQuestion.setText("What is security?")

        binding.listViewVideo.isClickable = true
        binding.listViewVideo.adapter = ListViewAdapterVideo(this.requireActivity(),questionArrayList)
        binding.listViewVideo.setOnItemClickListener{parent, view, position, id ->

            updateUiOnSelected()
            val question = questions[position]

            for (i in 0 until binding.listViewVideo.getChildCount()) {
                if (position == i) {
                    binding.listViewVideo.getChildAt(i).setBackgroundColor(Color.BLUE)
                } else {
                    binding.listViewVideo.getChildAt(i).setBackgroundColor(Color.TRANSPARENT)
                }
            }
        }
        binding.btSubmitVideo.setOnClickListener(){
            ButtonAnimations.clickButtonFade(binding.btSubmitVideo)

            binding.listViewVideo.clearChoices()
            binding.listViewVideo.requestLayout()
            loadList(q2)
            loadAdapter()
            viewModel.setAmount(1)
            binding.tvQuestion.setText("How do you pat down a person?")
            binding.progressBar.progress = 50
            binding.tvQuestionXOfY.text = "Question 2 of 2"
            if(countQuestion > 1) {
                binding.progressBar.progress = 100
                binding.bgTint.visibility = View.VISIBLE
                val vectorDrawable : AnimatedVectorDrawable = binding.ivCheckmark.drawable as AnimatedVectorDrawable
                vectorDrawable.start()
                CoroutineScope(Dispatchers.IO).launch {
                    viewModel.deleteCourse(1)
                }
                Handler().postDelayed({

                    startLandingActivity()
                }, 1000)
            }
        }

        viewModel.getAmount().observe(viewLifecycleOwner){
            countQuestion = it
        }
    }

    override fun onResume() {
        super.onResume()
        showSystemUI()

    }

    override fun onStart() {
        super.onStart()
        showSystemUI()
    }

    private fun showSystemUI(){
        WindowCompat.setDecorFitsSystemWindows(this.requireActivity().window, true)
        WindowInsetsControllerCompat(this.requireActivity().window,binding.linearLayVideo).let { controller ->
            controller.show(WindowInsetsCompat.Type.systemBars())
        }
    }

    private fun updateUiOnSelected(){
        ButtonAnimations.fadeIn(binding.btSubmitVideo)
    }

    private fun loadAdapter(){
        binding.listViewVideo.adapter = ListViewAdapterVideo(this.requireActivity(),questionArrayList)
    }

    private fun loadList(aList: Array<String>){
        questionArrayList = ArrayList()
        for(i in aList.indices){
            val question = Questions(aList[i],true)
            questionArrayList.add(question)
        }
        questions = aList
    }
    private fun startLandingActivity(){
        val intentCreateProfile = Intent(this@FragmentVideo.requireContext(), LandingActivity::class.java)
        this.requireActivity().intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        this.requireActivity().intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY or Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intentCreateProfile)
        this.requireActivity().finish()
    }
}