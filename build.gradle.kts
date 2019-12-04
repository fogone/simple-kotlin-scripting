plugins {
    kotlin("jvm") version "1.3.61"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("scripting-jvm"))
    implementation(kotlin("scripting-jvm-host-embeddable"))
    implementation(kotlin("script-util"))

    testImplementation("junit:junit:4.12")
}


java {
    sourceSets {
        main {
            resources.srcDir("${projectDir}/scripts")
        }
    }
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}
