package com.example

import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import jakarta.inject.Singleton

interface BaseClient {
    @Get("/")
    fun get(): String

}

@Client("https://www.google.de")
interface GoogleDe : BaseClient

@Client("https://www.google.com")
interface GoogleCom : BaseClient

@Singleton
class GoogleRepo(
        private val googleDe: GoogleDe,
        private val googleCom: GoogleCom
) {
    fun curls() {
        println("Hi!")
    }
}