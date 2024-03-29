package Test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ InvalidInsertionTest.class, InvalidRemove.class, Search.class, ValidInsertionTest.class,
		ValidRemove.class })
public class AllTests {

}
