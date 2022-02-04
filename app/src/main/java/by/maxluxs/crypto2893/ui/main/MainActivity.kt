package by.maxluxs.crypto2893.ui.main

import android.animation.ObjectAnimator
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.animation.AnticipateInterpolator
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.findNavController
import androidx.navigation.ui.navigateUp
import by.maxluxs.crypto2893.R
import by.maxluxs.crypto2893.databinding.ActivityMainBinding
import by.maxluxs.crypto2893.utils.AppBarConfigurations
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    private val mainNavController
        get() = try {
            findNavController(R.id.main_container)
        } catch (e: Exception) {
            null
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSplashScreen()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onSupportNavigateUp(): Boolean {
        return (mainNavController?.navigateUp(AppBarConfigurations.mainAppBarConfiguration) == true)
                || super.onSupportNavigateUp()
    }

    private fun setSplashScreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            setSplashScreenAnimation()
        }
        installSplashScreen()
    }

    @RequiresApi(Build.VERSION_CODES.S)
    private fun setSplashScreenAnimation() {
        splashScreen.setOnExitAnimationListener { splashScreenView ->
            val slideUp = ObjectAnimator.ofFloat(
                splashScreenView,
                View.TRANSLATION_Y,
                0f,
                -splashScreenView.height.toFloat()
            )
            slideUp.interpolator = AnticipateInterpolator()
            slideUp.duration = 300L
            slideUp.doOnEnd { splashScreenView.remove() }
            slideUp.start()
        }
        installSplashScreen()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
