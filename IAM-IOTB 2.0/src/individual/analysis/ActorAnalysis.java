package individual.analysis;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import individual.anno.Action;
import individual.anno.Actor;
import individual.anno.Come;
import individual.bean.ActorMap;


public class ActorAnalysis{

	private static ActorAnalysis analysis=new ActorAnalysis();
	public static ActorAnalysis getAnalysis() {
		return analysis;
	}
	private ActorAnalysis() {}
	public  ActorMap analytical(Class cls) {
		ActorMap actorMap=new ActorMap();
		Actor actor=(Actor)cls.getAnnotation(Actor.class);
		if(actor!=null) {
			actorMap.setActorName(actor.name());
			actorMap.setActorClass(cls);
		}else {
			System.out.println(cls.getSimpleName()+" should has @Actor");
			return null;
		}
		
		Method[] methods=cls.getDeclaredMethods();
		for(Method method:methods) {
			Action actionMethod=method.getDeclaredAnnotation(Action.class);
			if(actionMethod!=null) {
				actorMap.addActionMap(actionMethod.name(),method);
			}
		}
		if(actorMap.getActionMap().isEmpty()) {
			System.out.println(cls.getSimpleName()+" should have at least one @Acton Field");
			return null;
		}
		Field[] fields=cls.getDeclaredFields();
		for(Field field:fields) {
			if(field.getDeclaredAnnotation(Come.class)!=null) {
				actorMap.addComeMap(field.getType().getSimpleName(), field);
			}else {
				actorMap.addPropertyMap(field.getType().getSimpleName(), field);
			}
		}
		if(actorMap.getComeMap().isEmpty()) {
			System.out.println(cls.getSimpleName()+" should have at least one @Come Field");
			return null;
		}
		return actorMap;
		
	}

}
