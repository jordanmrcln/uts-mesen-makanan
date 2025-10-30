plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.mesenmakanan"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.mesenmakanan"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

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
    buildFeatures {
        compose = true
    }
}

dependencies {
    // 1. Core Dependencies (Updated)
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")

    // 2. Compose Dependencies (Updated to 1.5.4+ or 1.6.x)
    // Jika Anda menggunakan Android Studio Giraffe atau Hedgehog, gunakan versi terbaru.
    implementation("androidx.compose.ui:ui:1.5.4")
    implementation("androidx.compose.material3:material3:1.1.2") // Versi Material 3 yang lebih baru
    implementation("androidx.navigation:navigation-compose:2.7.4")
    implementation(libs.ads.mobile.sdk)

    // 3. Testing Dependencies (Updated)
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1") // Sudah diperbaiki ke 3.5.1
    androidTestImplementation("androidx.navigation:navigation-testing:2.7.4")

    // 4. Debugging/Tooling
    debugImplementation("androidx.compose.ui:ui-tooling:1.5.4")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.5.4")
}
