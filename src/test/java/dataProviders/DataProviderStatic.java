package dataProviders;
import dataProvidersMain.DataProviders;
import org.testng.annotations.Test;

public class DataProviderStatic {


    @Test(groups = {"staticDP","all"},
            dataProvider = "staticDP",
            dataProviderClass = DataProviders.class)
    public void dpStaticTest(int number1, int number2){
        System.out.println(number1 + "  " + number2);
    }
}
