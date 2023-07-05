package com.ramos.franco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.ramos.franco.databinding.ActivityMapBinding
import com.ramos.franco.databinding.ActivitySplashScreenBinding

class MapActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var  binding: ActivityMapBinding
    private lateinit var   googleMap :GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val  fragmentMap =supportFragmentManager.findFragmentById(R.id.fvc_map) as SupportMapFragment
        fragmentMap.getMapAsync(this)


    }

    override fun onMapReady(map: GoogleMap) {
        googleMap=map

        val  idatCentroLocation=LatLng(-12.101224,-77.035919)
        val  precioUnoLocation=LatLng(-12.0062399,-77.1378012)
        val  parquedelasLeyendasLocation=LatLng(12.072528,-77.0917129)

        googleMap.addMarker(MarkerOptions().position(idatCentroLocation).title("Idat Centro"))
        googleMap.addMarker(MarkerOptions().position(precioUnoLocation).title("Precio Uno"))
        googleMap.addMarker(MarkerOptions().position(parquedelasLeyendasLocation).title("Parque de las Leyendas"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(idatCentroLocation,16f))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(precioUnoLocation,16f))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(parquedelasLeyendasLocation,16f))
    }
}