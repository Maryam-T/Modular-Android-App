plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-kapt")
}

android{
    compileSdkVersion(AppConfig.compileSdk)
    buildToolsVersion(AppConfig.buildToolsVersion)

    defaultConfig {
        minSdkVersion(AppConfig.minSdk)
        targetSdkVersion(AppConfig.targetSdk)
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation

        javaCompileOptions.annotationProcessorOptions {
            argument("room.schemaLocation", "$projectDir/schemas")
        }

        this.buildConfigField("String", "SCHEMA_NAME", "\"myapplication_db\"")
        this.buildConfigField("int", "DATABASE_VERSION", "1")
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
        this.sourceCompatibility = Versions.javaVersion
        this.targetCompatibility = Versions.javaVersion
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
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    //Modules
    implementation(project(":data"))
    implementation(project(":domain"))
    //Database libs
    implementation(AppDependencies.databaseLibraries)
    //Database compilers
    kapt(AppDependencies.databaseCompilers)
    //Database apis
    api(AppDependencies.dataApi)
    //Test libs
    androidTestImplementation(AppDependencies.androidTestLibraries)
    testImplementation(AppDependencies.testLibraries)
}