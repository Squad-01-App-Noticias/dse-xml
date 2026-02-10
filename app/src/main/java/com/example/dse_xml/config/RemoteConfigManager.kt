package com.example.dse_xml.config

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.google.gson.Gson
import com.example.dse_xml.model.ScreenResponse
import kotlinx.coroutines.tasks.await

class RemoteConfigManager {

    private val remoteConfig: FirebaseRemoteConfig = FirebaseRemoteConfig.getInstance()
    private val gson = Gson()

    init {
        val configSettings = FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds(0)
            .build()

        remoteConfig.setConfigSettingsAsync(configSettings)

        remoteConfig.setDefaultsAsync(
            mapOf(
                "home_screen_config" to """
                    {
                      "screen": "home",
                      "components": []
                    }
                """.trimIndent(),
                "details_screen_config" to """
                    {
                      "screen": "details",
                      "components": []
                    }
                """.trimIndent()
            )
        )
    }

    suspend fun fetchAndActivate(): Boolean {
        return try {
            remoteConfig.fetchAndActivate().await()
        } catch (e: Exception) {
            false
        }
    }

    fun getHomeScreenConfig(): ScreenResponse? {
        return try {
            val jsonString = remoteConfig.getString("home_screen_config")
            gson.fromJson(jsonString, ScreenResponse::class.java)
        } catch (e: Exception) {
            null
        }
    }

    fun getDetailsScreenConfig(): ScreenResponse? {
        return try {
            val jsonString = remoteConfig.getString("details_screen_config")
            gson.fromJson(jsonString, ScreenResponse::class.java)
        } catch (e: Exception) {
            null
        }
    }
}
