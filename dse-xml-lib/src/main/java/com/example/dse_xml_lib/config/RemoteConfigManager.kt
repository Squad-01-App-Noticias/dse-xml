package com.example.dse_xml_lib.config

import com.example.dse_xml_lib.model.ScreenResponse
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.google.gson.Gson
import kotlinx.coroutines.tasks.await

class RemoteConfigManager {

    private val remoteConfig: FirebaseRemoteConfig = FirebaseRemoteConfig.getInstance()
    private val gson = Gson()

    companion object {
        private const val KEY_HOME = "home_screen_config"
        private const val KEY_DETAILS = "details_screen_config"
        private const val KEY_FAVORITES = "favorites_screen_config"     }

    init {
        val configSettings = FirebaseRemoteConfigSettings.Builder()
            // Debug: 0 é ok. Se estiver dando instabilidade, sobe pra 60/300.
            .setMinimumFetchIntervalInSeconds(0)
            .build()

        remoteConfig.setConfigSettingsAsync(configSettings)

        remoteConfig.setDefaultsAsync(
            mapOf(
                KEY_HOME to """{"screen":"home","components":[]}""",
                KEY_DETAILS to """{"screen":"details","components":[]}""",
                KEY_FAVORITES to """{"screen":"favorites","components":[]}"""             )
        )
    }

    suspend fun fetchAndActivate(): Boolean {
        return try {
            remoteConfig.fetchAndActivate().await()
        } catch (_: Exception) {
            false
        }
    }

    fun getHomeScreenConfig(): ScreenResponse? = parse(KEY_HOME)

    fun getDetailsScreenConfig(): ScreenResponse? = parse(KEY_DETAILS)

    fun getFavoritesScreenConfig(): ScreenResponse? = parse(KEY_FAVORITES)

    private fun parse(key: String): ScreenResponse? {
        return try {
            val jsonString = remoteConfig.getString(key)


            if (jsonString.isBlank()) return null

            gson.fromJson(jsonString, ScreenResponse::class.java)
        } catch (_: Exception) {
            null
        }
    }
}
