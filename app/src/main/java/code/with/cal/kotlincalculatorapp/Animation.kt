package code.with.cal.kotlincalculatorapp

import android.R.attr.animation
import android.animation.Animator
import android.animation.ValueAnimator
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.Toast
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
            var mediaPlayer: MediaPlayer = MediaPlayer.create(this, R.raw.schnips)
            mediaPlayer.start()

            var animation1 = AnimationUtils.loadAnimation(
                applicationContext,
            R.anim.clockwise);
            catImage.startAnimation(animation1);
        }
    }

    fun myanimAction(view: View)
    {
        if (view is Button)
        {
            var mediaPlayer: MediaPlayer = MediaPlayer.create(this, R.raw.schnips)
            mediaPlayer.start()
            //mediaPlayer.start()
            /*
            var animation1 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fadein);
            catImage.startAnimation(animation1);*/

            val animator = ValueAnimator.ofFloat(0f, 200f)
            animator.addUpdateListener {
                val value = it.animatedValue as Float
                catImage.translationX = value
                catImage.alpha = 1.0f - value/200f
            }

            val animator2 = ValueAnimator.ofFloat(0f, 200f)
            animator2.addUpdateListener {
                val value = it.animatedValue as Float
                catImage.translationX = 200f - value
                catImage.alpha = value/200f
            }

            animator.addListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {
                    // 3
                    Toast.makeText(applicationContext, "Cat took off", Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onAnimationEnd(animation: Animator) {
                    // 4
                    Toast.makeText(applicationContext, "Cat is on the moon", Toast.LENGTH_SHORT)
                        .show()
                    animator2.duration = 5000L
                    animator2.start()
                    //finish()
                }

                override fun onAnimationCancel(animation: Animator) {}

                override fun onAnimationRepeat(animation: Animator) {}
            })

            animator.duration = 5000L
            animator.start()


        }
    }
}



