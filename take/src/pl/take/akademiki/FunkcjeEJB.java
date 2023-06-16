package pl.take.akademiki;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class FunkcjeEJB extends DefaultEJB<Funkcje> {
	
	public Funkcje get(int id)
	{
		return manager.find(Funkcje.class,id);
	}
	
	public List<Funkcje> getAll()
	{
		Query q=manager.createQuery("select f from Funkcje f");
		@SuppressWarnings("unchecked")
		List<Funkcje> list=q.getResultList();
		return list;
	}
}
