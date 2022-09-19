package utils;

import api.models.user.User;
import api.models.user.UserAddress;
import api.models.user.UserCompany;
import api.models.user.UserGeo;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class JsonParser {
    public static User setUser(String userJson) {
        final ISettingsFile expectedUser = new JsonSettingsFile(userJson);

        UserGeo geo = new UserGeo(
                expectedUser.getValue("/address/geo/lat").toString(),
                expectedUser.getValue("/address/geo/lng").toString()
        );

        UserAddress address = new UserAddress(
                expectedUser.getValue("/address/street").toString(),
                expectedUser.getValue("/address/suite").toString(),
                expectedUser.getValue("/address/city").toString(),
                expectedUser.getValue("/address/zipcode").toString(),
                geo
        );

        UserCompany company = new UserCompany(
                expectedUser.getValue("/company/name").toString(),
                expectedUser.getValue("/company/catchPhrase").toString(),
                expectedUser.getValue("/company/bs").toString()
        );

        return new User(
                (Integer) expectedUser.getValue("/id"),
                expectedUser.getValue("/name").toString(),
                expectedUser.getValue("/username").toString(),
                expectedUser.getValue("/email").toString(),
                address,
                expectedUser.getValue("/phone").toString(),
                expectedUser.getValue("/website").toString(),
                company
        );
    }
}
