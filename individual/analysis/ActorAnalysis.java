package individual.analysis;

import individual.anno.Actor;

public class ActorAnalysis implements Analysis{

	@Override
	public String analytical(Class cls) {
		Actor actor=(Actor) cls.getAnnotation(Actor.class);
		if(actor!=null) {
			return actor.name();
		}else {
			System.out.println(cls.getSimpleName()+" should has @Actor");
			return null;
		}
	}

}
