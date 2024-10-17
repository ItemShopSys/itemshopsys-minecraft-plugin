plugins {
    id("java")
    id("net.minecrell.plugin-yml.bungee") version("0.6.0")
}

dependencies {
    implementation(project(":itemshopsys-common"))
    implementation("eu.okaeri:okaeri-configs-yaml-bungee:5.0.5")
    compileOnly("net.md-5:bungeecord-api:1.19-R0.1-SNAPSHOT")
}

bungee {
    main = "dev.shiza.itemshopsys.bukkit.ItemShopBungeePlugin"
    name = "itemshopsys"
    version = project.version.toString()
    author = "shiza"
}