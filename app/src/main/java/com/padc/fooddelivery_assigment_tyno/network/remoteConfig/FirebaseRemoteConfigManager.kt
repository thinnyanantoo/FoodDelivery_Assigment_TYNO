package com.padc.fooddelivery_assigment_tyno.network.remoteConfig

import android.util.Log
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings

object FirebaseRemoteConfigManager {

    private val remoteConfig = Firebase.remoteConfig
    init {
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 0
        }
        remoteConfig.setConfigSettingsAsync(configSettings)
    }

    fun setUpRemoteConfigWithDefaultValues(){
        val defaultValues : Map<String, Any> = hashMapOf(
        "homefragmentlayout" to 0)
        remoteConfig.setDefaultsAsync(defaultValues)
    }

    fun fetchRemoteConfigs(){
        remoteConfig.fetch()
            .addOnCompleteListener { task ->
                if(task.isSuccessful){
                    Log.d("Firebase","Firebase Remote Config fetch success")
                    remoteConfig.activate().addOnCompleteListener {
                        Log.d("Firebase","Firebase Remote Confit activitated")
                    }
                } else {
                    Log.d("Firebase","Firebase Remote Config Fetch Failed")
                }
            }
    }

    fun getScreenLayout() : String {
        return remoteConfig.getValue("homefragmentlayout").asString()
    }
}