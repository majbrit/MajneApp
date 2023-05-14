package code.with.cal.kotlincalculatorapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity2.*

class MainActivity2  : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2)
    }

    fun backAction(view: View)
    {
        if (view is Button)
        {
            doButton.text = "works"
            super.onBackPressed()
        }
    }
}