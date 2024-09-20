plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    // ksp
    alias(libs.plugins.ksp)
    // parcelize
    alias(libs.plugins.parcelize)
}

android {
    namespace = "com.example.weather"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.weather"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // MVI
    implementation("com.arkivanov.mvikotlin:mvikotlin:3.2.1")
    implementation("com.arkivanov.mvikotlin:mvikotlin-main:3.2.1")
    implementation("com.arkivanov.mvikotlin:mvikotlin-logging:3.2.1")
    implementation("com.arkivanov.mvikotlin:mvikotlin-extensions-coroutines:3.2.1")
    // decompose
    implementation("com.arkivanov.decompose:decompose:2.1.2")
    implementation("com.arkivanov.decompose:extensions-compose-jetpack:2.1.2")

    // Room
    implementation(libs.room.core)
    ksp(libs.room.compiler)

    // Dagger
    implementation(libs.dagger.core)
    ksp(libs.dagger.compiler)

    // Glide
    implementation(libs.glide.compose)

    // Retorfit
    implementation(libs.retorfit.core)
    implementation(libs.retorfit.gsonConverter)

    // Material icons
    implementation(libs.icons)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}