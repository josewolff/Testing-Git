package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import utils.GlobalVariables;

public class UFMListener implements ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        System.out.println("Suite started");
        GlobalVariables.apiHost = suite.getParameter("apiHost");
        GlobalVariables.seleniumHost = suite.getParameter("seleniumHost");
        System.out.println("------> API Tests: " + GlobalVariables.apiHost + " <------");
        System.out.println("------> System Tests: " + GlobalVariables.seleniumHost + " <------");
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("Suite finished");
    }
}
