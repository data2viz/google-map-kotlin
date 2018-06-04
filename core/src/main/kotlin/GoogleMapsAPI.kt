import google.maps.LatLng
import google.maps.MapOptions

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