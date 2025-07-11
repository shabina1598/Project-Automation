package retry;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.IAnnotation;
import org.testng.annotations.ITestAnnotation;

public class RetryListener implements IAnnotationTransformer{
	
	@Override  
	  public void transform(ITestAnnotation annotation,Class testclass,Constructor testConstructor,Method testMethod) {
		 annotation.setRetryAnalyzer(RetryAnalyzer.class);
		}

}
