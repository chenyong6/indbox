package 代码库.Junit学习;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
//@SuiteClasses({ComplexFunctionTest.class, SimpleFunctionTest.class})
@SuiteClasses({LifeCycleTest.class})
public class TestSuitMain {

}
