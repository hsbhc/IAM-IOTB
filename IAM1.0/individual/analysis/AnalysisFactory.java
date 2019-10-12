package individual.analysis;

import individual.context.Work;

public class AnalysisFactory {
	public static Analysis getAnalysis(Work worktype) {
		if(Work.Come.equals(worktype)) {
			return new ComeAnalysis();
		}else if(Work.Actor.equals(worktype)){
			return new ActorAnalysis();
		}
		else if(Work.Back.equals(worktype)){
			return new BackAnalysis();
		}else {
			return null;
		}
	}

}
