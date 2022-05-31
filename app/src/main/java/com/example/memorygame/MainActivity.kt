package com.example.memorygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.memorygame.R.drawable.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1 = findViewById<AppCompatButton>(R.id.button1)
        val btn2 = findViewById<AppCompatButton>(R.id.button2)
        val btn3 = findViewById<AppCompatButton>(R.id.button3)
        val btn4 = findViewById<AppCompatButton>(R.id.button4)
        val btn5 = findViewById<AppCompatButton>(R.id.button5)
        val btn6 = findViewById<AppCompatButton>(R.id.button6)
        val btn7 = findViewById<AppCompatButton>(R.id.button7)
        val btn8 = findViewById<AppCompatButton>(R.id.button8)
        val btn9 = findViewById<AppCompatButton>(R.id.button9)
        val btn10 = findViewById<AppCompatButton>(R.id.button10)
        val btn11 = findViewById<AppCompatButton>(R.id.button11)
        val btn12 = findViewById<AppCompatButton>(R.id.button12)


        val images: MutableList<Int> =
            mutableListOf(armin, conny, jean, mikasa, sasha, ymir, armin, conny, jean, mikasa, sasha, ymir);

        val buttons: Array<AppCompatButton> =
            arrayOf(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12)
        var clickedCards = 0;
        var turnOver = false;
        var openedCard = -1;

        images.shuffle();

        for(i:Int in 0..11){
            buttons[i].text = "background";
            buttons[i].textSize = 0.0F;
            buttons[i].setOnClickListener {
                if(buttons[i].text == "background" && !turnOver) {
                    buttons[i].setBackgroundResource(images[i]);
                    buttons[i].setText(images[i]);
                    if (clickedCards == 0) {
                        openedCard = i;
                    }
                    clickedCards++;
                } else {
                    buttons[i].setBackgroundResource(background);
                    buttons[i].text = "background";
                    clickedCards--;
                }
                if (clickedCards == 2) {
                    turnOver = true;
                    if (buttons[i].text == buttons[openedCard].text) {
                        buttons[i].isClickable = false;
                        buttons[openedCard].isClickable = false;
                        turnOver = false;
                        clickedCards = 0;
                    }
                } else if (clickedCards == 0) {
                    turnOver = false
                }
            }
        }


    }
}