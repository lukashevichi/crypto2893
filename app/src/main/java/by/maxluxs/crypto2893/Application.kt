package by.maxluxs.crypto2893

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// appComponent lives in the Application class to share its lifecycle
@HiltAndroidApp
class CryptoApplication : Application()