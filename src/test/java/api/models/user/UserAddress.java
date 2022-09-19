package api.models.user;

import java.util.Objects;

public class UserAddress {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private UserGeo geo;

    public UserAddress(String street, String suite, String city, String zipcode, UserGeo geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAddress that = (UserAddress) o;
        return Objects.equals(street, that.street) && Objects.equals(suite, that.suite)
                && Objects.equals(city, that.city) && Objects.equals(zipcode, that.zipcode)
                && Objects.equals(geo, that.geo);
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public UserGeo getGeo() {
        return geo;
    }

    public void setGeo(UserGeo geo) {
        this.geo = geo;
    }

    public UserAddress() {
    }
}
