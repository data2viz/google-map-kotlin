package io.data2viz.google.maps



fun styles(init: StylesBuilder.() -> Unit) =
    StylesBuilder()
        .apply(init)
        .styles()


/**
 * StylesBuilder simplifies the styling of map by providing code completion during writing. 
 */
class StylesBuilder internal constructor() {

    val _styles = mutableListOf<Style>()

    val all             = FeatureType("all")
    val administrative  = FeatureType.FeatureTypeAdministrative("administrative")
    val poi             = FeatureType.FeatureTypePoi("poi")
    val transit         = FeatureType.FeatureTypeTransit("transit")
    val water           = FeatureType("water")
    val road            = FeatureType.FeatureTypeRoad("road")
    val landscape       = FeatureType.FeatureTypeLandscape("landscape")
    val allGeometries   = ElementType("all")
    val geometry        = ElementType.ElementTypeGeometry("geometry")
    val labels          = ElementType.ElementTypeLabels("labels")

    class Style(val featureType: FeatureType?, val elementType: ElementType?) {
        var color: String? = null
        var hue: String? = null
        var lightness: Double? = null
            set(value) {
                require(value == null || -100.0 <= value && value <= 100.0)
                { "lightness must be between 0.01 and 10.0" }
            }
        var saturation: Double? = null
            set(value) {
                require(value == null || -100.0 <= value && value <= 100.0)
                { "saturation must be between 0.01 and 10.0" }
            }

        var gamma: Double? = null
            set(value) {
                require(value == null || -0.01 <= value && value <= 10.0)
                { "gamma must be between 0.01 and 10.0" }
            }

        var invert_lightness: Boolean? = null
        var visibility: Visibility? = null
        var weight: Int? = null
    }

    fun style(
        featureType: FeatureType? = null,
        elementType: ElementType? = null,
        init: Style.() -> Unit
    ) {
        _styles += Style(featureType, elementType).apply(init)
    }


    fun styles() =
        _styles.map { st ->
            val o = jsObject()
            if (st.featureType != null) {
                o.featureType = st.featureType.name
            }
            if (st.elementType != null) {
                o.elementType = st.elementType.name
            }
            val stylers = listOfNotNull(
                st.color?.let { property { this.color = it } },
                st.hue?.let { property { this.hue = it } },
                st.lightness?.let { property { this.lightness = it } },
                st.saturation?.let { property { this.saturation = it } },
                st.gamma?.let { property { this.gamma = it } },
                st.invert_lightness?.let { property { this.invert_lightness = it } },
                st.visibility?.let { property { this.visibility = it.name } },
                st.weight?.let { property { this.weight = it } }
            ).toTypedArray()

            o.stylers = stylers
            return@map o
        }.toTypedArray()

}

open class ElementType internal constructor(val name: String) {

    class ElementTypeGeometry(name: String) : ElementType(name) {
        val fill = ElementType("geometry.fill")
        val stroke = ElementType("geometry.stroke")
    }

    class ElementTypeLabels(name: String) : ElementType(name) {
        val icon = ElementType("labels.icon")
        val text = ElementType("labels.text")
        val text_fill = ElementType("labels.text.fill")
        val text_stoke = ElementType("labels.text.stroke")
    }

}

open class FeatureType internal constructor(val name: String) {

    class FeatureTypeAdministrative(name: String) : FeatureType(name) {
        val country = FeatureType("administrative.country")
        val land_parcel = FeatureType("administrative.land_parcel")
        val locality = FeatureType("administrative.locality")
        val neighborhood = FeatureType("administrative.neighborhood")
        val province = FeatureType("administrative.province")
    }

    class FeatureTypeLandscape(name: String) : FeatureType(name)

    class FeatureTypeRoad(name: String) : FeatureType(name) {
        val arterial = FeatureType("road.arterial")
        val highway = FeatureType("road.highway")
        val highway_controlled_access = FeatureType("road.highway.controlled_access")
        val local = FeatureType("road.local")
    }

    class FeatureTypePoi(name: String) : FeatureType(name) {
        val attraction = FeatureType("poi.attraction")
        val business = FeatureType("poi.business")
        val government = FeatureType("poi.government")
        val medical = FeatureType("poi.medical")
        val park = FeatureType("poi.park")
        val place_of_worship = FeatureType("poi.place_of_worship")
        val school = FeatureType("poi.school")
        val sports_complex = FeatureType("poi.sports_complex")
    }

    class FeatureTypeTransit(name: String) : FeatureType(name) {
        val line = FeatureType("transit.line")
        val station = FeatureType("transit.station")
        val station_airport = FeatureType("transit.airport")
        val station_bus = FeatureType("transit.bus")
        val station_rail = FeatureType("transit.rail")
    }

}

enum class Visibility { on, off, simplified }

internal fun jsObject() = js("({})")

fun property(init: dynamic.() -> Unit): dynamic {
    val o = jsObject()
    init(o)
    return o
}

