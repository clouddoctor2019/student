package com.testngrunner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.testCase.CustomeListener;
import com.testngclasses.TestPublicMethod;
import com.testngclasses.TestStaticMethod;

public class TestNgRunner {

	/*public static void main(String[] args) {
		
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] {TestPublicMethod.class,TestStaticMethod.class});
		testng.addListener(new CustomeListener());
		testng.run();
	}
	*/
	public static void main(String[] args) {
		
		XmlSuite xmlSuite = new XmlSuite();
		xmlSuite.setName("CodeMapper");
		xmlSuite.setParallel("false");
		xmlSuite.setVerbose(1);
		xmlSuite.addListener("com.testCase.CustomeIsuiteListener");
		
		XmlTest xmlTest = new XmlTest(xmlSuite);
		xmlTest.setName("Test - 1");
		xmlTest.setPreserveOrder("true");
		
		XmlTest xmlTest2 = new XmlTest(xmlSuite);
		xmlTest.setName("Test - 2");
		xmlTest.setPreserveOrder("true");
		
		
		XmlClass publicTestClass = new XmlClass(TestPublicMethod.class);
		XmlClass staticTestClass = new XmlClass(TestStaticMethod.class);
		
		List<XmlClass> list = new ArrayList<XmlClass>();
		list.add(publicTestClass);
		
		List<XmlClass> list2 = new ArrayList<XmlClass>();
		list.add(staticTestClass);
		
		xmlTest.setXmlClasses(list);
		xmlTest2.setXmlClasses(list2);
		
		TestNG testng = new TestNG();
		
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(xmlSuite);
		
		testng.setXmlSuites(suites);
		testng.run();
		
		
		
	}

}
