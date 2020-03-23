plugins {
    application
    kotlin("jvm") version "1.3.70"
}

application.mainClassName = "com.neelkamath.hazelcast_config.AppKt"

repositories { jcenter() }

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.hazelcast:hazelcast:4.0")
}