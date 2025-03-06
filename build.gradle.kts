plugins {
    id("java")
}

group = "com.winlow"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    val flatlafVersion = "3.4"
    implementation( "com.formdev:flatlaf:${flatlafVersion}" )
    implementation( "com.formdev:flatlaf:${flatlafVersion}:linux-x86_64@so" )
    implementation( "com.formdev:flatlaf:${flatlafVersion}:macos-arm64@dylib" )
    implementation( "com.formdev:flatlaf:${flatlafVersion}:macos-x86_64@dylib" )
    implementation( "com.formdev:flatlaf:${flatlafVersion}:windows-x86_64@dll" )

    // 32-bit (not needed if you bundle a 64-bit JRE with your application)
    implementation( "com.formdev:flatlaf:${flatlafVersion}:windows-x86@dll" )

    // ARM 64-bit (not needed if your application does not support Windows on ARM)
    implementation( "com.formdev:flatlaf:${flatlafVersion}:windows-arm64@dll" )
}

tasks.test {
    useJUnitPlatform()
}