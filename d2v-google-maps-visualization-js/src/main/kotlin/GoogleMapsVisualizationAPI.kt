package io.data2viz.google.maps

import google.maps.Marker
import google.maps.MarkerOptions
import google.maps.visualization.HeatmapLayer
import google.maps.visualization.HeatmapLayerOptions


fun marker(init: MarkerOptions.() -> Unit): Marker = Marker(createObject<MarkerOptions>().apply(init))
fun heatmapLayer(init: HeatmapLayerOptions.() -> Unit): HeatmapLayer = HeatmapLayer(createObject<HeatmapLayerOptions>().apply(init))


private inline fun <reified T> createObject():T = Any().unsafeCast<T>()
