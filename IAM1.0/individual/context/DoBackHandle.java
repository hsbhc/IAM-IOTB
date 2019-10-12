package individual.context;

import java.util.Map;

public interface DoBackHandle {
	<T> Object back(T t,Map<String, Class> works);
}
