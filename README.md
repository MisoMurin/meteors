# Meteors
This project contains a single application which loads the meteorites landings data since 2011 (inclusive)
and displays them as a list. A user can then choose a meteorite to see the landings location on a map.
The landings data is synchronized once a day. The data come from a NASA API.

## Libraries
The project utilizes most of the Android Architecture Components (LiveData, DataBinding, Room, etc.)
and other third party libraries (Retrofit, Mapbox, Coroutines, etc.) to achieve the functionality.

## Make it run
The minimum to run the app is API 21 (Android 5.0 Lollipop).
The project is not compilable as it is. There are 2 string values to be defined:
- *xAppToken* - to fetch the data from NASA
- *mapboxToken* - to display the Mapbox map
