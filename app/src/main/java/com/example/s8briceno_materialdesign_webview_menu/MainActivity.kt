package com.example.s8briceno_materialdesign_webview_menu

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible



class MainActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var contenedor: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbar)
        //setSupportActionBar(toolbar)

        contenedor = findViewById(R.id.contenedor)

        // Mostrar pantalla de inicio por defecto
        mostrarInicio()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_inicio -> mostrarInicio()
            R.id.menu_contenido -> mostrarContenido()
            R.id.menu_uns -> mostrarWeb("https://www.uns.edu.pe")
            R.id.menu_biblioteca -> mostrarWeb("https://biblioteca.uns.edu.pe")
            R.id.menu_campus_virtual -> mostrarWeb("https://www.uns.edu.pe/campusvirtual/")
            R.id.menu_intranet -> mostrarWeb("https://www.uns.edu.pe/#/intranet")
        }
        return true
    }

    private fun mostrarInicio() {
        contenedor.removeAllViews()
        val view = layoutInflater.inflate(R.layout.layout_inicio, contenedor, false)

        // Manejar el botón "Conocer más"
        val btnConocerMas = view.findViewById<Button>(R.id.btnConocerMas)
        btnConocerMas.setOnClickListener {
            mostrarContenido() // o puedes usar mostrarWeb("https://www.uns.edu.pe")
        }

        contenedor.addView(view)
    }

    private fun mostrarContenido() {
        contenedor.removeAllViews()
        val view = layoutInflater.inflate(R.layout.layout_contenido, contenedor, false)
        contenedor.addView(view)
    }

    private fun mostrarWeb(url: String) {
        contenedor.removeAllViews()
        val view = layoutInflater.inflate(R.layout.layout_webview, contenedor, false)
        val webView = view.findViewById<WebView>(R.id.webView)
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(url)
        contenedor.addView(view)
    }

}