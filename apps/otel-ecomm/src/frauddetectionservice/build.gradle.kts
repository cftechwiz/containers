import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.google.protobuf.gradle.*

plugins {
    kotlin("jvm") version "1.8.10"
    application
    id("java")
    id("idea")
    id("com.google.protobuf") version "0.9.2"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "io.opentelemetry"
version = "1.0"


val grpcVersion = "1.55.1"
val protobufVersion = "3.16.1"


repositories {
    mavenCentral()
    gradlePluginPortal()
}



dependencies {
    implementation("com.google.protobuf:protobuf-java:3.22.2")
    testImplementation(kotlin("test"))
    implementation(kotlin("script-runtime"))
    implementation("org.apache.kafka:kafka-clients:3.4.0")
    implementation("com.google.api.grpc:proto-google-common-protos:2.14.3")
    implementation("io.grpc:grpc-protobuf:${grpcVersion}")
    implementation("io.grpc:grpc-stub:${grpcVersion}")
    implementation("io.grpc:grpc-netty:${grpcVersion}")
    implementation("io.grpc:grpc-services:${grpcVersion}")
    implementation("io.opentelemetry:opentelemetry-api:1.24.0")
    implementation("io.opentelemetry:opentelemetry-sdk:1.24.0")
    implementation("io.opentelemetry:opentelemetry-extension-annotations:1.18.0")
    implementation("org.apache.logging.log4j:log4j-core:2.20.0")
    implementation("org.slf4j:slf4j-api:2.0.7")
    implementation("com.google.protobuf:protobuf-kotlin:3.22.2")

    if (JavaVersion.current().isJava9Compatible) {
        // Workaround for @javax.annotation.Generated
        // see: https://github.com/grpc/grpc-java/issues/3633
        implementation("javax.annotation:javax.annotation-api:1.3.2")
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.22.2"
    }
    plugins {

        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.53.0"
        }
    }
    generateProtoTasks {
        ofSourceSet("main").forEach {
            it.plugins {
                // Apply the "grpc" plugin whose spec is defined above, without
                // options. Note the braces cannot be omitted, otherwise the
                // plugin will not be added. This is because of the implicit way
                // NamedDomainObjectContainer binds the methods.
                id("grpc") { }
            }
        }
    }
}

application {
    mainClass.set("frauddetectionservice.MainKt")
}

tasks.jar {
    manifest.attributes["Main-Class"] = "frauddetectionservice.MainKt"
}
