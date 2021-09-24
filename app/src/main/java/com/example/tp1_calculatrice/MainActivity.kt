package com.example.tp1_calculatrice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.tp1_calculatrice.models.Calcul
import com.example.tp1_calculatrice.models.Operation

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

        butSuppr.setOnClickListener{
            clickSuppr()
        }

        butPlus.setOnClickListener{
            clickOperation('+')
        }

        butMoins.setOnClickListener{
            clickOperation('-')
        }

        butMultiplie.setOnClickListener{
            clickOperation('x')
        }

        butModulo.setOnClickListener{
            clickOperation('%')
        }

        butDivise.setOnClickListener{
            clickOperation('/')
        }

        butEgal.setOnClickListener{
            calculer()
        }

        butNegation.setOnClickListener{
            clickNeg()
        }

        butVirgule.setOnClickListener{
            clickVirgule()
        }
    }

    fun clickChiffre(i: Int){
        calcul.ajoute(i.toString())
        refreshAffichage()
    }

    fun clickReset(){
        this.affCalcul.setText("")
        this.calcul.reset()
        refreshAffichage()
    }

    fun clickSuppr(){
        calcul.retire()
        refreshAffichage()
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

    fun clickOperation(strCalc: Char){

        // Il y a déjà une opération écrite
        if(calcul.operation != Operation.VIDE)
        {
            calculer()
        }
        ajoutOperation(strCalc)
        refreshAffichage()
    }

    fun calculer()
    {
        if(calcul.operation != Operation.VIDE)
        {
            calcul.calculer()
            refreshAffichage()
        }
    }

    fun clickNeg(){
        calcul.negatifChange()
        refreshAffichage()

    }

    fun clickVirgule(){
        calcul.ajoutDecimal()
        refreshAffichage()
    }

    fun refreshAffichage()
    {
        affCalcul.setText(calcul.toString())
    }
}