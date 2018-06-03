import google.maps.LatLng
import kotlin.browser.document

fun main(args: Array<String>) {
    println("starting Google Map wrapped from kotlin")
    val mOptions = mapOptions(6, LatLng(46.2, 6.15))
    val mapDiv = document.getElementById("map")!!
    google.maps.Map(mapDiv, mOptions)
}