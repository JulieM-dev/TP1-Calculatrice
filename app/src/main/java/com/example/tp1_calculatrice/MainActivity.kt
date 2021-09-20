package com.example.tp1_calculatrice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var affCalcul : TextView
    private var selectCalcul = 'x'
    private var savedCalc : Float? = null
    private lateinit var

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
            saveOne('=')
        }

        butNegation.setOnClickListener{
            clickNeg()
        }
    }

    fun clickChiffre(i: Int){
        this.affCalcul.setText(this.affCalcul.text.toString() + i.toString())
    }

    fun clickReset(){
        this.savedCalc = null
        this.affCalcul.setText("")
    }

    fun saveOne(strCalc: Char){
        var str = this.affCalcul.text
        var varCalc = arrayOf('+', '-', '%', 'x', '/')
        //System.out.println("CALC --- " + savedCalc)

        if(savedCalc == null) { //Si aucun nombre enregistré, on enregistre le 1er nombre
            this.selectCalcul = strCalc
            var nbr = ""

            var i = 0
            var test = true
            while (i < str.length && test) {
                if (!varCalc.contains(str[i])) {
                    nbr += str[i]
                } else {
                    test = false
                }
                i++
            }
            if(nbr.length > 0){
                this.savedCalc = nbr.toFloat()
            }
        } else {            //Deja un nombre enregistre
            if(str.length != 0){
                var nbrCalc = 0.0f

                var i = 0
                var test = true
                while (i < str.length && test) {
                    if (varCalc.contains(str[i])) {
                        test = false
                    }
                    i++
                }
                test = true
                var secNbrS = ""
                while (i < str.length && test) {
                    if (!varCalc.contains(str[i])) {
                        secNbrS += str[i]
                    } else {
                        test = false
                    }
                    i++
                }
                var secNbr = secNbrS.toFloat()

                if(selectCalcul == '+'){
                    nbrCalc = savedCalc!! + secNbr
                } else if(selectCalcul == '-'){
                    nbrCalc = savedCalc!! - secNbr
                } else if(selectCalcul == 'x'){
                    nbrCalc = savedCalc!! * secNbr
                } else if(selectCalcul == '/'){
                    nbrCalc = savedCalc!! / secNbr
                } else if(selectCalcul == '%'){
                    nbrCalc = savedCalc!! % secNbr
                }

                this.affCalcul.text = nbrCalc.toInt().toString()
                if(varCalc.contains(strCalc)){
                    this.savedCalc = nbrCalc
                    this.selectCalcul = strCalc
                } else {
                    this.savedCalc = null
                }
            }
        }
        if(varCalc.contains(strCalc)){
            this.affCalcul.setText(this.affCalcul.text.toString() + strCalc)
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