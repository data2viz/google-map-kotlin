@file:JsQualifier("google.maps.weather")

package google.maps.weather

import google.maps.LatLng
import google.maps.MVCObject
import google.maps.Size


external class CloudLayer : MVCObject {
    constructor ()

    fun getMap(): google.maps.Map
    fun setMap(map: google.maps.Map)
}

external class WeatherLayer : MVCObject {
    constructor (opts: WeatherLayerOptions)

    fun getMap(): google.maps.Map
    fun setMap(map: google.maps.Map)
    fun setOptions(options: WeatherLayerOptions)
}

external interface WeatherLayerOptions {
    var clickable: Boolean
    var labelColor: LabelColor
    var map: google.maps.Map
    var suppressInfoWindows: Boolean
    var temperatureUnits: TemperatureUnit
    var windSpeedUnits: WindSpeedUnit
}

external enum class TemperatureUnit {
    CELSIUS,
    FAHRENHEIT
}

external enum class WindSpeedUnit {
    KILOMETERS_PER_HOUR,
    METERS_PER_SECOND,
    MILES_PER_HOUR
}

external enum class LabelColor {
    BLACK,
    WHITE
}

external interface WeatherMouseEvent {
    var featureDetails: WeatherFeature
    var infoWindowHtml: String
    var latLng: LatLng
    var pixelOffset: Size
}

external interface WeatherFeature {
    var current: WeatherConditions
    var forecast: Array<WeatherForecast>
    var location: String
    var temperatureUnit: TemperatureUnit
    var windSpeedUnit: WindSpeedUnit
}

external interface WeatherConditions {
    var day: String
    var description: String
    var high: Double
    var humidity: Double
    var low: Double
    var shortDay: String
    var temperature: Double
    var windDirection: String
    var windSpeed: Double
}

external interface WeatherForecast {
    var day: String
    var description: String
    var high: Double
    var low: Double
    var shortDay: String
}
