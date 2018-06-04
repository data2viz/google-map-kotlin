@file:JsQualifier("google.maps.adsense")

package google.maps.adsense

import google.maps.ControlPosition
import google.maps.MVCObject
import org.w3c.dom.Element


external class AdUnit : MVCObject {
    constructor (container: Element, opts: AdUnitOptions)

    fun getChannelNumber(): String
    fun getContainer(): Element
    fun getFormat(): AdFormat
    fun getMap(): google.maps.Map
    fun getPosition(): ControlPosition
    fun getPublisherId(): String
    fun setChannelNumber(channelNumber: String)
    fun setFormat(format: AdFormat)
    fun setMap(map: google.maps.Map)
    fun setPosition(position: ControlPosition)
}

external interface AdUnitOptions {
    var channelNumber: String
    var format: AdFormat
    var map: google.maps.Map
    var position: ControlPosition
    var publisherId: String
}

external enum class AdFormat {
    BANNER,
    BUTTON,
    HALF_BANNER,
    LARGE_RECTANGLE,
    LEADERBOARD,
    MEDIUM_RECTANGLE,
    SKYSCRAPER,
    SMALL_RECTANGLE,
    SMALL_SQUARE,
    SQUARE,
    VERTICAL_BANNER,
    WIDE_SKYSCRAPER
}
