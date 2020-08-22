package com.example.ps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var btnText = ""
    var op = ""
    var oldNum = ""
    var newNum = ""
    var isNewOp = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        fun btnPmOnClick(view: View){
            val text = tvResult.text.toString()
            if (text.toDouble()>0){
                tvResult.text = "-" + text
            }else{
                tvResult.text = Math.abs(text.toDouble()).toString()
            }
            isNewOp = false
        }

    }

    fun btnOnClick(view: View) {
        if (isNewOp)
            tvResult.text =""
        isNewOp = false

        if (!tvResult.text.toString().equals("0"))
            btnText = tvResult.text.toString()

        val btnSelected = view as Button
        when(btnSelected.id) {
            btn0.id -> btnText += "0"
            btn1.id -> btnText += "1"
            btn2.id -> btnText += "2"
            btn3.id -> btnText += "3"
            btn4.id -> btnText += "4"
            btn5.id -> btnText += "5"
            btn6.id-> btnText += "6"
            btn7.id -> btnText += "7"
            btn8.id -> btnText += "8"
            btn9.id -> btnText += "9"
            btnDot.id -> btnText += "."

        }
        tvResult.text = btnText
    }

    fun btnOpOnClick(view: View) {
        oldNum = tvResult.text.toString()
        val btnSelected = view as Button
        when(btnSelected.id){
            btnPlus.id -> op = "+"
            btnMinus.id -> op = "-"
            btnMulti.id -> op = "*"
            btnDiv.id -> op = "/"
        }
        isNewOp = true
    }

    fun btnEqualOnClick(view: View) {
        newNum = tvResult.text.toString()
        var finalResult =0.0

        when(op){
            "+" -> finalResult = oldNum.toDouble() + newNum.toDouble()
            "-" -> finalResult = oldNum.toDouble() - newNum.toDouble()
            "*" -> finalResult = oldNum.toDouble() * newNum.toDouble()
            "/" -> finalResult = oldNum.toDouble() / newNum.toDouble()
        }

        tvResult.text = finalResult.toString()
        isNewOp = true
    }

    fun btnRemOnClick(view: View) {
        val num = tvResult.text.toString().toDouble() /100
        tvResult.text = num.toString()
        isNewOp = true
    }

    fun btnPmOnClick(view: View) {}
    fun btnAcOnClick(view: View) {
        tvResult.text ="0"
        isNewOp = true
    }
}