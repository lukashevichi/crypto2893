package by.maxluxs.crypto2893

import android.app.Application
import by.maxluxs.crypto2893.di.DaggerApplicationComponent

// appComponent lives in the Application class to share its lifecycle
class CryptoApplication : Application() {
    // Reference to the application graph that is used across the whole app
    val appComponent = DaggerApplicationComponent.create()
}