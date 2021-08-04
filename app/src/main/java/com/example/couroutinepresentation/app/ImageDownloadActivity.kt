package com.example.couroutinepresentation.app

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.couroutinepresentation.R
import kotlinx.android.synthetic.main.activity_image_download.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL
private const val TAG = "MY_TAG"
class ImageDownloadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_download)

        btn_load_image.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {
                try {
                    Log.d(TAG, "onCreate: ThreadName: ${Thread.currentThread().name}")
                    val url = URL("https://o1dev-catalogueimages.cdn.zyxw365.in/6217348923-thumbnail.jpeg")
                    val bitmap = BitmapFactory.decodeStream(url.openStream())

                    withContext(Dispatchers.Main) {
                        Log.d(
                            TAG,
                            "onCreate withContext: ThreadName: ${Thread.currentThread().name}"
                        )
                        im_image.setImageBitmap(bitmap)
                    }
                } catch (e: Exception) {
                    Log.d(TAG, "onCreate: ${e}")
                }
            }
        }
    }

}