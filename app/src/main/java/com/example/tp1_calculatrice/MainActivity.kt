package com.example.tp1_calculatrice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.tp1_calculatrice.models.Calcul
import com.example.tp1_calculatrice.models.Operation
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private lateinit var affCalcul : TextView
    private var selectCalcul = 'x'
    private var savedCalc : Float? = null
    private var calcul : Calcul = Calcul()
    private var nombreEcrit = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator)
        var tableChiffres = arrayOf (
            findViewById<Button>(R.id.but0),
            findViewById<Button>(R.id.but1),
            findViewById<Button>(R.id.but2),
            findViewById<Button>(R.id.but3),
            findViewById<Button>(R.id.but4),
            findViewById<Button>(R.id.but5),
            findViewById<Button>(R.id.but6),
            findViewById<Button>(R.id.but7),
            findViewById<Button>(R.id.but8),
            findViewById<Button>(R.id.but9)
        )

        for(i in 0..tableChiffres.size-1){
            tableChiffres.get(i).setOnClickListener{
                clickChiffre(i)
            }
        }

        var butEgal = findViewById<Button>(R.id.butEgal)
        var butSuppr = findViewById<Button>(R.id.butSuppr)
        var butDivise = findViewById<Button>(R.id.butDivise)
        var butPlus = findViewById<Button>(R.id.butPlus)
        var butMoins = findViewById<Button>(R.id.butMoins)
        var butModulo = findViewById<Button>(R.id.butModulo)
        var butMultiplie = findViewById<Button>(R.id.butMultiplie)
        var butVirgule = findViewById<Button>(R.id.butVirgule)
        var butNegation = findViewById<Button>(R.id.butNegation)
        var butAC = findViewById<Button>(R.id.butAC)
        affCalcul = findViewById<TextView>(R.id.affCalcul)

        butAC.setOnClickListener{
            clickReset()
        }

        butPlus.setOnClickListener{
            saveOne('+')
        }

        butMoins.setOnClickListener{
            saveOne('-')
        }

        butMultiplie.setOnClickListener{
            saveOne('x')
        }

        butModulo.setOnClickListener{
            saveOne('%')
        }

        butDivise.setOnClickListener{
            saveOne('/')
        }

        butEgal.setOnClickListener{
            calculer()
        }

        butNegation.setOnClickListener{
            clickNeg()
        }
    }

    fun clickChiffre(i: Int){
        this.affCalcul.setText(this.affCalcul.text.toString() + i.toString())
        nombreEcrit += i.toString()
    }

    fun clickReset(){
        this.nombreEcrit = "0"
        this.affCalcul.setText("")
    }

    fun ajoutOperation(strCalc: Char)
    {
        if(strCalc == '+'){
            calcul.operation = Operation.ADDITION
        } else if(strCalc == '-'){
            calcul.operation = Operation.SOUSTRACTION
        } else if(strCalc == 'x'){
            calcul.operation = Operation.MULTIPLICATION
        } else if(strCalc == '/'){
            calcul.operation = Operation.DIVISION
        } else if(strCalc == '%'){
            calcul.operation = Operation.MODULO
        }
    }

    fun saveOne(strCalc: Char){

        // Il y a déjà une opération écrite
        if(calcul.operation != Operation.VIDE)
        {
            // On sauvegarde le deuxième nombre
            calcul.deuxiemeNb = nombreEcrit.toFloat()
            affCalcul.setText(calcul.resultatToString() + strCalc)

            // On remet à 0 le nombre écrit
            nombreEcrit = "0"
            // On sauvegarde l'opération
            ajoutOperation(strCalc)
        }
        // Il n'y a pas d'opération écrite
        else
        {
            // On sauvegarde le premier nombre
            calcul.premierNb= nombreEcrit.toFloat()
            affCalcul.setText(affCalcul.text.toString() + strCalc)
            // On sauvegarde l'opération
            ajoutOperation(strCalc)
            nombreEcrit = "0"
        }
    }

    fun calculer()
    {
        if(calcul.operation != Operation.VIDE)
        {


            // On sauvegarde le deuxième nombre
            calcul.deuxiemeNb = nombreEcrit.toFloat()


            Log.d("1er", calcul.premierNb.toString())
            Log.d("Op", calcul.operation.name)
            Log.d("2em", calcul.deuxiemeNb.toString())

            Log.d("nbEcrit", nombreEcrit)


            var result = calcul.resultatToString()
            if(result != null)
            {
                affCalcul.setText(result)

                // On met le résultat en tant que nombre écris
                nombreEcrit = result
            }

        }
    }
    fun getPremierNombre()
    {

    }

    fun getSecondNombre()
    {

    }

    fun clickNeg(){
        var str = this.affCalcul.text
        var varCalc = arrayOf('+', '-', '%', 'x', '/')

        if(!varCalc.contains(str.get(str.length -1))){ //Pas de calcul en dernier caractere
            var nouvStr = 0f

            if(savedCalc == null){ //1 seul nombre enregistre
                nouvStr = 0 - str.toString().toFloat()
                this.affCalcul.setText(nouvStr.toString())
            } else {
                var strCalc = ""
                var i = 0
                var test = true
                while (i < str.length && test) { //Recupere partie1 du calcul
                    if (varCalc.contains(str[i])) {
                        test = false
                    } else {
                        strCalc += str[i]
                    }
                    i++
                }

                strCalc += str[i-1]
                System.out.println("AFF --- " + strCalc)
                test = true
                var secNbrS = ""
                while (i < str.length && test) { //Recupere partie2 du calcul
                    if (!varCalc.contains(str[i])) {
                        secNbrS += str[i]
                    } else {
                        test = false
                    }
                    i++
                }
                nouvStr = 0 - secNbrS.toFloat()
                this.affCalcul.setText(strCalc + nouvStr.toInt().toString())
            }
        }

    }
}