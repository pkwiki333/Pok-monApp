plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.serialization") version "1.8.10"
    id("com.google.devtools.ksp")
    id("org.jetbrains.dokka") version "1.9.10"
}

android {
    namespace = "com.example.androidpokemonapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.androidpokemonapp"
        minSdk = 23
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("io.coil-kt:coil-compose:2.4.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.1")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.navigation:navigation-compose:2.5.3")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("io.coil-kt:coil-compose:2.4.0")
    implementation ("io.coil-kt:coil-gif:2.4.0")
    androidTestImplementation(project(mapOf("path" to ":app")))


    val roomversion = "2.5.0"
    implementation("androidx.room:room-runtime:$roomversion")
    implementation("androidx.room:room-ktx:$roomversion")
    ksp("androidx.room:room-compiler:$roomversion")
    testImplementation("androidx.room:room-testing:$roomversion")
    annotationProcessor("androidx.room:room-compiler:$roomversion")

    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    androidTestImplementation("androidx.navigation:navigation-testing:2.6.0")
    androidTestImplementation("androidx.test.espresso:espresso-intents:3.5.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    implementation("androidx.navigation:navigation-runtime-ktx:2.7.5")
    implementation("androidx.compose.material3:material3-window-size-class")

    testImplementation ("androidx.room:room-testing:2.6.1")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.0-RC2")


    testImplementation("junit:junit:4.13.2")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.0")
    testImplementation("org.mockito.kotlin:mockito-kotlin:3.2.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}