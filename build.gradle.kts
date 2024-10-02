// Top-level build file where you can add configuration options common to all sub-projects/modules.



plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
    id("com.google.gms.google-services") version "4.4.2" apply false

}
tasks{
    register("clean", Delete::class){
            delete(rootProject.buildDir)
    }
}