package code.with.cal.kotlincalculatorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.calc.*

class MainActivity : AppCompatActivity()
{


    var width = 0
    var height = 0


    var direction = 20f

    //var calc = CalcActivity()



    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)

        width = displayMetrics.widthPixels
        height = displayMetrics.heightPixels
    }

    fun movingAction(view: View)
    {
        if(view is Button)
        {
            movingButton.text = "neu"

            if(movingButton.x + movingButton.width > width)
            {
                movingButton.text = "links"
                direction = -direction
            }
            else if(movingButton.x < 0)
            {
                movingButton.text = "rechts"
                direction = -direction
            }

            movingButton.x += direction
        }
    }

    fun otherxmlAction(view: View)
    {
        if (view is Button)
        {
            //val intent = Intent(this, CalcActivity2::class.java)
            //startActivity(intent)
            //setContentView(R.layout.calc)
            val intent = Intent(this, Calculator::class.java)
            startActivity(intent)
        }
    }

    fun activity2Action(view: View)
    {
        if (view is Button)
        {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            //setContentView(R.layout.activity2)
        }
    }


}



















