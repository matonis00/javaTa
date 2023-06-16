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

@Path("/Akademiki/Ocena")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class OcenaREST {

	@EJB
	OcenaEJB bean;
	
	@GET
	@Path("/{id}")
	public Response get(@PathParam("id") int id)
	{
		if(bean.get(id)==null)
			return Response.status(404).build();
		else
		{
			OcenaDTO dto = bean.get(id).toDTO();
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
			List<Ocena> list = bean.getAll();
			List<OcenaDTO> dtoList = new ArrayList<OcenaDTO>();
			for(Ocena ocena : list)
			{
				dtoList.add(ocena.toDTO());
			}
			
			
			return Response.ok(dtoList).build();
		}
			
	}
	
	
	@GET
	@Path("/{id}/Student")
	public Response getStudent(@PathParam("id") int id)
	{
		
		Ocena ocena = bean.get(id);
		
		if(bean.get(id)==null)
			return Response.status(404).build();
		else
		{
			Student student = ocena.getStudent();
			StudentDTO dto = student.toDTO();
			return Response.ok(dto).build();
		}
			
	} 

	@GET
	@Path("/{id}/Przedmiot")
	public Response getPrzedmiot(@PathParam("id") int id)
	{
		
		Ocena ocena = bean.get(id);
		
		if(bean.get(id)==null)
			return Response.status(404).build();
		else
		{
			Przedmiot przedmiot = ocena.getPrzedmiot();
			PrzedmiotDTO dto = przedmiot.toDTO();
			return Response.ok(dto).build();
		}
			
	} 
	@POST
	public Response create(OcenaDTO oplata)
	{
		bean.create(oplata.fromDTO());
		return Response.ok().build();
	}
	
	@PUT
	public Response update(OcenaDTO oplata)
	{
		bean.update(oplata.fromDTO());
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
