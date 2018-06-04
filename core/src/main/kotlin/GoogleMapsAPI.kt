import google.maps.LatLng
import google.maps.MapOptions
import google.maps.Marker
import google.maps.MarkerOptions
import google.maps.visualization.HeatmapLayer
import google.maps.visualization.HeatmapLayerOptions

fun mapOptions(zoom: Int, center: LatLng, 
               init: MapOptions.() -> Unit = {}): MapOptions {
    return createObject<MapOptions>() .apply {
        this.zoom = zoom
        this.center = center
        init()
    }
}

private inline fun <reified T> createObject():T {
    val ret = Any()
    return ret.unsafeCast<T>()  
} 

fun newMarker(init: MarkerOptions.() -> Unit): Marker = Marker(createObject<MarkerOptions>().apply(init))
fun heatmapLayer(init: HeatmapLayerOptions.() -> Unit): HeatmapLayer = HeatmapLayer(createObject<HeatmapLayerOptions>().apply(init))