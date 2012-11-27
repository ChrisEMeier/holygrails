package nfjs

class GeocoderService {
    public static final String BASE = 'http://maps.googleapis.com/maps/api/geocode/xml?'

    void fillInLatLng(Castle c) {
        String encoded = [c.city, c.state].collect {
            URLEncoder.encode(it, 'UTF-8')
        }.join(',+')
        String qs = [address:encoded, sensor:false].collect { it }.join('&')
        def root = new XmlSlurper().parse(BASE + qs)
        c.latitude = root.result[0].geometry.location.lat.toDouble()
        c.longitude = root.result[0].geometry.location.lng.toDouble()
    }
    
    def headers() {
        [['number','Lat'], ['number','Lng'], ['string','Name']]
    }
    
    def data() {
        Castle.list().collect { c ->
            [c.latitude, c.longitude, c.toString()]
        }
    }
}
