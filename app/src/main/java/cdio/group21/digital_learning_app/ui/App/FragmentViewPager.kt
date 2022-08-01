package cdio.group21.digital_learning_app.ui.App

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cdio.group21.digital_learning_app.R
import cdio.group21.digital_learning_app.databinding.ActivityLandingBinding.inflate
import cdio.group21.digital_learning_app.databinding.FragmentViewPagerBinding


class FragmentViewPager : Fragment() {

    private var _binding: FragmentViewPagerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        val fragmentList = arrayListOf<Fragment>(
            HomeFragment(),
            AnalyticsFragment()
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )
        binding.viewPager.adapter = adapter
        return binding.root
    }


}