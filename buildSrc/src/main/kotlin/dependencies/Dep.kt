package dependencies

object Dep {
    object Accompanist {
        private const val version = "0.17.0"
        const val insets = "com.google.accompanist:accompanist-insets:$version"
        const val systemUIController = "com.google.accompanist:accompanist-systemuicontroller:$version"
    }

    object Compose {
        const val version = "1.0.1"

        const val ui = "androidx.compose.ui:ui:$version"
        const val material = "androidx.compose.material:material:$version"
        const val preview = "androidx.compose.ui:ui-tooling-preview:$version"

        const val uiTestJunit4 = "androidx.compose.ui:ui-test-junit4:$version"
        const val uiTooling = "androidx.compose.ui:ui-tooling:$version"
    }

    object Coil {
        const val coil = "io.coil-kt:coil-compose:1.3.2"
    }

    object Coroutine {
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.1"
    }

    object Jetpack {
        object Version {
            const val lifecycle = "2.3.1"
        }

        const val activity = "androidx.activity:activity-compose:1.3.1"
        const val appCompat = "androidx.appcompat:appcompat:1.2.0"
        const val coreTesting = "androidx.arch.core:core-testing:2.1.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout-compose:1.0.0-alpha07"
        const val core = "androidx.core:core-ktx:1.3.2"
        const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycle}"
        const val lifecycleLivedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifecycle}"
        const val navigationCompose = "androidx.hilt:hilt-navigation-compose:1.0.0-alpha03"
        const val paging = "androidx.paging:paging-compose:1.0.0-alpha12"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07"
    }

    object Junit5 {
        private const val version = "5.7.1"
        const val api = "org.junit.jupiter:junit-jupiter-api:$version"
        const val engine = "org.junit.jupiter:junit-jupiter-engine:$version"
    }

    object Hilt {
        const val version = "2.38.1"
        const val hiltAndroid = "com.google.dagger:hilt-android:$version"
        const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:$version"
        const val hiltLifecycle = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
        const val hiltCompiler = "androidx.hilt:hilt-compiler:1.0.0"
    }

    object KotlinTest {
        const val test = "org.jetbrains.kotlin:kotlin-test"
    }

    object Mockk {
        const val mockk = "io.mockk:mockk:1.12.0"
    }

    object Moshi {
        private const val version = "1.11.0"
        const val moshi = "com.squareup.moshi:moshi:$version"
        const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:$version"
        const val codegen = "com.squareup.moshi:moshi-kotlin-codegen:$version"
    }

    object OkHttp {
        private const val version = "4.9.0"
        const val okhttp = "com.squareup.okhttp3:okhttp:$version"
        const val logging = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    object Plugin {
        const val gradle = "com.android.tools.build:gradle:7.0.1"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21"
        const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Hilt.version}"
        const val junit5 = "de.mannodermaus.gradle.plugins:android-junit5:1.7.1.1"
    }

    object Retrofit {
        private const val version = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val converter = "com.squareup.retrofit2:converter-moshi:$version"
    }

    object Twitter4j {
        const val core = "org.twitter4j:twitter4j-core:4.0.7"
    }
}