package workflows;

import extensions.APIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

import java.util.List;

public class APIFlows extends CommonOps {


    @Step("Business flow: Create new student")
    public static void postStudent(String firstName, String lastName, String email, String programme) {
        params.put("firstName", firstName);
        params.put("lastName", lastName);
        params.put("email", email);
        params.put("programme", programme);
        APIActions.post(params, "student/");
    }

    @Step("Business flow: get firstNameProperty")
    public static String getProperty(String jPath) {
        response = APIActions.get("student/101");
        return APIActions.extractFromJson(response, jPath);
    }

    @Step("Business flow: update  student details")
    public static void putStudent(String firstName, String lastName, String email, String programme, List<String> coursesList, String id) {
//        List<String> coursesList = new ArrayList<String>();

        coursesList.add("Java course");
        coursesList.add("CSharp course");
        coursesList.add("Python Course");

        params.put("firstName", firstName);
        params.put("lastName", lastName);
        params.put("email", email);
        params.put("programme", programme);
        params.put("courses", coursesList);
        APIActions.put(params, "student/" + id);
    }

    @Step("Business flow: Delete student")
    public static void deleteStudent(String id) {
        APIActions.delete(id);
    }
}

