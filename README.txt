OVA APP BUILDER V12 - Android project (WebView).
Build: upload to GitHub (Actions builds a debug APK automatically) or open in Android Studio > Build APK, or run: gradle assembleDebug
Debug APK: signed with a debug key, installable for testing, NOT for Google Play.
Release APK: create your own keystore (keytool -genkey -v -keystore my.jks -alias key -keyalg RSA -keysize 2048 -validity 10000), add a signingConfig in app/build.gradle, run gradle assembleRelease. Keep the keystore safe.
