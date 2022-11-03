import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://hyperledger.jfrog.io/hyperledger/besu-maven")
        content { includeGroupByRegex("org\\.hyperledger\\..*") }
    }
    maven {
        url = uri("https://artifacts.consensys.net/public/maven/maven/")
        content { includeGroupByRegex("tech\\.pegasys\\..*") }
    }
    maven {
        url = uri("https://dl.cloudsmith.io/public/consensys/quorum-mainnet-launcher/maven/")
        content { includeGroupByRegex("net\\.consensys\\..*") }
    }
    maven {
        url = uri("https://splunk.jfrog.io/splunk/ext-releases-local")
        content { includeGroupByRegex("com\\.splunk\\..*") }
    }

    @Suppress("DEPRECATION")
    jcenter()
}

dependencies {
    implementation("org.json:json:20220924")
    implementation("org.web3j:core:4.9.4")
    implementation("org.web3j:codegen:4.9.4")

    testImplementation("io.kotest:kotest-runner-junit5:5.5.3")
    testImplementation("org.web3j:web3j-unit:4.9.4")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}