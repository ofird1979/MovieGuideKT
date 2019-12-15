package com.ofird.movieguidekt

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.ofird.movieguidekt.ui.main.SectionsPagerAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkPermissions()
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)!!.setIcon(R.mipmap.favorites)
        tabs.getTabAt(1)!!.setIcon(R.mipmap.popular)
        tabs.getTabAt(2)!!.setIcon(R.mipmap.top_rated)
        tabs.getTabAt(3)!!.setIcon(R.mipmap.search)
        viewPager.currentItem
    }

    private fun checkPermissions() {
        if (ContextCompat.checkSelfPermission(
                this@MainActivity,
                Manifest.permission.INTERNET
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            Toast.makeText(this@MainActivity, "Permission denied to internet", Toast.LENGTH_LONG)
                .show()
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this@MainActivity,
                    Manifest.permission.INTERNET
                )
            ) {
            } else {
                ActivityCompat.requestPermissions(
                    this@MainActivity,
                    arrayOf(Manifest.permission.INTERNET),
                    1
                )
            }
        } else {
            Toast.makeText(this@MainActivity, "Permission alredy granted", Toast.LENGTH_LONG).show()
        }

        if (ContextCompat.checkSelfPermission(
                this@MainActivity,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            Toast.makeText(
                this@MainActivity,
                "Permission denied to extrenal storage",
                Toast.LENGTH_LONG
            ).show()
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this@MainActivity,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                )
            ) {
            } else {
                ActivityCompat.requestPermissions(
                    this@MainActivity,
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    1
                )
            }
        } else {
            Toast.makeText(
                this@MainActivity,
                "Permission alredy granted to external storage",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_add -> Toast.makeText(
                this,
                "This would be a new intent to editor activity",
                Toast.LENGTH_LONG
            ).show()
            R.id.exit -> Toast.makeText(
                this,
                "This would Exit the application",
                Toast.LENGTH_LONG
            ).show()
            R.id.deleteAll -> Toast.makeText(
                this,
                "This action would delete all items from favorites",
                Toast.LENGTH_LONG
            ).show()
            else -> Toast.makeText(
                this,
                "This action is not registered yet",
                Toast.LENGTH_LONG
            ).show()

        }
        return false
    }
}