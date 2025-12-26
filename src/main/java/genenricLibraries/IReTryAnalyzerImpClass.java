package genenricLibraries;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IReTryAnalyzerImpClass implements IRetryAnalyzer {

	int iniCount=0;
	int upperCount=3;
	
	public boolean retry(ITestResult result) {
		if(iniCount<upperCount) {
			iniCount++;
			return true;
		}
		return false;
	}
}
