package code.with.cal.kotlincalculatorapp

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.animation.*

class Animation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.animation)
    }
    fun clockwiseAction(view: View)
    {
        if (view is Button)
        {
            var animation1 = AnimationUtils.loadAnimation(getApplicationContext(),
            R.anim.clockwise);
            catImage.startAnimation(animation1);
        }
    }

}