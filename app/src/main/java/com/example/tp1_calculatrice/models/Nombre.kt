package com.example.tp1_calculatrice.models

class Nombre {
    var value= ""
    var estDecimal= false
    var negatif = false
    var decimal = ""

    fun ajoute(ch : Char)
    {
        if(ch == ',')
        {
            estDecimal = true
        }
        else if(estDecimal)
        {
            decimal += ch
        }
        else
        {
            value += ch
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
                decimal.removeRange(decimal.length-2, decimal.length-1)
            }
            else
            {
                decimal = ""
            }
        }
        else if (value.length > 1)
        {
            value.removeRange(value.length-2, value.length-1)
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

    fun clear()
    {
        value = ""
        negatif = false
        estDecimal = false
        decimal = ""
    }

}