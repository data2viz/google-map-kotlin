@file:JsQualifier("google.maps.drawing")

package google.maps.drawing

import google.maps.*


external class DrawingManager : MVCObject {
    constructor (options: DrawingManagerOptions)

    fun getDrawingMode(): OverlayType
    fun getMap(): Map
    fun setDrawingMode(drawingMode: OverlayType)
    fun setMap(map: Map)
    fun setOptions(options: DrawingManagerOptions)
}

external interface DrawingManagerOptions {
    var circleOptions: CircleOptions
    var drawingControl: Boolean
    var drawingControlOptions: DrawingControlOptions
    var drawingMode: OverlayType
    var map: Map
    var markerOptions: MarkerOptions
    var polygonOptions: PolygonOptions
    var polylineOptions: PolylineOptions
    var rectangleOptions: RectangleOptions
}

external interface DrawingControlOptions {
    var drawingModes: Array<OverlayType>
    var position: ControlPosition
}

external interface OverlayCompleteEvent {
    var overlay: MVCObject
    var type: OverlayType
}

external enum class OverlayType {
    CIRCLE,
    MARKER,
    POLYGON,
    POLYLINE,
    RECTANGLE
}
