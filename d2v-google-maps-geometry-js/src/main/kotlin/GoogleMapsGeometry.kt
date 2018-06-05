@file:JsQualifier("google.maps.geometry")

package google.maps.geometry

import google.maps.LatLng
import google.maps.Polygon


external class encoding {
    companion object {
        fun decodePath(encodedPath: String): LatLng
        fun encodePath(path: Array<Any>): String
    }
}


external class spherical {
    companion object {
        fun computeArea(path: Array<Any>, radius: Double): Double
        fun computeDistanceBetween(from: LatLng, to: LatLng, radius: Double): Double
        fun computeHeading(from: LatLng, to: LatLng): Double
        fun computeLength(path: Array<Any>, radius: Double): Double
        fun computeOffset(from: LatLng, distance: Double, heading: Double, radius: Double): LatLng
        fun computeSignedArea(loop: Array<Any>, radius: Double): Double
        fun interpolate(from: LatLng, to: LatLng, fraction: Double): LatLng
    }
}

external class poly {
    fun containsLocation(point: LatLng, polygon: Polygon): Boolean
    fun isLocationOnEdge(point: LatLng, poly: Any, tolerance: Double): Boolean
}