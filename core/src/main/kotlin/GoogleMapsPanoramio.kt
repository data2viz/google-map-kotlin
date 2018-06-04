@file:JsQualifier("google.maps.panoramio")

package google.maps.panoramio

import google.maps.LatLng
import google.maps.MVCObject
import google.maps.Size

external class PanoramioLayer : MVCObject {
    constructor (opts: PanoramioLayerOptions)

    fun getMap(): google.maps.Map
    fun getTag(): String
    fun getUserId(): String
    fun setMap(map: google.maps.Map)
    fun setOptions(options: PanoramioLayerOptions)
    fun setTag(tag: String)
    fun setUserId(userId: String)
}

external interface PanoramioLayerOptions {
    var map: google.maps.Map
    var suppressInfoWindows: Boolean
    var tag: String
    var userId: String
}

external interface PanoramioFeature {
    var author: String
    var photoId: String
    var title: String
    var url: String
    var userId: String
}

external interface PanoramioMouseEvent {
    var featureDetails: PanoramioFeature
    var infoWindowHtml: String
    var latLng: LatLng
    var pixelOffset: Size
}

