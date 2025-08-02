package com.sehovm.myapplication.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sehovm.myapplication.R
import com.sehovm.myapplication.data.DBManager
import kotlinx.coroutines.selects.SelectInstance

class MainActivity : AppCompatActivity() {

    val dbManager = DBManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    /* fun onClickSave(view: View) {
        dbManager.openDB()
        //dbManager.insertToDB()
        dbManager.closeDB()
    } */
}