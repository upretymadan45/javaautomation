package api.utilities;

import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.xml.XmlTest;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;

	public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		repName = "Test-Report-" + timeStamp + ".html";

		sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);// specify location of the report
																																																			// report
		

		
		sparkReporter.config().setDocumentTitle("Automation Project"); // Title of report
		sparkReporter.config().setReportName("Automation Report"); // name of the report
        //htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();

		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Pet store for user API");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "Saroj Poudel");

	}

	public void onTestSuccess(ITestResult result) 
	{
		test = extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) 
	{
		test = extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
	}

	public void onTestSkipped(ITestResult result) 
	{
		test = extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
	}

	public void onFinish(ITestContext testContext) {
		extent.flush();
	}

	public Object getAttribute(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setAttribute(String name, Object value) {
		// TODO Auto-generated method stub
		
	}

	public Set<String> getAttributeNames() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object removeAttribute(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Date getStartDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public Date getEndDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public IResultMap getPassedTests() {
		// TODO Auto-generated method stub
		return null;
	}

	public IResultMap getSkippedTests() {
		// TODO Auto-generated method stub
		return null;
	}

	public IResultMap getFailedButWithinSuccessPercentageTests() {
		// TODO Auto-generated method stub
		return null;
	}

	public IResultMap getFailedTests() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getIncludedGroups() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getExcludedGroups() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getOutputDirectory() {
		// TODO Auto-generated method stub
		return null;
	}

	public ISuite getSuite() {
		// TODO Auto-generated method stub
		return null;
	}

	public ITestNGMethod[] getAllTestMethods() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getHost() {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<ITestNGMethod> getExcludedMethods() {
		// TODO Auto-generated method stub
		return null;
	}

	public IResultMap getPassedConfigurations() {
		// TODO Auto-generated method stub
		return null;
	}

	public IResultMap getSkippedConfigurations() {
		// TODO Auto-generated method stub
		return null;
	}

	public IResultMap getFailedConfigurations() {
		// TODO Auto-generated method stub
		return null;
	}

	public XmlTest getCurrentXmlTest() {
		// TODO Auto-generated method stub
		return null;
	}

}
