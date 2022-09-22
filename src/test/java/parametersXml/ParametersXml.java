package parametersXml;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersXml {


    @Test (groups = {"parametersXml","all"})
    @Parameters({"Parameter1", "Parameter2"})
    public void parametersTest(@Optional ("default") String param1, String param2){
        System.out.println(param1 + " " + param2);
    }
}
