package courseraita;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	
	TestMockArmazenamento.class,
	TestPlacar.class
})

public class JunitTestSuite {

}
