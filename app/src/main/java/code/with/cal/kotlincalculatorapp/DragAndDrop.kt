package code.with.cal.kotlincalculatorapp

import android.content.ClipData
import android.content.ClipDescription
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.DragEvent
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.draganddrop.*
import android.view.View
import android.widget.Toast

class DragAndDrop: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.draganddrop)

        val IMAGEVIEW_TAG = "icon bitmap"
        val imageView = ImageView(catIV.context).apply {
            //setImageBitmap()
            tag = IMAGEVIEW_TAG
            setOnLongClickListener { v ->

                val item = ClipData.Item(v.tag as? CharSequence)

                val dragData = ClipData(
                    v.tag as? CharSequence,
                    arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                    item)

                val myShadow = MyDragShadowBuilder( this)

                v.startDragAndDrop(dragData,
                    myShadow,
                    null,
                    0
                )
                true
            }
        }



        val imageView2 = ImageView(this)

// Set the drag event listener for the View.
        imageView.setOnDragListener { v, e ->

            // Handle each of the expected events.
            when (e.action) {
                DragEvent.ACTION_DRAG_STARTED -> {
                    // Determine whether this View can accept the dragged data.
                    if (e.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                        // As an example, apply a blue color tint to the View to
                        // indicate that it can accept data.
                        (v as? ImageView)?.setColorFilter(Color.BLUE)

                        // Invalidate the view to force a redraw in the new tint.
                        v.invalidate()

                        // Return true to indicate that the View can accept the dragged
                        // data.
                        true
                    } else {
                        // Return false to indicate that, during the current drag and
                        // drop operation, this View doesn't receive events again until
                        // ACTION_DRAG_ENDED is sent.
                        false
                    }
                }
                DragEvent.ACTION_DRAG_ENTERED -> {
                    // Apply a green tint to the View.
                    (v as? ImageView)?.setColorFilter(Color.GREEN)

                    // Invalidate the view to force a redraw in the new tint.
                    v.invalidate()

                    // Return true. The value is ignored.
                    true
                }

                DragEvent.ACTION_DRAG_LOCATION ->
                    // Ignore the event.
                    true
                DragEvent.ACTION_DRAG_EXITED -> {
                    // Reset the color tint to blue.
                    (v as? ImageView)?.setColorFilter(Color.BLUE)

                    // Invalidate the view to force a redraw in the new tint.
                    v.invalidate()

                    // Return true. The value is ignored.
                    true
                }
                DragEvent.ACTION_DROP -> {
                    // Get the item containing the dragged data.
                    val item: ClipData.Item = e.clipData.getItemAt(0)

                    // Get the text data from the item.
                    val dragData = item.text

                    // Display a message containing the dragged data.
                    Toast.makeText(this, "Dragged data is $dragData", Toast.LENGTH_LONG).show()

                    // Turn off color tints.
                    (v as? ImageView)?.clearColorFilter()

                    // Invalidate the view to force a redraw.
                    v.invalidate()

                    // Return true. DragEvent.getResult() returns true.
                    true
                }

                DragEvent.ACTION_DRAG_ENDED -> {
                    // Turn off color tinting.
                    (v as? ImageView)?.clearColorFilter()

                    // Invalidate the view to force a redraw.
                    v.invalidate()

                    // Do a getResult() and display what happens.
                    when(e.result) {
                        true ->
                            Toast.makeText(this, "The drop was handled.", Toast.LENGTH_LONG)
                        else ->
                            Toast.makeText(this, "The drop didn't work.", Toast.LENGTH_LONG)
                    }.show()

                    // Return true. The value is ignored.
                    true
                }
                else -> {
                    // An unknown action type is received.
                    Log.e("DragDrop Example", "Unknown action type received by View.OnDragListener.")
                    false
                }
            }
        }
    }


}