# Hazelcast Config Demo

_Quick, easy, confident configuration_

<center>
    <img alt="Cover" src="cover.jpg">
</center>

For developers who need to configure Hazelcast, the (Kotlin) DSL is an alternative to the previous configuration methods that covers the full API, is type-safe, and provides autocomplete. Unlike the existing configuration methods, the DSL scales well since it provides both declarative and programmatic configuration.

This demo of what Hazelcast's Kotlin DSL for configuration management could look like is shown below.

```kotlin
hazelcast {
    clusterName("my-cluster")
    network {
        port(5701, portCount = 105)
        interfaces("10.10.1.*", "10.10.2.*", isEnabled = false)
    }
}
```

## [Contributing](CONTRIBUTING.md)

## License

This project is under the [MIT License](LICENSE).