plugins {
    id("java")
    id("com.github.hierynomus.license")
    id("com.github.sgtsilvio.gradle.utf8")
}

group = "com.hivemq.swarm.extensions"
description = "HiveMQ Swarm Hello World Extension - a simple reference for all extension developers"

/* ******************** dependencies ******************** */

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.hivemq:hivemq-swarm-extension-sdk:${property("swarm-extension-sdk.version")}")
    implementation("org.jetbrains:annotations:${property("jetbrains-annotations.version")}")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }

    withJavadocJar()
    withSourcesJar()
}

license {
    header = rootDir.resolve("HEADER")
    mapping("java", "SLASHSTAR_STYLE")
}