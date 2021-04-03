package extensions;

import io.qameta.allure.Step;
import utilities.CommonOps;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBActions extends CommonOps {

    @Step("Get credentials from DB")
    public static List<String> getCredentials(String query) {
        List<String> credentials = new ArrayList<String>();
        try {
            resultSet = state.executeQuery(query);
            resultSet.next();
            credentials.add(resultSet.getString(1));
            credentials.add(resultSet.getString(2));
        } catch (Exception e) {
            System.out.println("Error occurred while printing table's data, see details: " + e);
        }
        return credentials;
    }

}

