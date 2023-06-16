package pl.take.akademiki;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class DefaultEJB<T> {

	@PersistenceContext(name="akademiki")
	EntityManager manager;
	
	public abstract T get(int id);
	
	public abstract List<T> getAll();
	
	public void create(T object)
	{
		manager.merge(object);
	}
	
	public void update(T object)
	{
		manager.merge(object);
	}
	
	public boolean delete(int id)
	{
		T object=get(id);
		if(object==null)
			return false;
		manager.remove(object);
		return true;
	}
	
}
