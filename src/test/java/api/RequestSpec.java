package api;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {
    public static RequestSpecification requestSpec() {
        ISettingsFile config = new JsonSettingsFile("config.json");
        return new RequestSpecBuilder()
                .setBaseUri(config.getValue("/baseUri").toString())
                .setContentType(ContentType.JSON)
                .build();
    }
}
