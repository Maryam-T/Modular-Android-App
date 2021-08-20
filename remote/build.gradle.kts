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
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")
    //Modules
    implementation(project(":data"))
    implementation(project(":domain"))
    //Remote libs
    implementation(AppDependencies.remoteLibraries)
    //Test libs
    testImplementation(AppDependencies.testLibraries)
}