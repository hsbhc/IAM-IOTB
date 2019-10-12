package individual.bean;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

public class ActorMap {
	
	private String actorName;
	private Class actorClass;
	
	
	private HashMap<String, Field> comeMap=new HashMap<String, Field>();
	
	private HashMap<String,Field> propertyMap=new HashMap<String, Field>();
	
	private HashMap<String, Method> actionMap=new HashMap<String, Method>();

	
	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public Class getActorClass() {
		return actorClass;
	}

	public void setActorClass(Class actorClass) {
		this.actorClass = actorClass;
	}

	public HashMap<String, Field> getPropertyMap() {
		return propertyMap;
	}

	public void addPropertyMap(String propertyClassName, Field propertyField) {
		if (this.propertyMap.containsKey(propertyClassName)) {
			System.out.println(propertyClassName+" is repeated in one Actor , so only add the first one");
			return;
		}
		this.propertyMap.put(propertyClassName, propertyField);
	}

	public HashMap<String, Method> getActionMap() {
		return actionMap;
	}

	public void addActionMap(String actionName, Method actionMethod) {
		
		if(actionMap.containsKey(actionName)) {
			System.out.println(actionName+" is repeated in one Actor , so only add the first one");
			return;
		}
		this.actionMap.put(actionName, actionMethod);
	}

	public HashMap<String, Field> getComeMap() {
		return comeMap;
	}

	public void addComeMap(String comeClassName, Field comeField) {
		if(comeMap.containsKey(comeClassName)) {
			System.out.println(comeClassName+" is repeated in one Actor , so only add the first one");
			return;
		}
		this.comeMap.put(comeClassName, comeField);
	}

	@Override
	public String toString() {
		return " [actorName=" + actorName + ", actorClass=" + actorClass + "] \n comeMap=" + comeMap
				+ "\n propertyMap=" + propertyMap + "\n actionMap=" + actionMap + "]";
	}
	
	
}
