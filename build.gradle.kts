plugins {
    java
    alias(libs.plugins.defaults)
    alias(libs.plugins.license)
}

group = "com.hivemq.swarm.extensions"
description = "HiveMQ Swarm Hello World Extension - a simple reference for all extension developers"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.hivemq.swarm.extensionSdk)
    implementation(libs.jetbrains.annotations)
}

license {
    header = rootDir.resolve("HEADER")
    mapping("java", "SLASHSTAR_STYLE")
}
