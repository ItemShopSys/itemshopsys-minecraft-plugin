plugins {
    id("java-library")
}

dependencies {
    api("com.konghq:unirest-java:3.14.1")
    compileOnly("eu.okaeri:okaeri-configs-core:5.0.5")
    compileOnly("dev.rollczi:litecommands-annotations:3.7.0")
}