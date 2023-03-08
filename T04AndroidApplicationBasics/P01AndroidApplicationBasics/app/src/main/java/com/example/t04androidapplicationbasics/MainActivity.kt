package com.example.t04androidapplicationbasics

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.core.text.set
import com.example.t04androidapplicationbasics.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private var actionCounter: Int = 0;

    private val history: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        binding.buttonEnter.setOnClickListener {
            if( binding.editTextInputText.text.isNotEmpty() ) {
                actionCounter++
                val enteredText = binding.editTextInputText.text.toString()
                binding.editTextInputText.text.clear();
                history.add(enteredText)

                val textToDisplay = "$actionCounter. $enteredText"
                binding.textView.text = textToDisplay
            }
        }
        binding.buttonReset.setOnClickListener {
            actionCounter = 0;
            history.clear()
            binding.textView.text = ""
            binding.editTextInputText.text.clear()
        }

        binding.buttonUndo.setOnClickListener {
            if (history.isNotEmpty()) {
                if(actionCounter > 0) {
                    actionCounter--
                }
                val currentText = history[history.lastIndex]
                history.removeAt(history.lastIndex)
                binding.editTextInputText.setText(currentText);

                var textToDisplay = ""

                if (history.isNotEmpty()) {
                    val previousText = history[history.lastIndex]

                    textToDisplay = "$actionCounter. $previousText"
                }

                binding.textView.text = textToDisplay
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}