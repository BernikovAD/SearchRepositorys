plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.abernikov.mainscreen"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.fragment:fragment-ktx:1.6.2")

    implementation(project(":common"))
    implementation(project(":core:domain"))
    implementation(project(":core:model"))


    // Hilt
    api("com.google.dagger:hilt-android:2.50")
    implementation("com.google.dagger:hilt-android:2.50")
    kapt("com.google.dagger:hilt-android-compiler:2.50")
    //coroutines
    api("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    api("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    api("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.7.0")
    kapt("androidx.lifecycle:lifecycle-compiler:2.7.0")
    // Glide
    api("jp.wasabeef:glide-transformations:4.3.0")
    api("jp.co.cyberagent.android:gpuimage:2.1.0")
    api("com.github.bumptech.glide:glide:4.16.0")
    // SwipeRefreshLayout
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    // ShimmerLayout
    implementation("com.facebook.shimmer:shimmer:0.5.0")

    implementation("androidx.paging:paging-runtime-ktx:3.2.1")
}