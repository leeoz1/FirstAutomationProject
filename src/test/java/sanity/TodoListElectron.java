package sanity;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlows;
import workflows.WebFlows;

import java.util.concurrent.TimeUnit;

public class TodoListElectron extends CommonOps
{
    @Test(description = "test 01 -Adds and verify number of Tasks")
    @Description("This test adds new task and verifies the number of added tasks")
    public void test01_addAndVerifyNewTask(){
        ElectronFlows.addNewTask("Learn Java");
        Verifications.verifyNumber(ElectronFlows.getNumberOfTasks(),1);
    }

    @Test(description = "test 02 -Adds and verify number of Tasks")
    @Description("This test adds number of items")
    public void test02_addAndVerifyNewTasks(){
        ElectronFlows.addNewTask("Learn Python");
        ElectronFlows.addNewTask("Learn JavaScript");
        Verifications.verifyNumber(ElectronFlows.getNumberOfTasks(),2);

    }

    @Test(description = "test 03 -Adds red colored and filter orange colored")
    @Description("This test adds red colored task and filter by orange colored tasks")
    public void test03_addAndFilterNewTasks(){
        ElectronFlows.selectRed();
        ElectronFlows.addNewTask("Learn How to make red colored tasks!");
        ElectronFlows.filterOrange();
        Verifications.verifyTextInElement(todoMain.getTxt_empty(),"There's no task");

    }


}
