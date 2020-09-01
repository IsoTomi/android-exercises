package com.example.citymapexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Cities
        val oulu = LatLng(65.01236, 25.46816)
        val tampere = LatLng(61.49911, 23.78712)
        val jyvaskyla = LatLng(62.24147, 25.72088)
        val helsinki = LatLng(60.16952, 24.93545)
        val kuopio = LatLng(62.5550, 27.40058)

        // Add markers
        mMap.addMarker(MarkerOptions().position(oulu).title("Oulu").snippet("My homecity"))
        mMap.addMarker(MarkerOptions().position(tampere).title("Tampere").snippet("Nice place"))
        mMap.addMarker(MarkerOptions().position(jyvaskyla).title("Jyväskylä").snippet("JAMK is here"))
        mMap.addMarker(MarkerOptions().position(helsinki).title("Helsinki").snippet("The capital of Finland"))
        mMap.addMarker(MarkerOptions().position(kuopio).title("Kuopio").snippet("Never been here"))

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(jyvaskyla, 5.5f))
        mMap.uiSettings.isZoomControlsEnabled = true
    }

    override fun onMarkerClick(marker: Marker?): Boolean {
        Toast.makeText(this, marker!!.title, Toast.LENGTH_LONG).show()
        return true
    }
}