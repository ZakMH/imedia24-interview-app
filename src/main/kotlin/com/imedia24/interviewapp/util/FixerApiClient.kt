package com.imedia24.interviewapp.util

import com.imedia24.interviewapp.config.FixerWebClient
import com.imedia24.interviewapp.model.Product
import org.springframework.stereotype.Component
import org.springframework.web.util.UriBuilder

@Component
class FixerApiClient(private val fixerWebClient: FixerWebClient) {

    fun convert(to: String, from: String, amount: Double): Response? {
        if (fixerWebClient.apiKey.isNullOrEmpty()) {
            throw IllegalArgumentException("FixerIO Api Access Key is not set")
        }
        if (to != Product.CURRENCY) {
            throw IllegalArgumentException("Currently only supported conversion is ${Product.CURRENCY}")
        }
        val resp = fixerWebClient.createWebClient().get().uri { builder: UriBuilder ->
            builder.path("/convert")
                .queryParam("to", to)
                .queryParam("from", from)
                .queryParam("amount", amount)
                .build()
        }.header("apiKey", fixerWebClient.apiKey)
            .retrieve().bodyToMono(Response::class.java).block()

        return resp
    }
}

data class Response(var result: Double)