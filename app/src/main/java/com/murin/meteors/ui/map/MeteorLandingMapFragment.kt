package com.murin.meteors.ui.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mapbox.mapboxsdk.annotations.MarkerOptions
import com.mapbox.mapboxsdk.camera.CameraPosition
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.murin.meteors.Provider
import com.murin.meteors.databinding.FragmentMeteorLandingMapBinding

class MeteorLandingMapFragment: Fragment() {
    private lateinit var viewModel: MeteorLandingMapViewModel
    private lateinit var mapView: MapView
    private lateinit var mapboxMap: MapboxMap

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMeteorLandingMapBinding.inflate(inflater, container, false)
        val context = context ?: return binding.root
        val meteorId = MeteorLandingMapFragmentArgs.fromBundle(arguments!!).meteorId

        val factory = Provider.provideMeteorLandingMapViewModelFactory(meteorId, context)
        viewModel = ViewModelProviders.of(this, factory).get(MeteorLandingMapViewModel::class.java)

        mapView = binding.mapView.apply {
            onCreate(savedInstanceState)
        }
        mapView.getMapAsync {
            mapboxMap = it
            subscribeUi()
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    private fun subscribeUi() {
        viewModel.getMeteor().observe(viewLifecycleOwner, Observer { meteors ->
            meteors[0].let { meteor ->
                val latLng = meteor.geolocation.run {
                    LatLng(lat.toDouble(), lng.toDouble())
                }

                val markerViewOptions = MarkerOptions()
                    .position(latLng)
                    .title("${meteor.name} (${meteor.year})")
                    .snippet("Class: ${meteor.recClass}, Mass: ${meteor.massKg()}")

                mapboxMap.addMarker(markerViewOptions)

                val position = CameraPosition.Builder()
                    .target(latLng)
                    .build()
                mapboxMap.animateCamera(CameraUpdateFactory.newCameraPosition(position), 500)
            }
        })
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }
}
