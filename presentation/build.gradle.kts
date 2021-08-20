plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-android")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(AppConfig.compileSdk)
    buildToolsVersion(AppConfig.buildToolsVersion)

    defaultConfig {
        minSdkVersion(AppConfig.minSdk)
        targetSdkVersion(AppConfig.targetSdk)
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidCustomTestInstrumentation
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
    implementation(project(":domain"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    //Presentation compilers
    kapt(AppDependencies.presentationCompilers)
    //Presentation libs
    implementation(AppDependencies.presentationLibraries)
    //Test libs
    testImplementation(AppDependencies.testLibraries)
    androidTestImplementation(AppDependencies.androidTestLibraries)
    debugImplementation(AppDependencies.debugLibraries)
}