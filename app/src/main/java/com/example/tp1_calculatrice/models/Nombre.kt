package com.example.tp1_calculatrice.models

import android.util.Log

class Nombre {
    var value : String = ""
    var estDecimal= false
    var negatif = false
    var decimal = ""

    fun ajoute(st: String)
    {
        if(st == ",")
        {
            estDecimal = true
        }
        else if(estDecimal)
        {
            decimal += st
        }
        else
        {
            if(value.length == 0)
            {
                value = st
            }
            else
            {
                value += st
            }

        }
    }

    fun retire()
    {
        if(estDecimal && decimal == "")
        {
            estDecimal = false
        }
        else if (estDecimal)
        {
            if(decimal.length >1)
            {
                decimal = decimal.dropLast(1)
            }
            else
            {
                decimal = ""
            }
        }
        else if (value.length > 1)
        {
            value = value.dropLast(1)
        }
        else if(value == "" && negatif)
        {
            negatif = false
        }
        else if(value.length == 1)
        {
            value = ""
        }
    }

    override fun toString(): String
    {
        var str = ""
        if(negatif)
            str = "-"
        if(value == "" && estDecimal)
            str+= "0"
        str += value
        if(estDecimal) str += ",$decimal"
        return str
    }

    fun toFloat(): Float {
        var str = ""
        if(negatif)
            str = "-"
        if(value == "")
            str+= "0"
        str += value
        if(estDecimal && decimal != "") str += ",$decimal"

        return str.toFloat()
    }

    fun set(nb: Float)
    {
        // TODO: 22/09/2021
    }

    fun negatifChange()
    {
        negatif = !negatif
    }

    fun clear()
    {
        value = ""
        negatif = false
        estDecimal = false
        decimal = ""
    }

}