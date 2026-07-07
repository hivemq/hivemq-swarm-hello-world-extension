plugins {
    java
    alias(libs.plugins.defaults)
    alias(libs.plugins.spotless)
}

group = "com.hivemq.swarm.extensions"
description = "HiveMQ Swarm Hello World Extension - a simple reference for all extension developers"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

tasks.compileJava {
    javaCompiler = javaToolchains.compilerFor {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.hivemq.swarm.extensionSdk)
    implementation(libs.jetbrains.annotations)
}

spotless {
    java {
        licenseHeaderFile(rootDir.resolve("HEADER"))
    }
}
