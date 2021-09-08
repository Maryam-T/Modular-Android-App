plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(AppConfig.compileSdk)
    buildToolsVersion(AppConfig.buildToolsVersion)

    defaultConfig {
        applicationId = "com.marand.myapplication"
        minSdkVersion(AppConfig.minSdk)
        targetSdkVersion(AppConfig.targetSdk)
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        multiDexEnabled = true
        testInstrumentationRunner = AppConfig.androidTestInstrumentation

        //It's better to put API_KEY inside gradle.properties, then add that file to .gitignore
        buildConfigField("String", "API_KEY", "\"cbf685b69c1ecfe61f8a010f0b4a8c9e\"")
        buildConfigField("String", "BASE_URL", "\"https://jsonplaceholder.typicode.com/\"")
    }
    buildTypes {
        getByName("release") {
            this.isMinifyEnabled = false
            this.proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = Versions.javaVersion
        targetCompatibility = Versions.javaVersion
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    /*configurations {
        implementation {exclude(group="org.jetbrains" , module="annotations")}
    }*/
    packagingOptions {
//        exclude("META-INF/gradle/incremental.annotation.processors")
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    //Modules
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":remote"))
    implementation(project(":database"))
    implementation(project(":presentation"))
    //App compilers
    kapt(AppDependencies.appCompilers)
    //App libs
    implementation(AppDependencies.appLibraries)
    //Test libs
    testImplementation(AppDependencies.testLibraries)
    androidTestImplementation(AppDependencies.androidTestLibraries)
    debugImplementation(AppDependencies.debugLibraries)
}