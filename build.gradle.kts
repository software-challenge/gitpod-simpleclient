plugins {
    java
    application
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

sourceSets.main.get().java.srcDir("src/main")
sourceSets.main.get().resources.srcDir("src/resources")

application {
    mainClassName = "sc.player2021.Starter"
}

repositories {
    jcenter()
    maven("http://dist.wso2.org/maven2")
    maven("https://jitpack.io")
}

dependencies {
    if(gradle.startParameter.isOffline) {
        implementation(fileTree("lib"))
    } else {
        implementation("com.github.CAU-Kiel-Tech-Inf.backend", "blokus_2021", "21.3.3")
    }
}

tasks.shadowJar {
    archiveBaseName.set("blokus_2021_client")
    archiveClassifier.set("")
    destinationDirectory.set(rootDir)
}
