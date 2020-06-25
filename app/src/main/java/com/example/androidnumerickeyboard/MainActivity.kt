package com.example.androidnumerickeyboard

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

  /*       val dialogView: View =
             layoutInflater.inflate(R.layout.keyboard_layout, null)
         val dialog = BottomSheetDialog(this)
         dialog.setContentView(dialogView)
         dialog.show() // using BottomSheetDialogFragment
*/
         val bottomSheetFragment = BottomSheetFragment()


         field.setOnClickListener {
             bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
         }
    }
}