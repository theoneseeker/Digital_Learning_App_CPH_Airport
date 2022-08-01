package cdio.group21.digital_learning_app.ui.App

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cdio.group21.digital_learning_app.R
import cdio.group21.digital_learning_app.databinding.FragmentAnalyticsBinding
import cdio.group21.digital_learning_app.databinding.FragmentHomeBinding
import cdio.group21.digital_learning_app.ui.App.LandingScreen.RecyclerAdapterLanding

class AnalyticsFragment : Fragment() {
    private var _binding: FragmentAnalyticsBinding? = null
    private val binding get() = _binding!!



    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnalyticsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view_analytics)

        recyclerView.setHasFixedSize(true)
        var adapter = RecyclerAdapterAnalytics()
        recyclerView.adapter = adapter
    }



}