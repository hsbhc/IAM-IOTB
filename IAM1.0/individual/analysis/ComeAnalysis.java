package individual.analysis;


import java.lang.reflect.Field;

import individual.anno.Come;


public class ComeAnalysis implements Analysis{
	public String analytical(Class cls) {
		boolean f=true;
		Come come=(Come) cls.getAnnotation(Come.class);
		if(come==null) {
			System.out.println(cls.getSimpleName()+" should has @Come");
			f=false;
		}
		try {
			Field type=cls.getDeclaredField("type");
			if(type.getType()!=String.class){
				System.out.println(cls.getSimpleName()+" should has private String type");
				f=false;
			}
		}catch (Exception e) {
			System.out.println(cls.getSimpleName()+" should has private String type");
			f=false;
		} 
		try {
			Field action=cls.getDeclaredField("action");
			if(action.getType()!=String.class){
				System.out.println(cls.getSimpleName()+" should has private String action");
				f=false;
			}
		} catch (Exception e) {
			System.out.println(cls.getSimpleName()+" should has private String action");
			f=false;
		} 
		if(f)
			return cls.getSimpleName();
		return null;
	}
}
