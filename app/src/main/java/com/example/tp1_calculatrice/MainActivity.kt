package com.example.tp1_calculatrice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var affCalcul : TextView
    private var selectCalcul = 'x'

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
            this.selectCalcul = '+'
            this.affCalcul.setText(this.affCalcul.text.toString() + "+")
        }

        butMoins.setOnClickListener{
            this.selectCalcul = '-'
            this.affCalcul.setText(this.affCalcul.text.toString() + "-")
        }

        butMultiplie.setOnClickListener{
            this.selectCalcul = 'x'
            this.affCalcul.setText(this.affCalcul.text.toString() + "x")
        }

        butModulo.setOnClickListener{
            this.selectCalcul = '%'
            this.affCalcul.setText(this.affCalcul.text.toString() + "%")
        }

        butDivise.setOnClickListener{
            this.selectCalcul = '/'
            this.affCalcul.setText(this.affCalcul.text.toString() + "/")
        }

    }

    fun clickChiffre(i: Int){
        this.affCalcul.setText(this.affCalcul.text.toString() + i.toString())
    }

    fun clickReset(){
        this.affCalcul.setText("")
    }
}