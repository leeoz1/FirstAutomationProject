package extensions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utilities.CommonOps;

public class APIActions extends CommonOps {

    @Step("Post data to the server")
    public static void post(JSONObject params, String resource) {
        httpRequest.header("Content-type", "application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.post(resource);
        response.prettyPrint();
    }

    @Step("Get data from the server")
    public static Response get(String paramValues) {
        response = httpRequest.get(paramValues);
        response.prettyPrint();
        return response;
    }

    @Step("Extract value from json format")
    public static String extractFromJson(Response response, String path) {
        jp = response.jsonPath();
        return jp.get(path).toString();
    }

    @Step("Update data to the server")
    public static void put(JSONObject params, String resource) {
        httpRequest.header("Content-type", "application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.put(resource);
        response.prettyPrint();
    }

    @Step("Delete data from the server")
    public static void delete(String id) {
        response = httpRequest.delete("student/" + id);
        response.prettyPrint();
    }
}
