package by.maxluxs.crypto2893.ui.content

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import by.maxluxs.crypto2893.R
import by.maxluxs.crypto2893.databinding.ContentFragmentBinding
import by.maxluxs.crypto2893.utils.AppBarConfigurations
import by.maxluxs.feature_converter.ui.ConverterFragment
import by.maxluxs.feature_currency_details.CurrencyDetailsFragment
import by.maxluxs.feature_currency_list.ui.CurrencyListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContentFragment : Fragment(R.layout.content_fragment) {

    private lateinit var viewModel: ContentViewModel

    private var _binding: ContentFragmentBinding? = null
    private val binding: ContentFragmentBinding get() = _binding!!

    private val mainActivity: AppCompatActivity get() = requireActivity() as AppCompatActivity

    private val navHostFragment: NavHostFragment
        get() =
            childFragmentManager.findFragmentById(R.id.main_container) as NavHostFragment

    private val navController get() = navHostFragment.navController

    private val fragmentListener = object : FragmentManager.FragmentLifecycleCallbacks() {

        override fun onFragmentResumed(fm: FragmentManager, f: Fragment) {
            when (f) {
                is CurrencyDetailsFragment -> {
                    binding.appBarLayout.setExpanded(true, true)
                    binding.bottomNavigationView.isVisible = false
                    f.setHasOptionsMenu(false)
                }
                is ConverterFragment -> {
                    binding.appBarLayout.setExpanded(false, true)
                    binding.bottomNavigationView.isVisible = true
                    f.setHasOptionsMenu(false)
                }
                is CurrencyListFragment -> {
                    binding.bottomNavigationView.isVisible = true
                    f.setHasOptionsMenu(true)
                }
                else -> {
                    binding.appBarLayout.setLiftable(true)
                    binding.bottomNavigationView.isVisible = true
                    f.setHasOptionsMenu(false)
                }
            }
            super.onFragmentResumed(fm, f)
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = ContentFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this)[ContentViewModel::class.java]
        setActionBar()
        setBottomNavigationView()
        childFragmentManager.registerFragmentLifecycleCallbacks(fragmentListener, true)
        setHasOptionsMenu(true)
    }

    private fun setActionBar() {
        mainActivity.setSupportActionBar(binding.toolbar)
        mainActivity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mainActivity.supportActionBar?.setDisplayShowHomeEnabled(true)
        NavigationUI.setupActionBarWithNavController(
            mainActivity,
            navController,
            AppBarConfigurations.mainAppBarConfiguration
        )
    }

    private fun setBottomNavigationView() {
        NavigationUI.setupWithNavController(
            binding.bottomNavigationView,
            navController
        )
    }

}
