rootProject.name = "hivemq-swarm-hello-world-extension"

pluginManagement {
    plugins {
        id("io.github.sgtsilvio.gradle.defaults") version "${extra["plugin.defaults.version"]}"
        id("com.github.hierynomus.license") version "${extra["plugin.license.version"]}"
    }
}