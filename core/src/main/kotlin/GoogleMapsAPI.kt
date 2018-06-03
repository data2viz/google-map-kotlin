import google.maps.LatLng
import google.maps.MapOptions

fun mapOptions(zoom: Int, center: LatLng, 
               init: MapOptions.() -> Unit = {}): MapOptions {
    val ret = Any().unsafeCast<MapOptions>()
    ret.zoom = zoom
    ret.center = center
    ret.init()
    return ret
}