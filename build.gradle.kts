// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.0.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
    id("com.google.dagger.hilt.android") version Versions.hilt apply false
    id("androidx.navigation.safeargs.kotlin") version Versions.navigation apply false
}