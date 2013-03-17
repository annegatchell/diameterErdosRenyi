package src.test;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	src.test.BagTest.class,
	src.test.GraphTest.class,
})
public class AllMyTests {
  //nothing
}