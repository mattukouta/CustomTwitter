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
        const val activity = "androidx.activity:activity-compose:1.3.1"
        const val appCompat = "androidx.appcompat:appcompat:1.2.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout-compose:1.0.0-alpha07"
        const val core = "androidx.core:core-ktx:1.3.2"
        const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
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

    object Mockk {
        const val mockk = "io.mockk:mockk:1.12.0"
    }

    object Plugin {
        const val gradle = "com.android.tools.build:gradle:7.0.1"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21"
        const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Hilt.version}"
        const val junit5 = "de.mannodermaus.gradle.plugins:android-junit5:1.7.1.1"
    }

    object Twitter4j {
        const val core = "org.twitter4j:twitter4j-core:4.0.7"
    }
}