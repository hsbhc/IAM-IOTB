package individual.context;



public interface DoMapping {

		Context showWorks();
		Context addActor(Class actor);
		Context addTranDataMap(Class come,Class back);
		<T> Object back(Object object);
}
