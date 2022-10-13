plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version("7.1.2")
}

group = "me.cryptforge"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.fusesource.jansi:jansi:2.4.0")
}

tasks.shadowJar {
    manifest {
        attributes(
            "Main-Class" to "me.cryptforge.Main"
        )
    }
}