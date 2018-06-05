package io.data2viz.google.maps

import google.maps.LatLng
import google.maps.*
import google.maps.Marker
import google.maps.MarkerOptions
import org.w3c.dom.Element


fun map(element: Element, zoom: Int, center: LatLng, init: MapOptions.() -> Unit = {}): Map {
    val options = createObject<MapOptions>() .apply {
        this.zoom = zoom
        this.center = center
        init()
    }
    return Map(element, options)
} 
        
fun marker(init: MarkerOptions.() -> Unit): Marker = Marker(createObject<MarkerOptions>().apply(init))

private inline fun <reified T> createObject():T = Any().unsafeCast<T>() 
