package com.example.d10challenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnCalcu: Button = findViewById(R.id.btnCalcu)
        val edtPeso: EditText = findViewById(R.id.edtText_Weigh)
        val edtAltutra: EditText = findViewById(R.id.edtText_hight)

        btnCalcu.setOnClickListener {

            val alturaStr = edtAltutra.text.toString()
            val pesoStr = edtPeso.text.toString()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {

                val altura: Float = alturaStr.toFloat()
                val peso: Float = pesoStr.toFloat()


                val alturaFinal: Float = altura * altura
                val result: Float = peso / alturaFinal


                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }

                startActivity(intent)
            }else {
                Toast.makeText(this, "PREENCHER TODOS OS CAMPOS", Toast.LENGTH_SHORT).show()
            }

        }


    }
}
