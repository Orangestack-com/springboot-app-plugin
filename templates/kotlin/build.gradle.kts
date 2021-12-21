{% if inputs.spring-native %}
import org.springframework.boot.gradle.tasks.bundling.BootBuildImage
{% endif %}

plugins {
    id("org.springframework.boot") version "2.6.1"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    {% if inputs.spring-native == true %}
    id("org.springframework.experimental.aot") version "0.11.0"
    {% endif %}
    kotlin("plugin.spring") version "1.6.0"
}

repositories {
    mavenCentral()
    {% if inputs.spring-native == true %}
    maven { url = uri("https://repo.spring.io/release") }
    {% endif %}
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    {% if inputs.starter-web == true %}
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    {% endif %}
}

{% if inputs.spring-native == true %}
tasks.withType<BootBuildImage> {
    builder = "paketobuildpacks/builder:tiny"
    environment = mapOf(
        "BP_NATIVE_IMAGE" to "true"
    )
}
{% endif %}