package com.example.assessmenttask.activities

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProvider
import com.example.assessmenttask.R
import com.example.assessmenttask.databinding.ActivityMainBinding
import com.example.assessmenttask.viewModel.MainViewModel
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    private lateinit var manViewModel: MainViewModel
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var alertDialogExit: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        manViewModel= ViewModelProvider(this)[MainViewModel::class.java]

        manViewModel.getCatFact()
        activityMainBinding.buttonReload.setOnClickListener {
            manViewModel.getCatFact()
        }
        manViewModel.getCatFactLiveData()?.observe(this) {
            activityMainBinding.catFact.text = it?.fact
            activityMainBinding.catLength.text = it?.length.toString()

        }

        onBackPressedDispatcher.addCallback(this , object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                showExitDialog()
            }
        })
    }






   private fun showExitDialog() {
        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = this@MainActivity.layoutInflater
        val dialogView: View = inflater.inflate(R.layout.layout_exit_dialog, null)
        dialogBuilder.setView(dialogView)
        val buttonYes  = dialogView.findViewById<Button>(R.id.buttonYes)
        val buttonNo = dialogView.findViewById<Button>(R.id.buttonNo)
        alertDialogExit = dialogBuilder.create()
        alertDialogExit.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertDialogExit.show()
        buttonNo.setOnClickListener {
            alertDialogExit.dismiss()
        }
        buttonYes.setOnClickListener {
            exitProcess(0)
        }
        alertDialogExit.setCancelable(false)

    }
}