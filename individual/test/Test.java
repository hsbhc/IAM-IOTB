package individual.test;


import individual.context.Context;


public class Test {

	public static void main(String[] args) {
		Context context=Context.getContext();
		
		context.addTranDataMap(TestCome.class,TestBack.class);
		context.addTranDataMap(Come1.class,Back1.class);
		context.addActor(TestActor.class);
		context.showWorks();
		
		
		TestCome comeData=new TestCome();
		comeData.setType("test");
		comeData.setAction("test");
		
		TestBack backData=context.back(comeData);
		System.out.println(backData.getData());
		
		Come1 come1=new Come1();
		come1.setType("test");
		come1.setAction("test");
		Back1 back1=context.back(come1);
		
		
		
	}
	
	
}
