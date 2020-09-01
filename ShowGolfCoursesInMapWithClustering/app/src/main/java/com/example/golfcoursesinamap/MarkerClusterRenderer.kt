package com.example.golfcoursesinamap

import android.R
import android.content.Context
import android.view.ViewGroup
import android.widget.ImageView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.clustering.ClusterManager
import com.google.maps.android.clustering.view.DefaultClusterRenderer
import com.google.maps.android.ui.IconGenerator


class MarkerClusterRenderer(
    context: Context?,
    map: GoogleMap?,
    clusterManager: ClusterManager<GolfCourseItem>?
) :
    DefaultClusterRenderer<GolfCourseItem>(context, map, clusterManager) {

    val courseTypes: Map<String, Float> = mapOf(
        "?" to BitmapDescriptorFactory.HUE_VIOLET,
        "Etu" to BitmapDescriptorFactory.HUE_BLUE,
        "Kulta" to BitmapDescriptorFactory.HUE_GREEN,
        "Kulta/Etu" to BitmapDescriptorFactory.HUE_YELLOW
    )

    override fun onBeforeClusterItemRendered(
        item: GolfCourseItem,
        markerOptions: MarkerOptions
    ) {
        val iconBitmap = courseTypes.get(item.getType())
        markerOptions.icon((iconBitmap?.let { BitmapDescriptorFactory.defaultMarker(it) }))
    }
}