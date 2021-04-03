package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.APIFlows;

import java.util.ArrayList;
import java.util.List;

public class StudentAPI extends CommonOps {

    @Test(description = "test 01 - Add student and verify ID")
    @Description("This test adds a new student and verify its ID")
    public void test01_addStudentAndVerify(){
        APIFlows.postStudent("Lioz", "Elinger", "my@email.com", "QA Automation");
        Verifications.verifyText(APIFlows.getProperty("id"), "101");
    }

    @Test(description = "test 02 - Get firstName of a student")
    @Description("This test verifies the firstName property of the new student")
    public void test02_verifyFirstName(){
        Verifications.verifyText(APIFlows.getProperty("firstName"), "Lioz");
    }

    @Test(description = "test 03 - Update student details")
    @Description("This test update the student details and verify it")
    public void test03_updateStudentDetails(){
        String id = APIFlows.getProperty("id");
        List<String> coursesList = new ArrayList<String>();

        APIFlows.putStudent("Lioz", "Elinger", "email@email.com", "Senior QA automation",coursesList, id);
        Verifications.verifyText(APIFlows.getProperty("courses"), "[Java course, CSharp course, Python Course]");
    }

    @Test(description = "test 04 - Delete student ")
    @Description("This test deletes the student  and verify it")
    public void test04_deleteStudent(){
        String id = APIFlows.getProperty("id");
        APIFlows.deleteStudent(id);
        Verifications.verifyNumber(response.getStatusCode(), 204);

    }



}
