package com.example.tp1_calculatrice.models

enum class Operation(private val ch: Char) {
    ADDITION('+'), SOUSTRACTION('-'), MULTIPLICATION('x'), DIVISION('/'), MODULO('%'), VIDE(' ');


    override fun toString(): String {
        return ch.toString()
    }
}