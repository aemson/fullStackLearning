package com.fsl.domain

data class DatasourceProperties (
    val pool: Pool = Pool(),
    var driverClassName: String? = null,
    var url: String? = null,
    var username: String? = null,
    var password: String? = null,
    var jndi: String? = "",
    var testQuery: String? = "",
    var autoCommit: Boolean = true
)


data class Pool(
    var minPoolSize: Int = 0,
    var maxPoolSize: Int = 0,
    var maxLifetime: Int = 0,
    var validationTimeout: Int = 0,
    var leakDetectionThreshold: Int = 0,
    var connectionTimeout: Int = 0,
    var idleTimeout: Int = 0
)