package com.example.golfcoursesinamap

import com.google.android.gms.maps.model.LatLng

import com.google.maps.android.clustering.ClusterItem


class GolfCourseItem : ClusterItem {
    private var mPosition: LatLng
    private var mTitle: String = ""
    private var mSnippet: String = ""
    private var mType: String = ""

    constructor(lat: Double, lng: Double) {
        mPosition = LatLng(lat, lng)
    }

    constructor(
        lat: Double,
        lng: Double,
        title: String,
        type: String
    ) {
        mPosition = LatLng(lat, lng)
        mTitle = title
        mType = type
    }

    override fun getPosition(): LatLng {
        return mPosition
    }

    override fun getTitle(): String? {
        return mTitle
    }

    override fun getSnippet(): String? {
        return mSnippet
    }

    fun getType(): String {
        return mType
    }
}
