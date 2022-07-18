plugins {
    id(Plugins.javaLibrary)
    id(Plugins.jetbrainsKotlinJVM)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(project(Modules.common))

    implementation(Dependencies.Collections.Domain.domainLibraries)
}
