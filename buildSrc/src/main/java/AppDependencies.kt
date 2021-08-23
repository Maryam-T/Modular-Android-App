import org.gradle.api.artifacts.dsl.DependencyHandler

object AppDependencies {
    //STD
    private const val kotlinStd = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    //Android UI
    private const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    private const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    private const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    private const val material = "com.google.android.material:material:${Versions.materialVersion}"
    private const val navigationUi =
        "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"
    private const val navigation =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
    private const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
    private const val glideOkHttpIntegration = "com.github.bumptech.glide:okhttp3-integration:${Versions.glideVersion}"
    private const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glideVersion}"

    //Lifecycle
    private const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
    private const val lifecycleLiveData =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"
    private const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"

    //Dagger2
    private const val daggerGroupId = "com.google.dagger"
    private const val dagger = "$daggerGroupId:dagger:${Versions.daggerVersion}"
    private const val daggerCompiler = "$daggerGroupId:dagger-compiler:${Versions.daggerVersion}"

    //Database
    private const val roomKotlin = "androidx.room:room-ktx:${Versions.roomVersion}"
    private const val roomTest = "androidx.room:room-testing:${Versions.roomVersion}"
    private const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    private const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"

    //Remote
    private const val retrofitGroupId = "com.squareup.retrofit2"
    private const val retrofitConverter =
        "$retrofitGroupId:converter-gson:${Versions.retrofitVersion}"
    private const val retrofit = "$retrofitGroupId:retrofit:${Versions.retrofitVersion}"
    private const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okhttpVersion}"
    private const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptorVersion}"

    //Coroutines
    const val coroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"
    const val coroutineTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesVersion}"
    const val coroutineCallAdapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.coroutineAdapterVersion}"

    //Rx
    const val rxJava = "io.reactivex.rxjava3:rxjava:${Versions.rxVersion}"
    const val rxAndroid = "io.reactivex.rxjava3:rxandroid:${Versions.rxVersion}"

    //Gson
    private const val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"
    private const val gsonConverterFactory = "com.squareup.retrofit2:converter-gson:${Versions.gsonConverterVersion}"

    //MapStruct
    const val mapStruct = "org.mapstruct:mapstruct:${Versions.mapStructVersion}"
    const val mapStructAnnotation =
        "org.mapstruct:mapstruct-processor:${Versions.mapStructVersion}"

    //Multidex
    private const val multiDex = "androidx.multidex:multidex:${Versions.multiDexVersion}"

    //Test
    private const val junit = "junit:junit:${Versions.junit}"
    private const val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    private const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    private const val espressoContrib = "androidx.test.espresso:espresso-contrib:${Versions.espresso}"
    private const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    private const val mockitoKotlin = "com.nhaarman:mockito-kotlin-kt1.1:${Versions.mockitoKotlin}"
    private const val mockitoAndroid = "org.mockito:mockito-android:${Versions.mockito}"
    private const val mockitoInline = "org.mockito:mockito-inline:${Versions.mockitoInline}"
    private const val junitKotlin = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"
    private const val arch = "androidx.arch.core:core-testing:${Versions.arch}"
    private const val truth = "com.google.truth:truth:${Versions.truth}"
    private const val navTest = "androidx.navigation:navigation-testing:${Versions.navigationVersion}"
    private const val fragmentTest = "androidx.fragment:fragment-testing:${Versions.fragmentVersion}"
    private const val rule = "androidx.test:rules:${Versions.rulesVersion}"
    private const val runner = "androidx.test:runner:${Versions.rulesVersion}"
    private const val mockk = "io.mockk:mockk:${Versions.mockk}"

    val appLibraries = arrayListOf<String>().apply {
        add(kotlinStd)
        add(coreKtx)
        add(appcompat)
        add(constraintLayout)
        add(material)
        add(navigationUi)
        add(navigation)
        add(glide)
        add(glideOkHttpIntegration)
        add(lifecycleViewModel)
        add(lifecycleLiveData)
        add(lifecycleRuntime)
        add(dagger)
        add(mapStruct)
        add(mapStructAnnotation)
        add(multiDex)
        add(coroutineCallAdapter)
        add(retrofitConverter)
        add(retrofit)
        add(okHttp)
        add(loggingInterceptor)
        add(gson)
        add(gsonConverterFactory)
        add(rxJava)
        add(rxAndroid)
    }

    val appCompilers = arrayListOf<String>().apply {
        add(glideCompiler)
        add(roomCompiler)
        add(daggerCompiler)
    }

    val presentationLibraries = arrayListOf<String>().apply {
        add(kotlinStd)
        add(coreKtx)
        add(appcompat)
        add(material)
        add(lifecycleViewModel)
        add(lifecycleLiveData)
        add(lifecycleRuntime)
        add(dagger)
        add(mapStruct)
        add(mapStructAnnotation)
        add(multiDex)
        add(rxJava)
        add(rxAndroid)
    }

    val presentationCompilers = arrayListOf<String>().apply {
        add(daggerCompiler)
    }

    val domainLibraries = arrayListOf<String>().apply {
        add(kotlinStd)
        add(coreKtx)
        add(appcompat)
        add(coroutines)
        add(coroutinesAndroid)
        add(dagger)
    }

    val dataLibraries = arrayListOf<String>().apply {
        add(kotlinStd)
        add(coreKtx)
        add(appcompat)
        add(retrofitConverter)
        add(retrofit)
        add(okHttp)
        add(roomKotlin)
        add(roomTest)
        add(roomRuntime)
        add(gson)
        add(dagger)
    }

    val dataApi = arrayListOf<String>().apply {
        add(roomRuntime)
    }

    val dataCompilers = arrayListOf<String>().apply {
        add(roomCompiler)
    }

    val databaseLibraries = arrayListOf<String>().apply {
        add(kotlinStd)
        add(coreKtx)
        add(appcompat)
        add(roomKotlin)
        add(roomTest)
        add(gson)
        add(dagger)
    }

    val databaseApi = arrayListOf<String>().apply {
        add(roomRuntime)
    }

    val databaseCompilers = arrayListOf<String>().apply {
        add(roomCompiler)
        add(daggerCompiler)
    }

    val remoteLibraries = arrayListOf<String>().apply {
        add(kotlinStd)
        add(coreKtx)
        add(gson)
        add(gsonConverterFactory)
        add(retrofitConverter)
        add(retrofit)
        add(okHttp)
        add(dagger)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(extJUnit)
        add(espressoCore)
        add(espressoContrib)
        add(truth)
        add(coroutineTest)
        add(arch)
        add(navTest)
        add(rule)
        add(runner)
        add(mockitoAndroid)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(junit)
        add(mockito)
        add(arch)
        add(mockitoKotlin)
        add(junitKotlin)
        add(mockitoInline)
        add(truth)
        add(coroutineTest)
        add(coroutines)/////////////////
        add(mockk)
    }

    val debugLibraries = arrayListOf<String>().apply {
        add(fragmentTest)
    }
}

//Util functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.api(list: List<String>) {
    list.forEach { dependency ->
        add("api", dependency)
    }
}

fun DependencyHandler.annotationProcessor(list: List<String>) {
    list.forEach { dependency ->
        add("annotationProcessor", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}

fun DependencyHandler.debugImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("debugImplementation", dependency)
    }
}
