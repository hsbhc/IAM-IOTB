package individual.test;

import individual.anno.Action;
import individual.anno.Actor;

@Actor(name = "test")
public class TestActor {
	private TestCome come;
	public TestActor(TestCome come) {
		this.come=come;
	}
	
	
	@Action(name = "test")
	private TestBack getBack() {
		TestBack testBack=new TestBack();
		testBack.setData("Hello World!");
		System.out.println(testBack.getData());
		return testBack;
	}
	
	
}
