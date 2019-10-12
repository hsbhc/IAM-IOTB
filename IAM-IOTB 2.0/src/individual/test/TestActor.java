package individual.test;

import individual.anno.Action;
import individual.anno.Actor;
import individual.anno.Come;

@Actor(name = "user")
public class TestActor {
	
	@Come
	TestCome come;
	TestBack testBack;
	String s;
	@Action(name = "test")
	TestBack getBack() {
		testBack.setData("Hello World!");
		return testBack;
	}
	
	@Action(name = "test1")
	String get() {
		return "哈哈哈";
	}
	
	
}
