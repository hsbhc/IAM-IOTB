package individual.context;



import java.util.ArrayList;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import data.UserBack;
import individual.analysis.AnalysisFactory;




public class  Context implements DoMapping{
	private static Context context=new Context();
	private Context() {}
	public static Context getContext() {
		return context;
	}
	
	private DoBackHandle doBackHandle=new DoBack();
	
	@SuppressWarnings("rawtypes")
	private Map<String, Class> works=new LinkedHashMap<String, Class>();
	
	private Map<String, String> dataMap=new LinkedHashMap<String, String>();
	
	private List<String> actors=new ArrayList<String>();
	
	public Class getwork(String name) {
		if(works.containsKey(name))
			return works.get(name);
		return null;
	}
	public String getbackname(String comename) {
		if(dataMap.containsKey(comename))
			return dataMap.get(comename);
		return null;
	}
	
	public Context addTranDataMap(Class come,Class back) {
		String comeName=commit(come, Work.Come);
		String backName=commit(back, Work.Back);
		if(comeName==null||backName==null) {
			System.out.println(comeName+" ---> "+backName+" add is fail");
		}else {
			dataMap.put(comeName,backName);
		}
		return this;
	}
	public Context addActor(Class actor) {
		String actorName=commit(actor, Work.Actor);
		if(actorName!=null)
			actors.add(actorName);
		return this;
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T> T back(Object object){
		Object obj=doBackHandle.back(object, works);
		if(obj==null)
			return null;
		return (T)obj;
	}
	

	@Override
	public Context showWorks() {
		System.out.println();
		System.out.println("------transDataMap------");
		for (Map.Entry<String, String> entry : dataMap.entrySet()) {
			System.out.println(entry.getKey()+" ---> "+entry.getValue());
		}
		System.out.println();
		System.out.println("------actorClassMap------");
		for(String string:actors) {
			System.out.println(string+" <---> "+works.get(string).getName());
		}
		System.out.println();
		return context;
	}
	private String commit(Class cls,Work worktype) {
		String result=AnalysisFactory.getAnalysis(worktype).analytical(cls);
		if(result==null) {
			System.out.println(cls.getSimpleName()+" add is fail");
			return null;
		}
		if(works.containsKey(result)) {
			System.out.println(cls.getSimpleName()+"  is repeated");
			return null;
		}
		if(result!=null) {
			works.put(result, cls);
			return result;
		}
		return null;
	}
	
	
	
	



	

}
