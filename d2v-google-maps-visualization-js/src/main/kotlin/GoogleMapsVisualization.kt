@file:JsQualifier("google.maps.visualization")
package google.maps.visualization

import google.maps.LatLng
import google.maps.MVCArray
import google.maps.MVCObject

external class HeatmapLayer : MVCObject {
    constructor (opts: HeatmapLayerOptions)

    fun getData(): MVCArray
    fun getMap(): google.maps.Map
    fun setData(dat: MVCArray)
    fun setData(dat: Array<LatLng>)
    fun setData(dat: Array<WeightedLocation>)
    fun setMap(map: google.maps.Map)
}

external class HeatmapLayerOptions {
    var `data`: Array<LatLng>
    var dissipating: Boolean
    var gradient: Array<String>
    var map: google.maps.Map
    var maxIntensity: Double
    var opacity: Double
    var radius: Double
}

external interface WeightedLocation {
    var location: LatLng
    var weight: Double
}
