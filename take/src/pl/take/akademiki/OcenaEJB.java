package pl.take.akademiki;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class OcenaEJB extends DefaultEJB<Ocena> {
	
	public Ocena get(int id)
	{
		return manager.find(Ocena.class,id);
	}
	
	public List<Ocena> getAll()
	{
		Query q=manager.createQuery("select o from Ocena o");
		@SuppressWarnings("unchecked")
		List<Ocena> list=q.getResultList();
		return list;
	}
}
