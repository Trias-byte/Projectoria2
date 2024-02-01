package com.example.projectoria

open class Event<out T>(private val content: T) {
    var hasBeenHandler = false
        private set

    fun getContentOrNull(): T? {
        return if (hasBeenHandler){
            null
        }
        else{
            hasBeenHandler = true
            content
        }
    }
}