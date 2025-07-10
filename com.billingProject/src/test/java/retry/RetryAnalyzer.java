package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	
	private int initialRetryCount = 0;
	private static final int maxRetryCount = 3;

	@Override
	public boolean retry(ITestResult result) {
		
		if(initialRetryCount<maxRetryCount) 
		{
			initialRetryCount++;
			return true;
		}
		
		
		return false;
	}
	
	

}
