# MenuHub Build/Installation 

## Build the software

### Requirements
- System must have Java installed
- System must have Java in its execution path

The application is written in Java, so in order to build the software, you must install a Java jdk. That jdk must then be added to your devices execution path. Once that is done you can download or clone the repoositiory. Then you can build the application from the command line using gradle commands, or by loading the project into AndroidStudio (Android Studio is necessary for the installation). 

## Installing the software

### Requirements:
- Target for installation must run Android operating system
- Must have AndroidStudio
- Target device must have google services installed
- (There may be complecations for older versions of the Android operating system)


First you must build the software via methods explained above. Next your should generate an APK using the Build tab in android studio. Once you complete the steps to generate the apk, you can transfer the apk file to your android device. On your device, tap the transfered APK file to initiate the application installation. In the future we could release the application on the Google Play Store, in which case you would just need to locate it and download the application from there.

