# Purpose

This small project give access to Google Maps JS API from kotlin.

It contains the external definition to interact with Google Maps API and adds some small extensions 
to simplify its use from kotlin.

## How to use it?

Due to its specific loading mechanism, Google Maps must be loaded before calling the API from kotlin. 
Asynch loading can't be used. 

Example using AMD loading (require.js)

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <style>
        #map {
            width: 100%;
            height: 100%;
        }
        html, body {
            height: 100%;
            margin: 0;
            padding: 0;
        }
    </style>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/require.js/2.3.5/require.min.js"></script>
</head>
<body>
<div id="map"></div>
<script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY"></script>
<script>
    require.config({
        baseUrl: "build/kotlin-js-min/main"
    });
    require(['sample'])
</script>
</body>
</html>
``` 

Then you can use the API to create a map and interact with it:

```kotlin
fun main(args: Array<String>) {
    map(document.getElementById("map")!!, 6, LatLng(46.2, 6.15)) 
}
```

You can also write this code in a more explicit way using named parameter:
```kotlin
fun main(args: Array<String>) {
    map(
        element = document.getElementById("map")!!, 
        zoom = 6, 
        center = LatLng(46.2, 6.15)) {
        }
} 
```

To configure your map, you can pass a lambda which is an extension function of a MapOptions. You
can then access all the MapOptions properties:

```kotlin
fun main(args: Array<String>) {
    map(
        element = document.getElementById("map")!!, 
        zoom = 7, 
        center = LatLng(46.2, 6.15)) {
        
        minZoom = 3
        mapTypeId = MapTypeId.SATELLITE
    } 
}
```

## Styling
To support the Google Map styling, we add a small DSL to simplify the configuration of
the styling:

```kotlin
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
```


## Libraries
Google Maps proposes some additionnal libraries. 


```html
<script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&libraries=geometry">
</script> 
```
