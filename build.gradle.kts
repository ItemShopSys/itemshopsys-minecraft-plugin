plugins {
    id("java")
    id("com.gradleup.shadow") version("8.3.3")
}

allprojects {
    apply(plugin = "java")
    apply(plugin = "com.gradleup.shadow")

    group = "dev.shiza"
    version = "1.0.1"

    repositories {
        mavenCentral()
        maven("https://storehouse.okaeri.eu/repository/maven-public/") // configs
        maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") // spigot
        maven("https://oss.sonatype.org/content/repositories/snapshots/") // bungee
        maven("https://repo.papermc.io/repository/maven-public/") // velocity
        maven("https://repo.panda-lang.org/releases") // commands
    }

    dependencies {
        compileOnly("org.jetbrains:annotations:26.0.1")
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    sourceSets {
        main {
            java.setSrcDirs(listOf("src"))
            resources.setSrcDirs(emptyList<String>())
        }

        test {
            java.setSrcDirs(emptyList<String>())
            resources.setSrcDirs(emptyList<String>())
        }
    }
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