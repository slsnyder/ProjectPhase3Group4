package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ StudentCollectionTest.class, StudentTest.class, UserCollectionTest.class,
	UserTest.class, CollegeTransferTest.class, CompanyTest.class, EmploymentTest.class})
public class AllTests {

}
