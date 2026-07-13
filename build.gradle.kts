buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.12.3") // Use the latest stable version
        classpath("com.google.gms:google-services:4.4.2") // Google Services plugin
        classpath("com.google.firebase:firebase-crashlytics-gradle:3.0.2") // Firebase Crashlytics plugin
    }
}
