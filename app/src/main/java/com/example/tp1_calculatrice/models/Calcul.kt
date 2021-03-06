package com.example.tp1_calculatrice.models

import java.text.DecimalFormat

class Calcul {

    var premierNb: Nombre = Nombre()
    var operation: Operation = Operation.VIDE
    var deuxiemeNb: Nombre = Nombre()

    fun resultat(): Float {
        var resultat = 0F
        if(deuxiemeNb.toFloat() == 0F) return premierNb.toFloat()
        if(operation!= null)
        {
            when(operation)
            {
                Operation.ADDITION -> resultat = premierNb.toFloat() + deuxiemeNb.toFloat()
                Operation.SOUSTRACTION -> resultat = premierNb.toFloat() - deuxiemeNb.toFloat()
                Operation.MULTIPLICATION -> resultat = premierNb.toFloat() * deuxiemeNb.toFloat()
                Operation.DIVISION -> resultat = premierNb.toFloat() / deuxiemeNb.toFloat()
                Operation.MODULO -> resultat = premierNb.toFloat() % deuxiemeNb.toFloat()
                else -> resultat = premierNb.toFloat()
            }
        }
        premierNb.set(resultat)
        operation = Operation.VIDE
        deuxiemeNb.clear()
        return resultat
    }

    fun calculer()
    {
        var resultat = 0F
        if(deuxiemeNb.toFloat() == 0F && operation != Operation.MULTIPLICATION)
        {
            deuxiemeNb.clear()
        }
        else
        {
            if(operation!= null)
            {
                when(operation)
                {
                    Operation.ADDITION -> resultat = premierNb.toFloat() + deuxiemeNb.toFloat()
                    Operation.SOUSTRACTION -> resultat = premierNb.toFloat() - deuxiemeNb.toFloat()
                    Operation.MULTIPLICATION -> resultat = premierNb.toFloat() * deuxiemeNb.toFloat()
                    Operation.DIVISION -> resultat = premierNb.toFloat() / deuxiemeNb.toFloat()
                    Operation.MODULO -> resultat = premierNb.toFloat() % deuxiemeNb.toFloat()
                    else -> resultat = premierNb.toFloat()
                }
            }
            premierNb.set(resultat)
            operation = Operation.VIDE
            deuxiemeNb.clear()
        }

    }

    fun reset()
    {
        premierNb.clear()
        operation = Operation.VIDE
        deuxiemeNb.clear()
    }

    fun resultatToString(): String? {
        val dec = DecimalFormat("0.#")
        return dec.format(resultat())
    }

    fun ajoute(st: String)
    {
        if(operation == Operation.VIDE)
        {
            premierNb.ajoute(st)
        }
        else
        {
            deuxiemeNb.ajoute(st)
        }
    }

    fun retire()
    {
        if(operation == Operation.VIDE)
        {
            premierNb.retire()
        }
        else if(operation != Operation.VIDE && !deuxiemeNb.estDecimal && !deuxiemeNb.negatif && deuxiemeNb.value == "" )
        {
            operation = Operation.VIDE
        }
        else
        {
            deuxiemeNb.retire()
        }
    }

    fun negatifChange()
    {
        if(operation == Operation.VIDE)
        {
            premierNb.negatifChange()
        }
        else
        {
            deuxiemeNb.negatifChange()
        }
    }

    fun ajoutDecimal()
    {
        if(operation == Operation.VIDE)
        {
            premierNb.ajoute(",")
        }
        else
        {
            deuxiemeNb.ajoute(",")
        }
    }

    override fun toString(): String {
        return premierNb.toString() + operation.toString() + deuxiemeNb.toString()
    }



}