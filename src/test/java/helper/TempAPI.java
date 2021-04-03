package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TempAPI {
    RequestSpecification httpRequest;
    Response response;
    String url = "http://localhost:9000/";

    @Test
    public void testingAPI(){
        RestAssured.baseURI = url;
        httpRequest = RestAssured.given();
//GET request
        response = httpRequest.get("student/101");

//        //Post Request
        List<String> coursesList = new ArrayList<String>();
        coursesList.add("Java course");
        coursesList.add("CSharp course");
        coursesList.add("Python Course");
//
//        JSONObject params = new JSONObject();
//        params.put("firstName", "Pizza");
//        params.put("lastName", "Face");
//        params.put("email", "pizza@gmail.com");
//        params.put("programme", "QA PIZZA");
//        params.put("courses", coursesList);
//
//        httpRequest.header("Content-type", "application/json");
//
//        httpRequest.body(params.toJSONString());
//        response = httpRequest.post("student/");
  //      response = httpRequest.put("student/101");
//response = httpRequest.delete("student/101/");
        response.prettyPrint();


    }


}
