import google.maps.LatLng
import google.maps.Map
import google.maps.MapTypeId
import io.data2viz.google.maps.Visibility
import io.data2viz.google.maps.map
import io.data2viz.google.maps.styles
import kotlin.browser.document

fun main(args: Array<String>) {
    map(
        element = document.getElementById("map")!!, 
        zoom = 7, 
        center = LatLng(46.2, 6.15)) {
        
        minZoom = 3
        
        styles = styles { 
            style { 
                visibility = Visibility.off 
            }
            style(administrative.country) {
                visibility = Visibility.on
            }
            style(administrative.country, geometry.stroke) {
                color = "#0000aa"
            }
            style(water) {
                visibility = Visibility.on
            }
        }
        
    } 
}