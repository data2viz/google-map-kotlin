@file:JsQualifier("google.maps.places")

package google.maps.places

import google.maps.*
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLInputElement


external class Autocomplete : MVCObject {
    constructor (inputField: HTMLInputElement, opts: AutocompleteOptions)

    fun getBounds(): LatLngBounds
    fun getPlace(): PlaceResult
    fun setBounds(bounds: LatLngBounds)
    fun setComponentRestrictions(restrictions: ComponentRestrictions)
    fun setTypes(types: Array<String>)
}

external interface AutocompleteOptions {
    var bounds: LatLngBounds
    var componentRestrictions: ComponentRestrictions
    var types: Array<String>
}

external interface ComponentRestrictions {
    var country: String
}

external interface PlaceDetailsRequest {
    var reference: String
}

external interface PlaceGeometry {
    var location: LatLng
    var viewport: LatLngBounds
}

external interface PlaceResult {
    var address_components: Array<GeocoderAddressComponent>
    var formatted_address: String
    var formatted_phone_Double: String
    var geometry: PlaceGeometry
    var html_attributions: Array<String>
    var icon: String
    var id: String
    var international_phone_Double: String
    var name: String
    var rating: Double
    var reference: String
    var types: Array<String>
    var url: String
    var vicinity: String
    var website: String
}

external interface PlaceSearchRequest {
    var bounds: LatLngBounds
    var keyword: String
    var location: LatLng
    var name: String
    var radius: Double
    var rankBy: RankBy
    var types: Array<String>
}

external interface PlaceSearchPagination {
    fun nextPage()
    val hasNextPage: Boolean
}

external class PlacesService {
    constructor (attrContainer: HTMLDivElement)
    constructor (attrContainer: Map)

    fun getDetails(request: PlaceDetailsRequest, callback: (result: PlaceResult, status: PlacesServiceStatus) -> Unit)
    fun nearbySearch(
        request: PlaceSearchRequest,
        callback: (results: Array<PlaceResult>, status: PlacesServiceStatus, pagination: PlaceSearchPagination) -> Unit
    )

    fun textSearch(
        request: TextSearchRequest,
        callback: (results: Array<PlaceResult>, status: PlacesServiceStatus) -> Unit
    )
}

external enum class PlacesServiceStatus {
    INVALID_REQUEST,
    OK,
    OVER_QUERY_LIMIT,
    REQUEST_DENIED,
    UNKNOWN_ERROR,
    ZERO_RESULTS
}

external enum class RankBy {
    DISTANCE,
    PROMINENCE
}

external interface TextSearchRequest {
    var bounds: LatLngBounds
    var location: LatLng
    var query: String
    var radius: Double
}
