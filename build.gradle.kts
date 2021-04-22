plugins {
    id("java")
    id("com.github.hierynomus.license")
    id("com.github.sgtsilvio.gradle.utf8")
    id("org.asciidoctor.jvm.convert")
}

group = "com.hivemq.swarm.extensions"
description = "HiveMQ Swarm Hello World Extension - a simple reference for all extension developers"

/* ******************** dependencies ******************** */

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains:annotations:${property("jetbrains-annotations.version")}")
    implementation("io.dropwizard.metrics:metrics-core:${property("metrics-core.version")}")
    implementation("com.hivemq:hivemq-swarm-extension-sdk:${property("swarm-extension-sdk.version")}")
    testImplementation("org.junit.jupiter:junit-jupiter-api:${property("junit-jupiter.version")}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${property("junit-jupiter.version")}")
}


java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }

    withJavadocJar()
    withSourcesJar()
}

tasks.test {
    useJUnitPlatform()
}

val prepareAsciidoc by tasks.registering(Sync::class) {
    from("README.adoc").into({ temporaryDir })
}

tasks.asciidoctor {
    dependsOn(prepareAsciidoc)
    sourceDir(prepareAsciidoc.map { it.destinationDir })
}

license {
    header = rootDir.resolve("HEADER")
    mapping("java", "SLASHSTAR_STYLE")
}