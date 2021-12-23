plugins {
    id("org.springframework.boot") version "2.5.7"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("plugin.spring") version "1.6.10"
}

repositories {
    mavenCentral()
}

dependencies {
    {% if inputs.starter_web %}
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    {% else %}
    implementation("org.springframework.boot:spring-boot-starter")
    {% endif %}
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}