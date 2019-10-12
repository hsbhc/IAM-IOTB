package individual.context;

import java.lang.reflect.Method;
import java.util.Map;

import individual.analysis.AnalysisFactory;
import individual.anno.Action;

public class DoBack implements DoBackHandle{
	
	@SuppressWarnings({ "unlikely-arg-type", "unchecked" })
	public <T> Object back(T t,Map<String, Class> works) {
		String comeName=AnalysisFactory.getAnalysis(Work.Come).analytical(t.getClass());
		if(comeName==null||!works.containsKey(comeName)) {
			System.out.println(t.getClass()+" don't has add the context");
			return null;
		}
		
		String type = null;
		String action = null;
		Object actor = null;//具体的actor
		Class backtype;	//返回类型
		Object back;	// 返回对象
		try {
			type=(String)works.get(comeName).getDeclaredMethod("getType").invoke(t);
		} catch (Exception e) {
			
			System.out.println(t.getClass()+" getType is fail");
			e.printStackTrace();
			return null;
		} 
		try {
			action=(String)works.get(comeName).getDeclaredMethod("getAction").invoke(t);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(t.getClass()+" getAction is fail");
			return null;
		} 
		try {
			actor=works.get(type).getConstructor(t.getClass()).newInstance(t);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(type+" getActor is fail");
			return null;
		} 
		Method[] methods=works.get(type).getDeclaredMethods();
		for(Method method:methods) {
			if(method.getAnnotation(Action.class)==null)
				continue;
			if(action.equals(method.getAnnotation(Action.class).name())) {
				method.setAccessible(true);
					try {
						backtype=works.get(method.getReturnType().getSimpleName());
						if(backtype==null) {
							System.out.println(actor.getClass()+" "+method.getName()+" return is null");
							method.invoke(actor);
							return null;
						}
						back=method.invoke(actor);
						return back;
						
					} catch (Exception e) {
						return null;
					}
				}else {
					continue;
			}
		}
		return null;
	}

}
