plugins {
	id("org.gradle.toolchains.foojay-resolver-convention") version "0.9.0"
}

rootProject.name = "itemshopsys-minecraft-plugin"
include(":itemshopsys-all")
include(":itemshopsys-common")
include(":itemshopsys-bukkit")
include(":itemshopsys-bungee")
include(":itemshopsys-velocity")
