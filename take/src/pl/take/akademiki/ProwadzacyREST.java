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

@Path("/Akademiki/Prowadzacy")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class ProwadzacyREST {

	@EJB
	ProwadzacyEJB bean;
	
	@GET
	@Path("/{id}")
	public Response get(@PathParam("id") int id)
	{
		if(bean.get(id)==null)
			return Response.status(404).build();
		else
		{
			ProwadzacyDTO dto = bean.get(id).toDTO();
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
			List<Prowadzacy> list = bean.getAll();
			List<ProwadzacyDTO> dtoList = new ArrayList<ProwadzacyDTO>();
			for(Prowadzacy prowadzacy : list)
			{
				dtoList.add(prowadzacy.toDTO());
			}
			
			
			return Response.ok(dtoList).build();
		}
			
	}
	
	@POST
	public Response create(ProwadzacyDTO prowadzacy)
	{
		bean.create(prowadzacy.fromDTO());
		return Response.ok().build();
	}
	
	@PUT
	public Response update(ProwadzacyDTO prowadzacy)
	{
		bean.update(prowadzacy.fromDTO());
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
	
	@GET
	@Path("/{id}/Funkcje")
	public Response getFunckje(@PathParam("id") int id) 
	{
	    Prowadzacy prowadzacy = bean.get(id);
	    List<Funkcje> list = prowadzacy.getFunkcje();

	    if(prowadzacy==null)
	    	return Response.status(404).build();
	 
	    if(list.size()==0)
	    	return Response.status(204).build();
	    else
	    {
	    	List<FunkcjePrzedmiotDTO> dtoList = new ArrayList<FunkcjePrzedmiotDTO>();
			for(Funkcje funkcja : list)
			{
				Przedmiot przedmiot = funkcja.getPrzedmiot();
				FunkcjePrzedmiotDTO para = new FunkcjePrzedmiotDTO();
				para.setFunkcje(funkcja.toDTO());
				para.setPrzedmiot(przedmiot.toDTO());
				//para.setData(ocena.toDTO(), student.toDTO());
				dtoList.add(para);
			}
			return Response.ok(dtoList).build();
	    }
	    	
	    
	}
	
	@POST
	@Path("/{id}/Funkcja")
	public Response addFunkcja(@PathParam("id") int id, FunkcjeDTO funkcja) 
	{
	    if(bean.addObject(id,funkcja.fromDTO()))
	    	return Response.ok().build();
	    else
	    	return Response.status(404).build();
	}
	
	@PUT
	@Path("/{id}/Funkcja/{funkcjaId}")
	public Response updateOplataToStudent(@PathParam("id") int id, @PathParam("funkcjaId") int funkcjaId)
	{
		if(bean.addObject(id, funkcjaId))
			return Response.ok().build();
		else
			return Response.status(404).build();
	}

	@DELETE
	@Path("/{id}/Funkcja/{funkcjaId}")
	public Response deleteOplataFromStudent(@PathParam("id") int id, @PathParam("funkcjaId") int funkcjaId)
	{
		if(bean.removeObject(id,funkcjaId))
			return Response.ok().build();
		else
			return Response.status(404).build();
	}
}
