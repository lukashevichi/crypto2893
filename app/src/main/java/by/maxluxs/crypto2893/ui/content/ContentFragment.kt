package by.maxluxs.crypto2893.ui.content

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import by.maxluxs.crypto2893.R
import by.maxluxs.crypto2893.databinding.ActivityMainBinding
import by.maxluxs.crypto2893.databinding.ContentFragmentBinding
import by.maxluxs.crypto2893.utils.AppBarConfigurations

class ContentFragment : Fragment(R.layout.content_fragment) {

    private lateinit var viewModel: ContentViewModel

    private var _binding: ContentFragmentBinding? = null
    private val binding: ContentFragmentBinding get() = _binding!!

    private val mainActivity: AppCompatActivity get() = requireActivity() as AppCompatActivity

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = ContentFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this)[ContentViewModel::class.java]
        setActionBar()
        setBottomNavigationView()
    }

    private fun setActionBar() {
        mainActivity.setSupportActionBar(binding.toolbar)
        mainActivity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mainActivity.supportActionBar?.setDisplayShowHomeEnabled(true)
        setHasOptionsMenu(true)
    }

    private fun setBottomNavigationView() {
        val navHostFragment: NavHostFragment =
            childFragmentManager.findFragmentById(R.id.main_container) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(
            binding.bottomNavigationView,
            navController
        )
        NavigationUI.setupActionBarWithNavController(
            mainActivity,
            navController,
            AppBarConfigurations.mainAppBarConfiguration
        )
    }

}