plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.google.gms.google-services")
    id("maven-publish")
}

android {
    namespace = "com.example.dse_xml_lib"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.dse_xml_lib"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    publishing {
        singleVariant("release")
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(platform("com.google.firebase:firebase-bom:33.7.0"))
    implementation("com.google.firebase:firebase-config-ktx")

    implementation("com.google.code.gson:gson:2.10.1")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.7.3")

    implementation("io.coil-kt:coil:2.5.0")
}
publishing {
    publications {
        create<MavenPublication>("release") {

            groupId = "com.github.Squad-01-App-Noticias"
            artifactId = "dse-xml"
            version = "v1.0.0"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}
