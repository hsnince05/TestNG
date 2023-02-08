package techproed.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
public class ListenersRetry implements IRetryAnalyzer {

    //    BU SINIF SADECE FAIL OLAN TEST CASELERE TEKRAR CALISTIRIR
    private int retryCount = 0;

    // maxRetryCount EK OLARAK CALISMA SAYISI. BU ORNEKTE FAIL OLAN TESTLER EXTRA BIR DEFA DAHA CALISIR
    private static final int maxRetryCount = 2;
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}