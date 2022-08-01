package cdio.group21.digital_learning_app.ui.App

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(
   list: ArrayList<Fragment>,
   fmanager: FragmentManager,
   lifecycle: Lifecycle)
   : FragmentStateAdapter(fmanager,lifecycle){
      val fragmentList: ArrayList<Fragment> = list

   override fun getItemCount(): Int {
      return fragmentList.size
   }

   override fun createFragment(position: Int): Fragment {
      return fragmentList[position]
   }
}