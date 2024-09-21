package com.kavi.flashlight

import android.content.Context
import android.hardware.camera2.CameraManager
import android.os.Handler
import android.os.Looper
import android.widget.Toast

fun torch(context: Context,state: Boolean){
    lateinit var cameraID: String
    val cameraManager: CameraManager =context.getSystemService(Context.CAMERA_SERVICE) as CameraManager
    cameraID =cameraManager.cameraIdList[0]

    if(state){
        cameraManager.setTorchMode(cameraID,true)
        // to show the toast msg for custom time
        showCustomToast(context,"Flash is turned On",1500)
    }else{
        cameraManager.setTorchMode(cameraID,false)
        // to show the toast msg for custom time
        showCustomToast(context,"Flash is turned Off",1500)
    }
}


//to make the Toast Visible for custom time
fun showCustomToast(context: Context, message: String, durationInMilliseconds: Int) {
    val toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
    val handler = Handler(Looper.getMainLooper())
    toast.show()
    handler.postDelayed({ toast.cancel() }, durationInMilliseconds.toLong())
}