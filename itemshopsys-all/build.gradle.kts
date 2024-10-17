import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("java")
}

dependencies {
    implementation(project(":itemshopsys-common"))
    implementation(project(":itemshopsys-bukkit"))
    implementation(project(":itemshopsys-bungee"))
    implementation(project(":itemshopsys-velocity"))
}

tasks.assemble {
    dependsOn("shadowJar")
}

tasks.withType<ShadowJar> {
    archiveFileName.set("itemshopsys v${project.version}.jar")
    relocate("kong.unirest", "dev.shiza.itemshopsys.libs.kong.unirest")
    relocate("com.google.gson", "dev.shiza.itemshopsys.libs.com.google.gson")
}

sourceSets {
    main {
        java.setSrcDirs(emptyList<String>())
        resources.setSrcDirs(emptyList<String>())
    }

    test {
        java.setSrcDirs(emptyList<String>())
        resources.setSrcDirs(emptyList<String>())
    }
}