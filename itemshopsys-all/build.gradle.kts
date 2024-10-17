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
    relocate("com.google", "dev.shiza.itemshopsys.libs.com.google")
    relocate("eu.okaeri", "dev.shiza.itemshopsys.libs.eu.okaeri")
    relocate("org.yaml", "dev.shiza.itemshopsys.libs.org.yaml")
    relocate("org.apache", "dev.shiza.itemshopsys.libs.org.apache")
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