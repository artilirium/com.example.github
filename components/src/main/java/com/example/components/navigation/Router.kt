package com.example.components.navigation

interface Router {

    fun moveTo(screen: String)

    fun popTo(screen: String)
}