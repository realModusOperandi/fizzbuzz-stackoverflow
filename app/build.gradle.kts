plugins {
    application
}

repositories {
    jcenter()
}

dependencies {
    testImplementation("org.junit.jupiter","junit-jupiter-api", "5.6.2")
    testRuntimeOnly("org.junit.jupiter", "junit-jupiter-engine")

    implementation("com.squareup.okhttp3", "okhttp", "4.9.0")
    implementation("org.jsoup", "jsoup", "1.13.1")
}

application {
    mainClass.set("fizzbuzz.so.App")
}

tasks.jar {
    manifest {
        attributes(
            Pair("Main-Class", "fizzbuzz.so.App")
        )
    }

    from (
        Callable { configurations["runtimeClasspath"].map { if (it.isDirectory) it else zipTree(it) } }
    )
}

tasks.test {
    useJUnitPlatform()
}
