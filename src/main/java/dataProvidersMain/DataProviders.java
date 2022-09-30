package dataProvidersMain;

import apiTestingAuxClasses.RequestMaker;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider(name = "staticDP")
    public static Object[][] staticDP(){
        Object[][] obj = new Object[10][2];
        for(int x = 0; x < 10; x++){
            obj[x][0] = x;
            obj[x][1] = x *2;
        }
        return obj;
    }

    @DataProvider(name ="dynamicDP")
    public Iterator<Object[]> dynamicDP(){
        List<Object[]> data =  new ArrayList<Object[]>();
        for(int x = 0; x < 250; x++){
            data.add(new Object[]{x, x*2});
        }
        return data.iterator();
    }


    @DataProvider(name ="apiTestDP", parallel = true)
    public Iterator<Object[]> apiTestDP(){
        List<Object[]> data =  new ArrayList<Object[]>();
        Faker faker = new Faker();
        for (int i = 0; i < 400; i++){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("firstname", faker.name().firstName())
                    .put("lastname", faker.name().lastName())
                    .put("username",faker.name().username())
                    .put("email",faker.internet().emailAddress());
            data.add(new Object[]{jsonObject.toString()});
        }
        return data.iterator();
    }


}
