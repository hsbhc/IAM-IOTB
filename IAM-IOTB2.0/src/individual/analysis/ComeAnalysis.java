package individual.analysis;


import java.lang.reflect.Field;
import individual.context.CTA;


public class ComeAnalysis{
	private static ComeAnalysis analysis=new ComeAnalysis();
	public static ComeAnalysis getAnalysis() {
		return analysis;
	}
	private ComeAnalysis() {}
	public <T> CTA analytical(T t) {
		Class cls=t.getClass();
		CTA cta=new CTA();
		try {
			Field request=cls.getDeclaredField("request");
			if(request.getType()!=String.class){
				
				System.out.println(cls.getSimpleName()+" should have private String request");
				return null;
			}
			request.setAccessible(true);
			String requestField=(String)request.get(t);
			
			if(requestField==null) {
				System.out.println(cls.getSimpleName()+"'s request is not found");
				return null;
			}
			String[] strings=requestField.split("\\.");
			if(strings==null||strings.length!=2) {
				System.out.println(cls.getSimpleName()+"should have request Field for example user.login");
				return null;
			}
			cta.setActorName(strings[0]);
			cta.setActionName(strings[1]);
			return cta;
		}catch (Exception e) {
			System.out.println(cls.getSimpleName()+" should has private String request");
			return null;
		} 
		
	}
}
