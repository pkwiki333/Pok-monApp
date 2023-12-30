package com.example.androidpokemonapp

import android.app.Application
import com.example.androidpokemonapp.data.AppContainer
import com.example.androidpokemonapp.data.AppContainerImpl

class PokemonApplication : Application(){
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainerImpl(applicationContext)
    }
}