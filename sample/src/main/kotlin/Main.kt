import google.maps.LatLng
import google.maps.Map
import io.data2viz.google.maps.Visibility
import io.data2viz.google.maps.styles
import kotlin.browser.document

fun main(args: Array<String>) {
    println("starting Google Map wrapped from kotlin")
    val map = Map(
        document.getElementById("map")!!, 
        mapOptions(6, LatLng(46.2, 6.15)) {
            styles = styles {
                style {
                    visibility = Visibility.off
                }
                style( administrative.country, geometry.stroke) {
                    visibility = Visibility.on
                    color = "#3e3366"
                }
                style( water, geometry) {
                    visibility = Visibility.on
                    color = "#b3b3b3"
                }
            }
        }
    )
    map.setZoom(3)
}