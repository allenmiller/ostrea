package net.ajmiller.Ostrea;

public class Location {

    private String lat = null;
    private String lon = null;
    private String name = null;
    private double elevation = 0.0;

    public Location(String lat, String lon, String name) {
        this.lat = lat;
        this.lon = lon;
        this.name = name;
        this.elevation = 0.0;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public String getName() {
        return name;
    }

    public double getElevation() {
        return elevation;
    }

    public double getDistance(Location other) {
        /*
         * Calculate distance between two points in latitude and longitude
         * taking into account height difference. If you are not interested in
         * height difference pass 0.0. Uses Haversine method as its base.
         *
         * lat1, lon1 Start point lat2, lon2 End point el1 Start altitude in
         * meters el2 End altitude in meters
         * 
         * @returns Distance in Meters
         */
        // public static double distance(double lat1, double lat2, double lon1,
        // double lon2, double el1, double el2) {


        final int R = 6371; // Radius of the earth

        Double lat1 = new Double(getLat());
        Double lon1 = new Double(getLon());
        Double el1 = new Double(getElevation());

        Double lat2 = new Double(other.getLat());
        Double lon2 = new Double(other.getLon());
        Double el2 = new Double(other.getElevation());

        Double latDistance = Math.toRadians(lat2 - lat1);
        Double lonDistance = Math.toRadians(lon2 - lon1);
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        double height = el1 - el2;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);

    }

}
