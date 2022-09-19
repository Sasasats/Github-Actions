package api.models.user;

import java.util.Objects;

public class UserGeo {
    public String lat;
    public String lng;

    public UserGeo(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public UserGeo() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserGeo geo = (UserGeo) o;
        return Objects.equals(lat, geo.lat) && Objects.equals(lng, geo.lng);
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}
