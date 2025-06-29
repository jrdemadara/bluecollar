package org.jrdemadara.bluecollar.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val ktorModule = module {
    single {
        val json = Json {
            ignoreUnknownKeys = true
            explicitNulls = false
            prettyPrint = true
            isLenient = true
            coerceInputValues=true
        }
        val baseUrl: String = get()

        HttpClient {
            install(ContentNegotiation) {
                json(json, contentType = ContentType.Application.Json)
            }


            install(DefaultRequest) {
                url(baseUrl)
                headers.append(HttpHeaders.ContentType, ContentType.Application.Json.toString())
                headers.append(HttpHeaders.Accept, ContentType.Application.Json.toString())
            }
        }
    }
}