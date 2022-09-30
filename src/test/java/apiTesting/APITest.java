package apiTesting;

import apiTestingAuxClasses.RequestMaker;
import com.github.javafaker.Faker;
import dataProvidersMain.DataProviders;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import utils.GlobalVariables;

public class APITest {

    @Test(groups = {"all","get"})
    public void getTest(){
        String getAllUsers = GlobalVariables.apiHost  + "/users/all";
        Response response = RequestMaker.makeGetRequest(getAllUsers);
        String responseString = response.asString();
        System.out.println(responseString);
        JSONArray jsonArray =  new JSONArray(responseString);
        System.out.println(jsonArray.toString(10));
        if(jsonArray.length() == 0){
            Assert.fail("Fail test - Get Users is empty.");
        }
    }

    @Test(groups = {"all","post"},
            dataProviderClass = DataProviders.class,
            dataProvider = "apiTestDP")
    public void postMethod(String bodyString){
        String getAllUsers = GlobalVariables.apiHost  + "/users/add";
        Response response = RequestMaker.makePostRequest(getAllUsers, bodyString);
        System.out.println(response.asString());
        Assert.fail();
    }

    @AfterClass
    public void after(){
        System.out.println("After");
    }
}
