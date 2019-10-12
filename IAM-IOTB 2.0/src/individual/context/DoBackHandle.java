package individual.context;


import java.util.Map;

import individual.bean.ActorMap;

public interface DoBackHandle {

	<T> Object back(T t, Map<String, ActorMap> actors);

}
