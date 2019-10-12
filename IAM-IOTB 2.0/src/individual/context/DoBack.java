package individual.context;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import individual.analysis.ComeAnalysis;
import individual.anno.Action;
import individual.anno.Come;
import individual.bean.ActorMap;

public class DoBack implements DoBackHandle{
	

	@Override
	public <T> Object back(T t, Map<String, ActorMap> actors) {
		
		CTA cta=(CTA)ComeAnalysis.getAnalysis().analytical(t);
		if(cta==null) {
			return null;
		}
		String actorName=cta.getActorName();
		String actionName=cta.getActionName();
		
		
		
		ActorMap actorMap;
		Object realactor;
		
		
		actorMap=actors.get(actorName);
		
		
		if(actorMap==null) {
			System.out.println(cta.getActorName()+" is not found");
			return null;
		}
		
		if(!actorMap.getComeMap().keySet().contains(t.getClass().getSimpleName())){
			System.out.println(actorName+" do not have the "+t.getClass().getSimpleName()+" Field");
			return null;
		}
		
		if(!actorMap.getActionMap().keySet().contains(actionName)) {
			System.out.println(actorName+"'s "+actionName+" is not found");
			return null;
		}
		try {
			realactor=actorMap.getActorClass().newInstance();
			Method action=actorMap.getActionMap().get(actionName);
			
			Field come=actorMap.getComeMap().get(t.getClass().getSimpleName());
			come.setAccessible(true);
			come.set(realactor, t);
			
			Field returnField=actorMap.getPropertyMap().get(action.getReturnType().getSimpleName());
			if(returnField!=null) {
				returnField.setAccessible(true);
				returnField.set(realactor,returnField.getType().newInstance());
			}
			
			action.setAccessible(true);
			return action.invoke(realactor);
			
		} catch (Exception e) {
			return null;
		}
		
	}
}
