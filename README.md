# Fabric Easy Entity Creation API

## Setup
Add this to your build.gradle:

You'll need [JitPack](https://www.jitpack.io). Add it to your repositories.
```groovy
repositories {
	maven {
		name = "JitPack"
		url = "https://jitpack.io"
	}
}
```

Put this in your dependencies (Underneath any non-JitPack dependencies!)
```groovy
    modImplementation "com.github.halotroop2288:fabric-entity-api:${project.fabric_entity_api_version}"
```

Put this somewhere inside your gradle.properties, followed by the latest version number:
![latest](https://img.shields.io/github/v/release/halotroop2288/fabric-entity-api?label=latest&sort=semver)
<br/> Or use the latest commit hash, found at the top of the page.
```properties
fabric_entity_api_version = 
```

## License

This library is available under the Apache license. Feel free to use it in your own projects.
