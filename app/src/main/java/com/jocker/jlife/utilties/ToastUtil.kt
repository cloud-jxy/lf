package com.jocker.jlife.utilties

import android.content.Context
import android.widget.Toast

object ToastUtil {

    fun showToast(context: Context,str: String){
        Toast.makeText(context,str,Toast.LENGTH_LONG).show()
    }
}