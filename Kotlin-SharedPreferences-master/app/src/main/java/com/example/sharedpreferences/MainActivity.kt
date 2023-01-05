package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreferences.databinding.ActivityMainBinding

// 1 Constante con el nombre del archivo
private const val sharedPreferences= "com.example.sharedpreferences"

class MainActivity : AppCompatActivity() {
// 2 Declara binding
    private lateinit var  biding : ActivityMainBinding

    //3 agregar variable que accede a las shared preferences
    private  lateinit var msharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  4Inflar la vista
        biding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(biding.root)

        // 5 declara la constante modo privado se crea el archivo

        msharedPreferences = getSharedPreferences(sharedPreferences, Context.MODE_PRIVATE)

        // datos
        val key1= "Key1"
        val email ="M.canedo@gmail.com"

        // 6 Escribir en las preferencias comit puede bloquear lA UI
        msharedPreferences.edit().putString(key1,email).apply()
        msharedPreferences.edit().putInt("key2",100).apply()
        msharedPreferences.edit().putFloat("key3", 4.5F).apply()

        // LEER DESDE LAS PREFERENCIAS
        val emailObtenido = msharedPreferences.getString(key1,"")
        biding.TextView1.text = emailObtenido



        // Reemplazo o update

        var email2 ="OtroCorreo"
        msharedPreferences.edit().putString(key1,email2).apply()


        // borrar 1  por medio de la key
        msharedPreferences.edit().remove("key1").apply()





}}