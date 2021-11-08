package com.fsl.dao.db

import com.fsl.domain.DatasourceProperties
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.postgres.PostgresPlugin
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
open class DatabaseConfiguration {

    @Bean
    @ConfigurationProperties("database")
    open fun fullStackAppDataSource(): DatasourceProperties = DatasourceProperties()

    @Bean("fullStackAppDbi")
    open fun fullStackAppDbi(hikariDataSource: HikariDataSource): Jdbi = Jdbi
        .create(hikariDataSource)
        .installPlugin(PostgresPlugin())

    @Bean
    open fun hikariDataSource(fullStackAppDataSource: DatasourceProperties): HikariDataSource = assembleDataSource(fullStackAppDataSource)

    open fun assembleDataSource(datasourceProperties: DatasourceProperties): HikariDataSource = HikariDataSource(with(datasourceProperties.pool) {
        HikariConfig().apply {
            driverClassName = datasourceProperties.driverClassName
            jdbcUrl = datasourceProperties.url
            username = datasourceProperties.username
            password = datasourceProperties.password
            isAutoCommit = datasourceProperties.autoCommit
            dataSourceJNDI = datasourceProperties.jndi
            maxLifetime = this@with.maxLifetime.toLong()
            validationTimeout = this@with.validationTimeout.toLong()
            connectionTimeout = this@with.connectionTimeout.toLong()
            maximumPoolSize = this@with.maxPoolSize
            minimumIdle = this@with.minPoolSize
            idleTimeout = this@with.idleTimeout.toLong()
            leakDetectionThreshold = this@with.leakDetectionThreshold.toLong()
            connectionTestQuery = datasourceProperties.testQuery
            poolName = "database.jdbc.pool${datasourceProperties.jndi}"
            addDataSourceProperty("cacheServerConfiguration", true)
            addDataSourceProperty("cachePrepStmts", true)
            addDataSourceProperty("prepStmtCacheSize", 250)
            addDataSourceProperty("sslMode", "DISABLED")
            addDataSourceProperty("allowPublicKeyRetrieval", false)
            addDataSourceProperty("useSSL", false)
            addDataSourceProperty("gssEncMode", "disable")
        }
    })
}