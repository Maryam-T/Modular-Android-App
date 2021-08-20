import org.gradle.api.JavaVersion

//Version constants for the Kotlin DSL dependencies
object Versions {
    //App level
    const val gradle = "4.2.0"
    const val kotlin = "1.4.31"
    val javaVersion = JavaVersion.VERSION_1_8

    //Libs
    const val coreKtx = "1.3.1"
    const val appcompat = "1.1.0"
    const val constraintLayout = "2.0.1"
    const val materialVersion = "1.3.0"
    const val gsonVersion = "2.8.6"
    const val gsonConverterVersion = "2.7.1"
    const val roomVersion = "2.2.3"
    const val lifecycleVersion = "2.3.1"
    const val daggerVersion = "2.27"
    const val glideVersion = "4.12.0"
    const val retrofitVersion = "2.6.4"
    const val okhttpVersion = "3.12.1"
    const val loggingInterceptorVersion = "4.4.0"
    const val coroutinesVersion = "1.4.3"
    const val coroutineAdapterVersion = "0.9.2"
    const val navigationVersion = "2.3.5"
    const val mapStructVersion = "1.3.1.Final"
    const val multiDexVersion = "2.0.1"
    const val rxVersion = "3.0.0"
    const val fragmentVersion = "1.3.6"

    //Test
    const val junit = "4.12"
    const val rulesVersion = "1.1.1"
    const val extJunit = "1.1.2"
    const val espresso = "3.3.0"
    const val mockito = "2.22.0"
    const val mockitoKotlin = "1.5.0"
    const val mockitoInline = "2.13.0"
    const val arch = "2.0.0"
    const val truth = "1.0.1"
    const val mockk = "1.9"
}