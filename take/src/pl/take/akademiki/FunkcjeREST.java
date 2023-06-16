package pl.take.akademiki;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/Akademiki/Funkcja")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class FunkcjeREST {

	@EJB
	FunkcjeEJB bean;
	
	@GET
	@Path("/{id}")
	public Response get(@PathParam("id") int id)
	{
		if(bean.get(id)==null)
			return Response.status(404).build();
		else
		{
			FunkcjeDTO dto = bean.get(id).toDTO();
			return Response.ok(dto).build();
		}
			
	} 
	
	@GET
	public Response getAll()
	{
		if(bean.getAll().size()==0)
			return Response.status(204).build();
		else
		{
			List<Funkcje> list = bean.getAll();
			List<FunkcjeDTO> dtoList = new ArrayList<FunkcjeDTO>();
			for(Funkcje funkcje : list)
			{
				dtoList.add(funkcje.toDTO());
			}
			
			
			return Response.ok(dtoList).build();
		}
			
	}
	
	@GET
	@Path("/{id}/Prowadzacy")
	public Response getProwadzacy(@PathParam("id") int id)
	{
		
		Funkcje funkcje = bean.get(id);
		
		if(bean.get(id)==null)
			return Response.status(404).build();
		else
		{
			Prowadzacy prowadzacy = funkcje.getProwadzacy();
			ProwadzacyDTO dto = prowadzacy.toDTO();
			return Response.ok(dto).build();
		}
			
	} 
	
	@GET
	@Path("/{id}/Przedmiot")
	public Response getPrzedmiot(@PathParam("id") int id)
	{
		
		Funkcje funkcja = bean.get(id);
		
		if(bean.get(id)==null)
			return Response.status(404).build();
		else
		{
			Przedmiot przedmiot = funkcja.getPrzedmiot();
			PrzedmiotDTO dto = przedmiot.toDTO();
			return Response.ok(dto).build();
		}
			
	} 
	
	@POST
	public Response create(FunkcjeDTO funkcja)
	{
		bean.create(funkcja.fromDTO());
		return Response.ok().build();
	}
	
	@PUT
	public Response update(FunkcjeDTO funkcja)
	{
		bean.update(funkcja.fromDTO());
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id)
	{
		if(bean.delete(id))
			return Response.ok().build();
		else
			return Response.status(404).build();
	}
}
