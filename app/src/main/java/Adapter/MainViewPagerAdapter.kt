package Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.saram.anon.LocationFragment
import com.saram.anon.LoginFragment
import com.saram.anon.RecyclerFragment

//import com.saram.anon.fra.*

class MainViewPagerAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> LocationFragment()
            1 -> RecyclerFragment()
            else -> LoginFragment()
        }
    }
}