package nfjs

import grails.test.mixin.*
import org.junit.*

@TestFor(GeocoderService)
class GeocoderServiceTests {

    void testMountainViewCA() {
        Castle google = new Castle(city:'Mountain View', state:'CA')
        service.fillInLatLng(google)
        assertEquals(  37.4, google.latitude, 0.1)
        assertEquals(-122.1, google.longitude, 0.1)
    }
}
