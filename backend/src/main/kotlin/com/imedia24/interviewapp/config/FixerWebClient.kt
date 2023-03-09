package com.imedia24.interviewapp.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class FixerWebClient {

    @Value("\${fixer.io.convert.baseurl}")
    lateinit var baseUrl: String

    @Value("\${fixer.io.api.key}")
    lateinit var apiKey: String

    @Bean
    fun createWebClient(): WebClient = WebClient.create(baseUrl)
}