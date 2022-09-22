package unitTest;

import org.testng.annotations.Test;
import unitTestClasses.Example;

public class ExampleTest {

    @Test
    public void t1(){
        Example ex = new Example();
        int r = ex.exampleTest(0,5,1,0,0,0,0);
        System.out.println(r);
    }

    @Test
    public void t2(){
        Example ex = new Example();
        int r = ex.exampleTest(0,5,8,0,0,0,0);
        System.out.println(r);
    }

}
