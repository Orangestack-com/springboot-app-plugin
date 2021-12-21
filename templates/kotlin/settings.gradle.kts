{% if inputs.spring-native == true %}
pluginManagement {
    repositories {
        maven { url = uri("https://repo.spring.io/release") }
        gradlePluginPortal()
    }
}
{% endif %}