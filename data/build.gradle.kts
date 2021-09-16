plugins {
    id("java-library")
    id("kotlin")
    id("kotlin-kapt")
}

java {
    sourceCompatibility = Versions.javaVersion
    targetCompatibility = Versions.javaVersion
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    //Modules
    implementation(project(":domain"))
    //Data libs
    implementation(AppDependencies.dataLibraries)
    //Data compilers
    kapt(AppDependencies.dataCompilers)
    //Data api
    api(AppDependencies.dataApi)
    //Log
    implementation(project(":log"))
}