package individual.test;


import individual.context.Context;


public class Test {

	public static void main(String[] args) {
		Context context=Context.getContext();
		
		context.addActor(TestActor.class);
		
		context.showWorks();
		
		
		
		TestCome comeData=new TestCome();
		
		comeData.setRequest("user.test");
		TestBack backData=context.back(comeData);
		System.out.println(backData.getData());
		
		comeData.setRequest("user.test1");
		String string=context.back(comeData);
		System.out.println(string);
		
		
	}
	
	
}
