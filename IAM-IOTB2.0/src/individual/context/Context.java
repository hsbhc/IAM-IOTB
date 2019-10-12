package individual.context;



import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import individual.analysis.ActorAnalysis;
import individual.bean.ActorMap;

public class  Context implements DoMapping{
	private static Context context=new Context();
	private Context() {}
	public static Context getContext() {
		return context;
	}
	
	private ActorAnalysis analysis=ActorAnalysis.getAnalysis();
	private DoBackHandle doBackHandle=new DoBack();
	
	private Map<String, ActorMap> actors=new HashMap<String, ActorMap>();
	
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T back(Object object){
		Object obj=doBackHandle.back(object, actors);
		if(obj==null)
			return null;
		return (T)obj;
	}
	public Class getComeClass(String name) {
		for(Map.Entry<String, ActorMap> entry:actors.entrySet()) {
			for(HashMap.Entry<String, Field> enMap:entry.getValue().getComeMap().entrySet()) {
				if(enMap.getKey().equals(name)){
					return enMap.getValue().getType();
				}
			}
		}
		return null;
	}
	
	public Context addActor(Class cls) {
		ActorMap actorMap=analysis.analytical(cls);
		
		if(actorMap==null) {
			System.out.println(cls.getSimpleName()+" add is fail");
			return null;
		}
		
		String actorName=actorMap.getActorName();
		if(actors.containsKey(actorName)) {
			System.out.println(actorName+"  is repeated");
			return null;
		}else {
			actors.put(actorName,actorMap);
		}
		return this;
	}
	@Override
	public Context showWorks() {
		System.out.println("------actorClassMap------");
		for (Map.Entry<String, ActorMap> entry : actors.entrySet()) {
			System.out.println();
			System.out.println("--------"+entry.getKey()+"--------");
			System.out.println(entry.getValue());
			System.out.println();
		}
		return context;
	}
	
	

}
