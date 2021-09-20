package com.example.tp1_calculatrice.models

import java.text.DecimalFormat

class Calcul {

    var premierNb: Float = 0F
    lateinit var operation: Operation
    var deuxiemeNb: Float = 0F

    fun resultat(): Float {
        var resultat = 0F
        if(operation!= null)
        {
            when(operation)
            {
                Operation.ADDITION -> resultat = premierNb + deuxiemeNb
                Operation.SOUSTRACTION -> resultat = premierNb - deuxiemeNb
                Operation.MULTIPLICATION -> resultat = premierNb * deuxiemeNb
                Operation.DIVISION -> resultat = premierNb / deuxiemeNb
                Operation.MODULO -> resultat = premierNb % deuxiemeNb
                else -> resultat = premierNb
            }
        }
        premierNb = resultat
        operation = Operation.ADDITION
        deuxiemeNb = 0F
        return resultat
    }

    fun resultatToString(): String? {
        val dec = DecimalFormat("0.#")
        return dec.format(resultat())
    }



}