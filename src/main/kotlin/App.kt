package com.neelkamath.hazelcast_config

import com.hazelcast.config.Config
import com.hazelcast.config.NetworkConfig

fun main() {
    println(
        hazelcast {
            clusterName("my-cluster")
            network {
                port(5701, portCount = 105)
                if (true) // Example of conditional configuration.
                    interfaces("10.10.1.*", "10.10.2.*", isEnabled = false)
            }
        }
    )
}

fun hazelcast(init: Hazelcast.() -> Unit) = Hazelcast().apply(init).config

class Hazelcast {
    val config = Config()

    fun clusterName(name: String) {
        config.clusterName = name
    }

    fun network(init: Network.() -> Unit) {
        config.networkConfig = Network(config).apply(init).networkConfig
    }
}

class Network(config: Config) {
    val networkConfig: NetworkConfig = config.networkConfig

    fun port(port: Int = 5701, isPortAutoIncrement: Boolean = true, portCount: Int = 100) {
        networkConfig.port = port
        networkConfig.isPortAutoIncrement = isPortAutoIncrement
        networkConfig.portCount = portCount
    }

    fun interfaces(vararg interfaces: String = arrayOf("10.10.1.*"), isEnabled: Boolean = true) {
        networkConfig.interfaces.isEnabled = isEnabled
        networkConfig.interfaces.interfaces = interfaces.toList()
    }
}