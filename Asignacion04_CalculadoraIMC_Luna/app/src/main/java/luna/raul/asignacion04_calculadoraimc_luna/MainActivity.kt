package luna.raul.asignacion04_calculadoraimc_luna

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val peso : EditText = findViewById(R.id.etPeso) as EditText
        val estatura : EditText = findViewById(R.id.etEstatura) as EditText
        val calculate : Button = findViewById(R.id.calculate)
        val imc : TextView = findViewById(R.id.IMC)
        val categoria: TextView = findViewById(R.id.category)

        calculate.setOnClickListener{
            val valorPeso = peso.text.toString().toDouble()
            val valorEstatura = estatura.text.toString().toDouble()
            val valorImc = calcularIMC(valorPeso, valorEstatura)
            val valorCategoria = definirCategoria(valorImc)

            imc.setText(valorImc.toString())
            categoria.setText(valorCategoria)

            if(valorCategoria == "Bajo Peso"){
                categoria.setBackgroundResource(R.color.colorGreenish)
            }else if(valorCategoria == "Peso Ideal"){
                categoria.setBackgroundResource(R.color.colorGreen)
            }else if(valorCategoria == "Sobrepeso"){
                categoria.setBackgroundResource(R.color.colorYellow)
            }else if(valorCategoria == "Obesidad Nivel 1"){
                categoria.setBackgroundResource(R.color.colorOrange)
            }else if(valorCategoria == "Obesidad Nivel 2"){
                categoria.setBackgroundResource(R.color.colorRed)
            }else if(valorCategoria == "Obesidad Nivel 3"){
                categoria.setBackgroundResource(R.color.colorBrown)
            }


        }


    }

    fun calcularIMC(peso: Double, estatura: Double): Double{
        var imc = peso / (estatura * estatura)
        return imc
    }

    fun definirCategoria(imc: Double): String{
        return when{
            imc < 18.5 -> "Bajo Peso"
            imc < 24.9 -> "Peso Ideal"
            imc < 29.9 -> "Sobrepeso"
            imc < 34.9 -> "Obesidad Nivel 1"
            imc < 39.9 -> "Obesidad Nivel 2"
            imc > 40 -> "Obesidad Nivel 3"
            else -> "Datos invalidos"

        }
    }


}