plugins {
    id("java")
}

dependencies {
    implementation(project(":itemshopsys-common"))
    implementation("eu.okaeri:okaeri-configs-yaml-snakeyaml:5.0.5")
    compileOnly("com.velocitypowered:velocity-api:3.1.1")
    annotationProcessor("com.velocitypowered:velocity-api:3.1.1")
}