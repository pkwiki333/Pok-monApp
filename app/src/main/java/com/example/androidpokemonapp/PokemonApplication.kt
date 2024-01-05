package com.example.androidpokemonapp

import android.app.Application
import com.example.androidpokemonapp.data.AppContainer
import com.example.androidpokemonapp.data.AppContainerImpl

/**
 * The [Application] class for the Android Pokemon App. It initializes the [AppContainer] for managing app-level dependencies.
 */
class PokemonApplication : Application(){
    lateinit var container: AppContainer

    /**
     * Called when the application is starting. Initializes the [AppContainer] using the application context.
     */
    override fun onCreate() {
        super.onCreate()
        container = AppContainerImpl(applicationContext)
    }
}