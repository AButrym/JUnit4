plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.softserve.edu"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.softserve.edu"
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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // Unit
    testImplementation("io.mockk:mockk-android:1.14.6")
    testImplementation("io.mockk:mockk-agent:1.14.6")

    // Instrumented
    androidTestImplementation("io.mockk:mockk-android:1.14.6")
    androidTestImplementation("io.mockk:mockk-agent:1.14.6")

    // BDD style
    testImplementation("io.mockk:mockk:1.14.6")
    testImplementation("io.mockk:mockk-bdd:1.14.6")

    androidTestImplementation("io.mockk:mockk-android:1.14.6")
    androidTestImplementation("io.mockk:mockk-bdd-android:1.14.6")

    // truth
    testImplementation("com.google.truth:truth:1.4.5")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    testImplementation(kotlin("test"))
}