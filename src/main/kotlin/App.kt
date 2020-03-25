package com.neelkamath.hazelcast_config

import com.hazelcast.config.Config
import com.hazelcast.config.MapConfig
import com.hazelcast.config.NetworkConfig

fun main() {
    println(
        config {
            clusterName = "my-cluster"
        }
    )
    println()
    println(
        networkConfig {
            port = 500
            portAutoIncrement = false
        }
    )
    println()
    println(
        mapConfig("testMap") {
            backupCount = 2
            timeToLiveSeconds = 300
        }
    )
}

fun config(name: String? = null, init: Config.() -> Unit) = Config(name).apply(init)

fun networkConfig(init: NetworkConfig.() -> Unit) = NetworkConfig().apply(init)

var NetworkConfig.portAutoIncrement: Boolean
    get() = isPortAutoIncrement
    set(value) {
        isPortAutoIncrement = value
    }

fun mapConfig(name: String? = null, init: MapConfig.() -> Unit) = MapConfig(name).apply(init)