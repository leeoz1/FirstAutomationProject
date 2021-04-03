package workflows;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import utilities.CommonOps;

import java.util.concurrent.TimeUnit;

public class ElectronFlows extends CommonOps {

    @Step("Add new task to the list")
    public static void addNewTask(String taskName){
        UIActions.updateText(todoMain.getTxt_addTask(), taskName);
        UIActions.insertKey(todoMain.getTxt_addTask(), Keys.RETURN);
    }

    @Step("Count number of tasks")
    public static int getNumberOfTasks(){
        return todoMain.getList_tasks().size();
    }

    @Step("Empty board")
    public static void emptyList(){
        for (int i = 0; i < getNumberOfTasks();i++)
        UIActions.mouseHover(todoMain.getBtn_remove());
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
    }
    @Step("Select red color from the list")
    public static void selectRed(){
        UIActions.click(todoMain.getBtn_colors());
        UIActions.click(todoMain.getItem_red());
    }

    @Step("Filter orange color from the list")
    public static void filterOrange(){
        UIActions.click(todoMain.getMenu_collapse());
        UIActions.click(todoMain.getItem_orange());
    }



}
