plugins {
    id("java-library")
    id("kotlin")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation(project(Modules.common))
    implementation(project(Modules.data))
    // domain libs
    implementation(Dependencies.domainLibraries)
}