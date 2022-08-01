package cdio.group21.digital_learning_app.ui.App

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.alpha
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import cdio.group21.digital_learning_app.R
import cdio.group21.digital_learning_app.databinding.FragmentHomeBinding
import cdio.group21.digital_learning_app.ui.App.LandingScreen.RecyclerAdapterLanding
import cdio.group21.digital_learning_app.ui.video.VideoActivity

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    private lateinit var adapter: RecyclerView.Adapter<RecyclerAdapterLanding.ViewHolder>
    private lateinit var recyclerView: RecyclerView


    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val viewPager =  activity?.findViewById<ViewPager2>(R.id.viewPager)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view_home)

        recyclerView.setHasFixedSize(true)
        var adapter = RecyclerAdapterLanding()
        recyclerView.adapter = adapter



        adapter.setOnItemClickListen(object: RecyclerAdapterLanding.onItemClickListener{
            override fun onItemClick(position: Int) {
               launchVideoActivity()
            }
        })



        binding.tvGreeting.setOnClickListener(){
            launchVideoActivity()
        }
    }

    private fun launchVideoActivity(){
        val intent = Intent(this.requireContext(), VideoActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }



}