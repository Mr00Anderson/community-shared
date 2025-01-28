plugins {
    id("java")
    id("java-library")
    id("maven-publish")
    id("eclipse")
    id("idea")
}


eclipse.project.name = "community-shared"
group = "com.nogenericgames"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

sourceSets {
    named("main") {
        java {
            srcDir("src/main/java")
            include("**/*.java")
        }
        resources {
            srcDir("src/main/resources") // Standard resource directory
            srcDir("src/main/java")      // Include this for GWT XML files in the java directory
            include("**/*.gwt.xml")      // Include only GWT XML files from the java directory
            include("**/*")              // Include all resources from the resources directory
        }
    }
}

tasks.named<Jar>("jar") {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE // or EXCLUDE, FAIL, or WARN based on your needs

    from(sourceSets["main"].resources)
    from(sourceSets["main"].java)
}

tasks.named<ProcessResources>("processResources") {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE // or EXCLUDE, FAIL, or WARN
}

val sourcesJar by tasks.registering(Jar::class) {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE // or EXCLUDE, FAIL, or WARN
    archiveClassifier.set("sources")
    from(sourceSets["main"].allSource)
    dependsOn("classes")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            groupId = "com.nogenericgames.community"
            artifactId = "community-shared"
            version = project.version.toString()
            artifact(sourcesJar.get())
        }
    }
    repositories {
        mavenLocal()
        // Uncomment and configure the following block if you need to publish to a custom Maven repository
        /*
        maven {
            name = "myRepo"
            url = uri("http://your.maven.repo.url/repository")
            credentials {
                username = project.findProperty("repoUser") as String? ?: "defaultUser"
                password = project.findProperty("repoPassword") as String? ?: "defaultPassword"
            }
        }
        */
    }
}