package pl.take.akademiki;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class ProwadzacyEJB extends DefaultEJB<Prowadzacy>{

	@Override
	public Prowadzacy get(int id)
	{		
		return manager.find(Prowadzacy.class, id);
	}
	
	@Override
	public List<Prowadzacy> getAll()
	{
		Query q=manager.createQuery("select p from Prowadzacy p ");
		@SuppressWarnings("unchecked")
		List<Prowadzacy> list=q.getResultList();
		return list;
	}
	
	
	public boolean addObject(int id, Funkcje object) {
		Prowadzacy prowadzacy=get(id);
		if(prowadzacy==null)
			return false;
		if(prowadzacy.addFunkcja(object))
		{
			
			manager.persist(object);
			manager.merge(prowadzacy);
			
			object.setProwadzacy(prowadzacy);
			
			manager.persist(prowadzacy);
			manager.merge(object);
			return true;
		}
		else
			return false;
	}
	
	public boolean addObject(int id, int objectId) {
		Funkcje funkcja=manager.find(Funkcje.class, objectId);
		if(funkcja==null)
			return false;
		if(addObject(id, funkcja))
			return true;
		else
			return false;
	}

	public boolean removeObject(int id, int objectId) {
		Prowadzacy prowadzacy=get(id);
		if(prowadzacy==null)
			return false;
		Funkcje funkcja=manager.find(Funkcje.class, objectId);
		if(funkcja==null)
			return false;
		if(prowadzacy.removeFunkcja(funkcja))
		{
			manager.merge(prowadzacy);
			return true;
		}
		else
			return false;
	}
	
}
