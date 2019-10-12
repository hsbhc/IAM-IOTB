package individual.analysis;

import individual.anno.Back;

public class BackAnalysis implements Analysis{

	@Override
	public String analytical(Class cls) {
		Back back=(Back) cls.getAnnotation(Back.class);
		if(back==null) {
			System.out.println(cls.getSimpleName()+" should has @Back");
			return null;
		}else {
			return cls.getSimpleName();
		}
		
	}

}
