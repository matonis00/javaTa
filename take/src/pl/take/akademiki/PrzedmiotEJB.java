package pl.take.akademiki;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class PrzedmiotEJB extends DefaultEJB<Przedmiot>{
	@Override
	public Przedmiot get(int id)
	{		
		return manager.find(Przedmiot.class, id);
	}
	
	@Override
	public List<Przedmiot> getAll()
	{
		Query q=manager.createQuery("select p from Przedmiot p ");
		@SuppressWarnings("unchecked")
		List<Przedmiot> list=q.getResultList();
		return list;
	}
	

	public boolean addObject(int id, Ocena object) {
		Przedmiot przedmiot=get(id);
		if(przedmiot==null)
			return false;
		if(przedmiot.addOceny(object))
		{
			
			manager.persist(object);
			manager.merge(przedmiot);
			
			object.setPrzedmiot(przedmiot);
			
			manager.persist(przedmiot);
			manager.merge(object);
			return true;
		}
		else
			return false;
	}

	public boolean addObject(int id, int objectId) {
		Ocena oplata=manager.find(Ocena.class, objectId);
		if(oplata==null)
			return false;
		if(addObject(id, oplata))
			return true;
		else
			return false;
	}

	public boolean removeObject(int id, int objectId) {
		Przedmiot przedmiot=get(id);
		if(przedmiot==null)
			return false;
		Ocena ocena=manager.find(Ocena.class, objectId);
		if(ocena==null)
			return false;
		if(przedmiot.removeOcena(ocena))
		{
			manager.merge(przedmiot);
			return true;
		}
		else
			return false;
	}
	
	
	public boolean addFunkcja(int id, Funkcje object) {
		Przedmiot przedmiot=get(id);
		if(przedmiot==null)
			return false;
		if(przedmiot.addFunkcje(object))
		{
			
			manager.persist(object);
			manager.merge(przedmiot);
			
			object.setPrzedmiot(przedmiot);
			
			manager.persist(przedmiot);
			manager.merge(object);
			return true;
		}
		else
			return false;
	}

	public boolean addFunkcja(int id, int objectId) {
		Funkcje funkcja =manager.find(Funkcje.class, objectId);
		if(funkcja==null)
			return false;
		if(addFunkcja(id, funkcja))
			return true;
		else
			return false;
	}

	public boolean removeFunkcja(int id, int objectId) {
		Przedmiot przedmiot=get(id);
		if(przedmiot==null)
			return false;
		Funkcje funkcja=manager.find(Funkcje.class, objectId);
		if(funkcja==null)
			return false;
		if(przedmiot.removeFunkcje(funkcja))
		{
			manager.merge(przedmiot);
			return true;
		}
		else
			return false;
	}
	
}
