@file:JsQualifier("google.maps")
package google.maps

import org.w3c.dom.Document
import org.w3c.dom.Element


/***** MVC *****/
open external class MVCObject() {
    fun bindTo(key: String, target: MVCObject, targetKey: String, noNotify: Boolean)
    fun changed(key: String)
    fun get(key: String): Any
    fun notify(key: String)
    fun set(key: String, value: Any)
    fun setValues(values: Any)
    fun unbind(key: String)
    fun unbindAll()
}

external class MVCArray(array: Array<Any>) : MVCObject {

    fun clear()
    fun forEach(callback: (elem: Any, index: Double) -> Unit)
    fun getArray(): Array<Any>
    fun getAt(i: Double): Any
    fun getLength(): Double
    fun insertAt(i: Double, elem: Any)
    fun pop()
    fun push(elem: Any): Double
    fun removeAt(i: Double): Any
    fun setAt(i: Double, elem: Any)
}

/***** Map *****/
external class Map(mapDiv: Element, opts: MapOptions) : MVCObject {

    fun fitBounds(bounds: LatLngBounds)
    fun getBounds(): LatLngBounds
    fun getCenter(): LatLng
    fun getDiv(): Element
    fun getHeading(): Double
    fun getMapTypeId(): MapTypeId
    fun getProjection(): Projection
    fun getStreetView(): StreetViewPanorama
    fun getTilt(): Double
    fun getZoom(): Int
    fun panBy(x: Double, y: Double)
    fun panTo(latLng: LatLng)
    fun panToBounds(latLngBounds: LatLngBounds)
    fun setCenter(latlng: LatLng)
    fun setHeading(heading: Double)
    fun setMapTypeId(mapTypeId: MapTypeId)
    fun setOptions(options: MapOptions)
    fun setStreetView(panorama: StreetViewPanorama)
    fun setTilt(tilt: Double)
    fun setZoom(zoom: Int)
    fun addListener(event: String, function: () -> Unit)

    var  controls: Array<MVCArray>
    var mapTypes: MapTypeRegistry
    var overlayMapTypes: MVCArray
}

external class MapOptions {
    var backgroundColor: String
    var center: LatLng
    var disableDefaultUI: Boolean
    var disableDoubleClickZoom: Boolean
    var draggable: Boolean
    var draggableCursor: String
    var draggingCursor: String
    var fullscreenControl: Boolean
    var heading: Double
    var keyboardShortcuts: Boolean
    var mapMaker: Boolean
    var mapTypeControl: Boolean
    var mapTypeControlOptions: MapTypeControlOptions
    var mapTypeId: MapTypeId
    var maxZoom: Int
    var minZoom: Int
    var noClear: Boolean
    var overviewMapControl: Boolean
    var overviewMapControlOptions: OverviewMapControlOptions
    var panControl: Boolean
    var panControlOptions: PanControlOptions
    var rotateControl: Boolean
    var rotateControlOptions: RotateControlOptions
    var scaleControl: Boolean
    var scaleControlOptions: ScaleControlOptions
    var scrollwheel: Boolean
    var streetView: Boolean
    var streetViewControlOptions: StreetViewControlOptions
    var styles: Array<MapTypeStyle>
    var tilt: Double
    var zoom: Int
    var zoomControl: Boolean
    var zoomControlOptions: ZoomControlOptions
}

external enum class MapTypeId {
    HYBRID,
    ROADMAP,
    SATELLITE,
    TERRAIN
}

/***** Controls *****/
external interface MapTypeControlOptions {
    var mapTypeIds: Array<MapTypeId>
    var position: ControlPosition
    var style: MapTypeControlStyle
}

external enum class MapTypeControlStyle {
    DEFAULT,
    DROPDOWN_MENU,
    HORIZONTAL_BAR
}

external interface OverviewMapControlOptions {
    var opened: Boolean
}

external interface PanControlOptions {
    var position: ControlPosition
}

external interface RotateControlOptions {
    var position: ControlPosition
}

external interface ScaleControlOptions {
    var position: ControlPosition
    var style: ScaleControlStyle
}

external enum class ScaleControlStyle {
    DEFAULT
}

external interface StreetViewControlOptions {
    var position: ControlPosition
}

external interface ZoomControlOptions {
    var position: ControlPosition
    var style: ZoomControlStyle
}

external enum class ZoomControlStyle {
    DEFAULT,
    LARGE,
    SMALL
}

external enum class ControlPosition {
    BOTTOM_CENTER,
    BOTTOM_LEFT,
    BOTTOM_RIGHT,
    LEFT_BOTTOM,
    LEFT_CENTER,
    LEFT_TOP,
    RIGHT_BOTTOM,
    RIGHT_CENTER,
    RIGHT_TOP,
    TOP_CENTER,
    TOP_LEFT,
    TOP_RIGHT
}

/***** Overlays *****/
external class Marker : MVCObject {
    constructor (opts: MarkerOptions)

    fun getAnimation(): Animation
    fun getClickable(): Boolean
    fun getCursor(): String
    fun getDraggable(): Boolean
    fun getFlat(): Boolean
    fun getIcon(): MarkerImage
    fun getMap(): Map
    //        fun getMap(): StreetViewPanorama
    fun getPosition(): LatLng

    fun getShadow(): MarkerImage
    fun getShape(): MarkerShape
    fun getTitle(): String
    fun getVisible(): Boolean
    fun getZIndex(): Double
    fun setAnimation(animation: Animation)
    fun setClickable(flag: Boolean)
    fun setCursor(cursor: String)
    fun setDraggable(flag: Boolean)
    fun setFlat(flag: Boolean)
    fun setIcon(icon: MarkerImage)
    fun setIcon(icon: String)
    fun setMap(map: Map)
    fun setMap(map: StreetViewPanorama)
    fun setOptions(options: MarkerOptions)
    fun setPosition(latlng: LatLng)
    fun setShadow(shadow: MarkerImage)
    fun setShadow(shadow: String)
    fun setShape(shape: MarkerShape)
    fun setTitle(title: String)
    fun setVisible(visible: Boolean)
    fun setZIndex(zIndex: Double)
}

external interface MarkerOptions {
    var animation: Animation
    var clickable: Boolean
    var cursor: String
    var draggable: Boolean
    var flat: Boolean
    var icon: Any
    var map: Any
    var optimized: Boolean
    var position: LatLng
    var raiseOnDrag: Boolean
    var shadow: Any
    var shape: MarkerShape
    var title: String
    var visible: Boolean
    var zIndex: Double
}

external class MarkerImage {
    constructor (url: String, size: Size, origin: Point, anchor: Point, scaledSize: Size)

    var anchor: Point
    var origin: Point
    var scaledSize: Size
    var size: Size
    var url: String
}

external interface MarkerShape {
    var coords: Array<Double>
    var type: String
}

external interface Symbol {
    var anchor: Point
    var fillColor: String
    var fillOpacity: Double
    var path: Any
    var rotation: Double
    var scale: Double
    var strokeColor: String
    var strokeOpacity: Double
    var strokeWeight: Double
}

external enum class SymbolPath {
    BACKWARD_CLOSED_ARROW,
    BACKWARD_OPEN_ARROW,
    CIRCLE,
    FORWARD_CLOSED_ARROW,
    FORWARD_OPEN_ARROW
}

external enum class Animation {
    BOUNCE,
    DROP
}

external class InfoWindow : MVCObject {
    constructor (opts: InfoWindowOptions)
    fun close()
    fun getContent(): String
//    fun getContent(): Element
    fun getPosition(): LatLng
    fun getZIndex(): Double
    fun open(map: Map, anchor: MVCObject)
    fun open(map: StreetViewPanorama, anchor: MVCObject)
//    fun setContent(content: Node)
    fun setContent(content: String)
    fun setOptions(options: InfoWindowOptions)
    fun setPosition(position: LatLng)
    fun setZIndex(zIndex: Double)
}

external interface InfoWindowOptions {
    var content: Any
    var disableAutoPan: Boolean
    var maxWidth: Double
    var pixelOffset: Size
    var position: LatLng
    var zIndex: Double
}

external class Polyline : MVCObject {
    constructor (opts: PolylineOptions)

    fun getEditable(): Boolean
    fun getMap(): Map
    fun getPath(): MVCArray
    fun getVisible(): Boolean
    fun setEditable(editable: Boolean)
    fun setMap(map: Map)
    fun setOptions(options: PolylineOptions)
    fun setPath(path: MVCArray)
    fun setPath(path: Array<LatLng>)
    fun setVisible(visible: Boolean)
}

external interface PolylineOptions {
    var clickable: Boolean
    var editable: Boolean
    var geodesic: Boolean
    var icons: Array<IconSequence>
    var map: Map
    var path: Array<Any>
    var strokeColor: String
    var strokeOpacity: Double
    var strokeWeight: Double
    var visible: Boolean
    var zIndex: Double
}

external interface IconSequence {
    var icon: Symbol
    var offset: String
    var repeat: String
}

external class Polygon : MVCObject {
    constructor (opts: PolygonOptions)

    fun getEditable(): Boolean
    fun getMap(): Map
    fun getPath(): MVCArray
    fun getPaths(): Array<MVCArray>
    fun getVisible(): Boolean
    fun setEditable(editable: Boolean)
    fun setMap(map: Map)
    fun setOptions(options: PolygonOptions)
    fun setPath(path: MVCArray)
    fun setPath(path: Array<LatLng>)
    fun setPaths(paths: MVCArray)
    fun setPaths(paths: Array<MVCArray>)
    fun setPaths(path: Array<LatLng>)
    fun setVisible(visible: Boolean)
}

external interface PolygonOptions {
    var clickable: Boolean
    var editable: Boolean
    var fillColor: String
    var fillOpacity: Double
    var geodesic: Boolean
    var map: Map
    var paths: Array<Any>
    var strokeColor: String
    var strokeOpacity: Double
    var strokeWeight: Double
    var visible: Boolean
    var zIndex: Double
}

external interface PolyMouseEvent {
    var edge: Double
    var path: Double
    var vertex: Double
}

external class Rectangle : MVCObject {
    constructor (opts: RectangleOptions)

    fun getBounds(): LatLngBounds
    fun getEditable(): Boolean
    fun getMap(): Map
    fun getVisible(): Boolean
    fun setBounds(bounds: LatLngBounds)
    fun setEditable(editable: Boolean)
    fun setMap(map: Map)
    fun setOptions(options: RectangleOptions)
    fun setVisible(visible: Boolean)
}

external interface RectangleOptions {
    var bounds: LatLngBounds
    var clickable: Boolean
    var editable: Boolean
    var fillColor: String
    var fillOpacity: Double
    var map: Map
    var strokeColor: String
    var strokeOpacity: Double
    var strokeWeight: Double
    var visible: Boolean
    var zIndex: Double
}

external class Circle : MVCObject {
    constructor (opts: CircleOptions)

    fun getBounds(): LatLngBounds
    fun getCenter(): LatLng
    fun getEditable(): Boolean
    fun getMap(): Map
    fun getRadius(): Double
    fun getVisible(): Boolean
    fun setCenter(center: LatLng)
    fun setEditable(editable: Boolean)
    fun setMap(map: Map)
    fun setOptions(options: CircleOptions)
    fun setRadius(radius: Double)
    fun setVisible(visible: Boolean)
}

external interface CircleOptions {
    var center: LatLng
    var clickable: Boolean
    var editable: Boolean
    var fillColor: String
    var fillOpacity: Double
    var map: Map
    var radius: Double
    var strokeColor: String
    var strokeOpacity: Double
    var strokeWeight: Double
    var visible: Boolean
    var zIndex: Double
}

external class GroundOverlay : MVCObject {
    constructor (url: String, bounds: LatLngBounds, opts: GroundOverlayOptions)

    fun getBounds(): LatLngBounds
    fun getMap(): Map
    fun getOpacity(): Double
    fun getUrl(): String
    fun setMap(map: Map)
    fun setOpacity(opacity: Double)
}

external interface GroundOverlayOptions {
    var clickable: Boolean
    var map: Map
    var opacity: Double
}

external class OverlayView : MVCObject {
    fun draw()
    fun getMap(): Map
    fun getPanes(): MapPanes
    fun getProjection(): MapCanvasProjection
    fun onAdd()
    fun onRemove()
    fun setMap(map: Map)
    fun setMap(map: StreetViewPanorama)
}

external interface MapPanes {
    var floatPane: Element
    var floatShadow: Element
    var mapPane: Element
    var overlayImage: Element
    var overlayLayer: Element
    var overlayMouseTarget: Element
    var overlayShadow: Element
}

external class MapCanvasProjection : MVCObject {
    fun fromContainerPixelToLatLng(pixel: Point, nowrap: Boolean): LatLng
    fun fromDivPixelToLatLng(pixel: Point, nowrap: Boolean): LatLng
    fun fromLatLngToContainerPixel(latLng: LatLng): Point
    fun fromLatLngToDivPixel(latLng: LatLng): Point
    fun getWorldWidth(): Double
}

/***** Services *****/
external class Geocoder {
    constructor ()

    fun geocode(request: GeocoderRequest, callback: (results: Array<GeocoderResult>, status: GeocoderStatus) -> Unit )
}

external interface GeocoderRequest {
    var address: String
    var bounds: LatLngBounds
    var location: LatLng
    var region: String
}

external enum class GeocoderStatus {
    ERROR,
    INVALID_REQUEST,
    OK,
    OVER_QUERY_LIMIT,
    REQUEST_DENIED,
    UNKNOWN_ERROR,
    ZERO_RESULTS
}

external interface GeocoderResult {
    var address_components: Array<GeocoderAddressComponent>
    var formatted_address: String
    var geometry: GeocoderGeometry
    var types: Array<String>
}

external interface GeocoderAddressComponent {
    var long_name: String
    var short_name: String
    var types: Array<String>
}

external interface GeocoderGeometry {
    var bounds: LatLngBounds
    var location: LatLng
    var location_type: GeocoderLocationType
    var viewport: LatLngBounds
}

external enum class GeocoderLocationType {
    APPROXIMATE,
    GEOMETRIC_CENTER,
    RANGE_INTERPOLATED,
    ROOFTOP
}

external class DirectionsRenderer : MVCObject {
    constructor (opts: DirectionsRendererOptions)

    fun getDirections(): Any
    fun getMap(): Map
    fun getPanel(): Element
    fun getRouteIndex(): Double
    fun setDirections(directions: Any)
    fun setMap(map: Map)
    fun setOptions(options: DirectionsRendererOptions)
    fun setPanel(panel: Element)
    fun setRouteIndex(routeIndex: Double)
}

external interface DirectionsRendererOptions {
    var directions: Any
    var draggable: Boolean
    var hideRouteList: Boolean
    var infoWindow: InfoWindow
    var map: Map
    var markerOptions: MarkerOptions
    var panel: Element
    var polylineOptions: PolylineOptions
    var preserveViewport: Boolean
    var routeIndex: Double
    var suppressBicyclingLayer: Boolean
    var suppressInfoWindows: Boolean
    var suppressMarkers: Boolean
    var suppressPolylines: Boolean
}


external class MaxZoomService {
    constructor ()
    fun getMaxZoomAtLatLng(latlng: LatLng, callback: (result: MaxZoomResult) -> Unit )
}

external interface MaxZoomResult {
    var status: MaxZoomStatus
    var zoom: Double
}

external enum class MaxZoomStatus {
    ERROR,
    OK
}


/***** Map Types *****/
external interface MapType {
    fun getTile(tileCoord: Point, zoom: Double, ownerDocument: Document): Element
    fun releaseTile(tile: Element)
    var alt: String
    var maxZoom: Double
    var minZoom: Double
    var name: String
    var projection: Projection
    var radius: Double
    var tileSize: Size
}

external class MapTypeRegistry : MVCObject {
    constructor ()

    fun set(id: String, mapType: MapType)
}

external interface Projection {
    fun fromLatLngToPoint(latLng: LatLng, point: Point): Point
    fun fromPointToLatLng(pixel: Point, noWrap: Boolean): LatLng
}

external class ImageMapType {
    constructor (opts: ImageMapTypeOptions)

    fun getOpacity(): Double
    fun setOpacity(opacity: Double)
}

external interface ImageMapTypeOptions {
    var alt: String
    var getTileUrl: (Point: Double) -> String
    var maxZoom: Double
    var minZoom: Double
    var name: String
    var opacity: Double
    var tileSize: Size
}

external class StyledMapType {
    constructor (styles: Array<MapTypeStyle>, options: StyledMapTypeOptions)
}

external interface StyledMapTypeOptions {
    var alt: String
    var maxZoom: Double
    var minZoom: Double
    var name: String
}


    

external interface MapTypeStyle {
    var elementType: MapTypeStyleElementType
    var featureType: MapTypeStyleFeatureType
    var stylers: Array<MapTypeStyler>
}

external interface MapTypeStyleFeatureType {
//    administrative:
//    {
//        country: String
//        land_parcel: String
//        locality: String
//        neighborhood: String
//        province: String
//    }
//    all: String
//    landscape:
//    {
//        man_made: String
//        natural: String
//    }
//    poi:
//    {
//        attraction: String
//        business: String
//        government: String
//        medical: String
//        park: String
//        place_of_worship: String
//        school: String
//        sports_complex: String
//    }
//    road:
//    {
//        arterial: String
//        highway: { controlled_access: String
//    }
//        local: String
//    }
//    transit:
//    {
//        line: String
//        station: {
//        airport: String
//        bus: String
//        rail: String
//    }
//    }
//    water: String
}

external enum class MapTypeStyleElementType {
    all,
    geometry,
    labels
}

external interface MapTypeStyler {
    var gamma: Double
    var hue: String
    var invert_lightness: Boolean
    var lightness: Double
    var saturation: Double
    var visibility: String
}

/***** Layers *****/
external class BicyclingLayer : MVCObject {
    constructor ()

    fun getMap(): Map
    fun setMap(map: Map)
}

external class FusionTablesLayer : MVCObject {
    constructor (options: FusionTablesLayerOptions)

    fun getMap(): Map
    fun setMap(map: Map)
    fun setOptions(options: FusionTablesLayerOptions)
}

external interface FusionTablesLayerOptions {
    var clickable: Boolean
    var heatmap: FusionTablesHeatmap
    var map: Map
    var query: FusionTablesQuery
    var styles: Array<FusionTablesStyle>
    var suppressInfoWindows: Boolean
}

external interface FusionTablesQuery {
    var from: String
    var limit: Double
    var offset: Double
    var orderBy: String
    var select: String
    var where: String
}

external interface FusionTablesStyle {
    var markerOptions: FusionTablesMarkerOptions
    var polygonOptions: FusionTablesPolygonOptions
    var polylineOptions: FusionTablesPolylineOptions
    var where: String
}

external interface FusionTablesHeatmap {
    var enabled: Boolean
}

external interface FusionTablesMarkerOptions {
    var iconName: String
}

external interface FusionTablesPolygonOptions {
    var fillColor: String
    var fillOpacity: Double
    var strokeColor: String
    var strokeOpacity: Double
    var strokeWeight: Double
}

external interface FusionTablesPolylineOptions {
    var strokeColor: String
    var strokeOpacity: Double
    var strokeWeight: Double
}

external interface FusionTablesMouseEvent {
    var infoWindowHtml: String
    var latLng: LatLng
    var pixelOffset: Size
    var row: Any
}

external interface FusionTablesCell {
    var columnName: String
    var value: String
}

external class KmlLayer : MVCObject {
    constructor (url: String, opts: KmlLayerOptions)

    fun getDefaultViewport(): LatLngBounds
    fun getMap(): Map
    fun getMetadata(): KmlLayerMetadata
    fun getStatus(): KmlLayerStatus
    fun getUrl(): String
    fun setMap(map: Map)
}

external interface KmlLayerOptions {
    var clickable: Boolean
    var map: Map
    var preserveViewport: Boolean
    var suppressInfoWindows: Boolean
}

external interface KmlLayerMetadata {
    var author: KmlAuthor
    var description: String
    var name: String
    var snippet: String
}

external enum class KmlLayerStatus {
    DOCUMENT_NOT_FOUND,
    DOCUMENT_TOO_LARGE,
    FETCH_ERROR,
    INVALID_DOCUMENT,
    INVALID_REQUEST,
    LIMITS_EXCEEDED,
    OK,
    TIMED_OUT,
    UNKNOWN
}

external interface KmlMouseEvent {
    var featureData: KmlFeatureData
    var latLng: LatLng
    var pixelOffset: Size
}

external interface KmlFeatureData {
    var author: KmlAuthor
    var description: String
    var id: String
    var infoWindowHtml: String
    var name: String
    var snippet: String
}

external interface KmlAuthor {
    var email: String
    var name: String
    var uri: String
}

external class TrafficLayer : MVCObject {
    constructor ()

    fun getMap()
    fun setMap(map: Map)
}

external class TransitLayer : MVCObject {
    constructor ()

    fun getMap()
    fun setMap(map: Map)
}

/***** Street View *****/
external class StreetViewPanorama {
    constructor (container: Element, opts: StreetViewPanoramaOptions)
    var controls: Array<MVCArray>
    fun getLinks(): Array<StreetViewLink>
    fun getPano(): String
    fun getPosition(): LatLng
    fun getPov(): StreetViewPov
    fun getVisible(): Boolean
    fun registerPanoProvider(provider: (input: String) -> StreetViewPanoramaData)
    fun setPano(pano: String)
    fun setPosition(latLng: LatLng)
    fun setPov(pov: StreetViewPov)
    fun setVisible(flag: Boolean)

}

external interface StreetViewPanoramaOptions {
    var addressControl: Boolean
    var addressControlOptions: StreetViewAddressControlOptions
    var clickToGo: Boolean
    var disableDoubleClickZoom: Boolean
    var enableCloseButton: Boolean
    var imageDateControl: Boolean
    var linksControl: Boolean
    var panControl: Boolean
    var panControlOptions: PanControlOptions
    var pano: String
    var panoProvider: (input: String) -> StreetViewPanoramaData
    var position: LatLng
    var pov: StreetViewPov
    var scrollwheel: Boolean
    var visible: Boolean
    var zoomControl: Boolean
    var zoomControlOptions: ZoomControlOptions
}

external interface StreetViewAddressControlOptions {
    var position: ControlPosition
}

external interface StreetViewLink {
    var description: String
    var heading: Double
    var pano: String
}

external interface StreetViewPov {
    var heading: Double
    var picth: Double
    var zoom: Double
}

external interface StreetViewPanoramaData {
    var opyright: String
    var imageDate: String
    var links: Array<StreetViewLink>
    var location: StreetViewLocation
    var tiles: StreetViewTileData
}

external interface StreetViewLocation {
    var description: String
    var latLng: LatLng
    var pano: String
}

external interface StreetViewTileData {
    var centerHeading: Double
    var tileSize: Size
    var worldSize: Size
}

external class StreetViewService {
    constructor ()
    fun getPanoramaById(pano: String, callback: (streetViewPanoramaData: StreetViewPanoramaData, streetViewStatus: StreetViewStatus) -> Unit )
    fun getPanoramaByLocation(latlng: LatLng, radius: Double, callback: (streetViewPanoramaData: StreetViewPanoramaData, streetViewStatus: StreetViewStatus) -> Unit )
}

external enum class StreetViewStatus {
    OK,
    UNKNOWN_ERROR,
    ZERO_RESULTS
}

/***** Event *****/
external interface MapsEventListener


external interface event {
//    companion object {
//        fun addDomListener(
//            instance: Any,
//            eventName: String,
//            handler: (event: Any, ...args: Array<Any>) -> void,
//            capture: Boolean
//        ): MapsEventListener
//
//        fun addDomListener(instance: Any, eventName: String, handler: Function, capture: Boolean): MapsEventListener
//        fun addDomListenerOnce(
//            instance: Any,
//            eventName: String,
//            handler: (event: Any, ...args: Array<Any>) -> void,
//            capture: Boolean
//        ): MapsEventListener
//
//        fun addDomListenerOnce(instance: Any, eventName: String, handler: Function, capture: Boolean): MapsEventListener
//        fun addListener(
//            instance: Any,
//            eventName: String,
//            handler: (event: Any, args: Array<Any>? = null) -> Unit
//        ): MapsEventListener
//
//        fun addListener(instance: Any, eventName: String, handler: Function): MapsEventListener
//        fun addListenerOnce(
//            instance: Any,
//            eventName: String,
//            handler: (event: Any, ...args: Array<Any>) -> void
//        ): MapsEventListener
//
//        fun addListenerOnce(instance: Any, eventName: String, handler: Function): MapsEventListener
//        fun clearInstanceListeners(instance: Any)
//        fun clearListeners(instance: Any, eventName: String)
//        fun removeListener(listener: MapsEventListener)
//        fun trigger(instance: Any, eventName: String, ...args: Array<Any>)
//    }
}

external interface MouseEvent {
    fun stop()
    var latLng: LatLng
}

/***** Base *****/
external class LatLng {
    constructor (lat: Double, lng: Double, noWrap: Boolean = definedExternally)
    fun equals(other: LatLng): Boolean
    fun lat(): Double
    fun lng(): Double
    override fun toString(): String
    fun toUrlValue(precision: Double): String

}

external class LatLngBounds {
    constructor (sw: LatLng, ne: LatLng)
    fun contains(latLng: LatLng): Boolean
    fun equals(other: LatLngBounds): Boolean
    fun extend(point: LatLng): LatLngBounds
    fun getCenter(): LatLng
    fun getNorthEast(): LatLng
    fun getSouthWest(): LatLng
    fun intersects(other: LatLngBounds): Boolean
    fun isEmpty(): Boolean
    fun toSpan(): LatLng
    override fun toString(): String
    fun toUrlValue(precision: Double): String
    fun union(other: LatLngBounds): LatLngBounds
}

external class Point {
    constructor (x: Double, y: Double)
    var x: Double
    var y: Double
    fun equals(other: Point): Boolean
    override fun toString(): String
}

external class Size {
    constructor (width: Double, height: Double, widthUnit: String, heightUnit: String)
    var height: Double
    var width: Double
    fun equals(other: Size): Boolean
    override fun toString(): String
}

/***** Geometry Library *****/
//external module geometry {
//    
//    external class encoding {
//        static decodePath(encodedPath: String): LatLng
//        static encodePath(path: Array<Any>): String
//    }
//
//    external class spherical {
//        static computeArea(path: Array<Any>, radius: Double): Double
//        static computeDistanceBetween(from: LatLng, to: LatLng, radius: Double): Double
//        static computeHeading(from: LatLng, to: LatLng): Double
//        static computeLength(path: Array<Any>, radius: Double): Double
//        static computeOffset(from: LatLng, distance: Double, heading: Double, radius: Double): LatLng
//        static computeSignedArea(loop: Array<Any>, radius: Double): Double
//        static interpolate(from: LatLng, to: LatLng, fraction: Double): LatLng
//    }
//
//    external class poly {
//        containsLocation(point: LatLng, polygon: Polygon): Boolean
//        isLocationOnEdge(point: LatLng, poly: Any, tolerance: Double): Boolean
//    }
//}

/***** AdSense Library *****/
//external module adsense {
//    external class AdUnit : MVCObject {
//        constructor (container: Element, opts: AdUnitOptions)
//        getChannelNumber(): String
//        getContainer(): Element
//        getFormat(): AdFormat
//        getMap(): Map
//        getPosition(): ControlPosition
//        getPublisherId(): String
//        setChannelNumber(channelNumber: String)
//        setFormat(format: AdFormat)
//        setMap(map: Map)
//        setPosition(position: ControlPosition)
//    }
//
//    external interface AdUnitOptions {
//        channelNumber: String
//        format: AdFormat
//        map: Map
//        position: ControlPosition
//        publisherId: String
//    }
//
//    external enum class AdFormat {
//        BANNER,
//        BUTTON,
//        HALF_BANNER,
//        LARGE_RECTANGLE,
//        LEADERBOARD,
//        MEDIUM_RECTANGLE,
//        SKYSCRAPER,
//        SMALL_RECTANGLE,
//        SMALL_SQUARE,
//        SQUARE,
//        VERTICAL_BANNER,
//        WIDE_SKYSCRAPER
//    }
//}

/***** Panoramio Library *****/
//external module panoramio {
//    external class PanoramioLayer : MVCObject {
//        constructor (opts: PanoramioLayerOptions)
//        getMap(): Map
//        getTag(): String
//        getUserId(): String
//        setMap(map: Map)
//        setOptions(options: PanoramioLayerOptions)
//        setTag(tag: String)
//        setUserId(userId: String)
//    }
//
//    external interface PanoramioLayerOptions {
//        map: Map
//        suppressInfoWindows: Boolean
//        tag: String
//        userId: String
//    }
//
//    external interface PanoramioFeature {
//        author: String
//        photoId: String
//        title: String
//        url: String
//        userId: String
//    }
//
//    external interface PanoramioMouseEvent {
//        featureDetails: PanoramioFeature
//        infoWindowHtml: String
//        latLng: LatLng
//        pixelOffset: Size
//    }
//}

//external module places {
//
//    external class Autocomplete : MVCObject {
//        constructor (inputField: HTMLInputElement, opts: AutocompleteOptions)
//        getBounds(): LatLngBounds
//        getPlace(): PlaceResult
//        setBounds(bounds: LatLngBounds)
//        setComponentRestrictions(restrictions: ComponentRestrictions)
//        setTypes(types: Array<String>)
//    }
//
//    external interface AutocompleteOptions {
//        bounds: LatLngBounds
//        componentRestrictions: ComponentRestrictions
//        types: Array<String>
//    }
//
//    external interface ComponentRestrictions {
//        country: String
//    }
//
//    external interface PlaceDetailsRequest {
//        reference: String
//    }
//
//    external interface PlaceGeometry {
//        location: LatLng
//        viewport: LatLngBounds
//    }
//
//    external interface PlaceResult {
//        address_components: Array<GeocoderAddressComponent>
//        formatted_address: String
//        formatted_phone_Double: String
//        geometry: PlaceGeometry
//        html_attributions: Array<String>
//        icon: String
//        id: String
//        international_phone_Double: String
//        name: String
//        rating: Double
//        reference: String
//        types: Array<String>
//        url: String
//        vicinity: String
//        website: String
//    }
//
//    external interface PlaceSearchRequest {
//        bounds: LatLngBounds
//        keyword: String
//        location: LatLng
//        name: String
//        radius: Double
//        rankBy: RankBy
//        types: Array<String>
//    }
//
//    external interface PlaceSearchPagination {
//        nextPage()
//        hasNextPage: Boolean
//    }
//
//    external class PlacesService {
//        constructor (attrContainer: HTMLDivElement)
//        constructor (attrContainer: Map)
//        getDetails(request: PlaceDetailsRequest, callback: (result: PlaceResult, status: PlacesServiceStatus) -> void )
//        nearbySearch(request: PlaceSearchRequest, callback: (results: Array<PlaceResult>, status: PlacesServiceStatus, pagination: PlaceSearchPagination) -> void )
//        textSearch(request: TextSearchRequest, callback: (results: Array<PlaceResult>, status: PlacesServiceStatus) -> void )
//    }
//
//    external enum class PlacesServiceStatus {
//        INVALID_REQUEST,
//        OK,
//        OVER_QUERY_LIMIT,
//        REQUEST_DENIED,
//        UNKNOWN_ERROR,
//        ZERO_RESULTS
//    }
//
//    external enum class RankBy {
//        DISTANCE,
//        PROMINENCE
//    }
//
//    external interface TextSearchRequest {
//        bounds: LatLngBounds
//        location: LatLng
//        query: String
//        radius: Double
//    }
//}

//external module drawing {
//    external class DrawingManager : MVCObject {
//        constructor (options: DrawingManagerOptions)
//        getDrawingMode(): OverlayType
//        getMap(): Map
//        setDrawingMode(drawingMode: OverlayType)
//        setMap(map: Map)
//        setOptions(options: DrawingManagerOptions)
//    }
//
//    external interface DrawingManagerOptions {
//        circleOptions: CircleOptions
//        drawingControl: Boolean
//        drawingControlOptions: DrawingControlOptions
//        drawingMode: OverlayType
//        map: Map
//        markerOptions: MarkerOptions
//        polygonOptions: PolygonOptions
//        polylineOptions: PolylineOptions
//        rectangleOptions: RectangleOptions
//    }
//
//    external interface DrawingControlOptions {
//        drawingModes: Array<OverlayType>
//        position: ControlPosition
//    }
//
//    external interface OverlayCompleteEvent {
//        overlay: MVCObject
//        type: OverlayType
//    }
//
//    external enum class OverlayType {
//        CIRCLE,
//        MARKER,
//        POLYGON,
//        POLYLINE,
//        RECTANGLE
//    }
//}

//external module weather {
//    external class CloudLayer : MVCObject {
//        constructor ()
//        getMap(): Map
//        setMap(map: Map)
//    }
//
//    external class WeatherLayer : MVCObject {
//        constructor (opts: WeatherLayerOptions)
//        getMap(): Map
//        setMap(map: Map)
//        setOptions(options: WeatherLayerOptions)
//    }
//
//    external interface WeatherLayerOptions {
//        clickable: Boolean
//        labelColor: LabelColor
//        map: Map
//        suppressInfoWindows: Boolean
//        temperatureUnits: TemperatureUnit
//        windSpeedUnits: WindSpeedUnit
//    }
//
//    external enum class TemperatureUnit {
//        CELSIUS,
//        FAHRENHEIT
//    }
//
//    external enum class WindSpeedUnit {
//        KILOMETERS_PER_HOUR,
//        METERS_PER_SECOND,
//        MILES_PER_HOUR
//    }
//
//    external enum class LabelColor {
//        BLACK,
//        WHITE
//    }
//
//    external interface WeatherMouseEvent {
//        featureDetails: WeatherFeature
//        infoWindowHtml: String
//        latLng: LatLng
//        pixelOffset: Size
//    }
//
//    external interface WeatherFeature {
//        current: WeatherConditions
//        forecast: Array<WeatherForecast>
//        location: String
//        temperatureUnit: TemperatureUnit
//        windSpeedUnit: WindSpeedUnit
//    }
//
//    external interface WeatherConditions {
//        day: String
//        description: String
//        high: Double
//        humidity: Double
//        low: Double
//        shortDay: String
//        temperature: Double
//        windDirection: String
//        windSpeed: Double
//    }
//
//    external interface WeatherForecast {
//        day: String
//        description: String
//        high: Double
//        low: Double
//        shortDay: String
//    }
//}
//external module visualization {
//    external class HeatmapLayer : MVCObject {
//        constructor (opts: HeatmapLayerOptions)
//        getData(): MVCArray
//        getMap(): Map
//        setData(data : MVCArray)
//        setData(data : Array<LatLng>)
//        setData(data : Array<WeightedLocation>)
//        setMap(map: Map)
//    }
//
//    external interface HeatmapLayerOptions {
//        var `data`: Array<LatLng>
//        var dissipating: Boolean
//        var gradient: Array<String>
//        var map: Map
//        var maxIntensity: Double
//        var opacity: Double
//        var radius: Double
//    }
//
//    external interface WeightedLocation {
//        var location: LatLng
//        var weight: Double
//    }
//}
