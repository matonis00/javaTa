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

@Path("/Akademiki/Student")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class StudentREST {

	@EJB
	StudentEJB bean;
	
	@GET
	@Path("/{id}")
	public Response get(@PathParam("id") int id)
	{
		if(bean.get(id)==null)
			return Response.status(404).build();
		else
		{
			StudentDTO dto = bean.get(id).toDTO();
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
			List<Student> list = bean.getAll();
			List<StudentDTO> dtoList = new ArrayList<StudentDTO>();
			for(Student student : list)
			{
				dtoList.add(student.toDTO());
			}
			
			
			return Response.ok(dtoList).build();
		}
			
	}
	
	@POST
	public Response create(StudentDTO student)
	{
		bean.create(student.fromDTO());
		return Response.ok().build();
	}
	
	@PUT
	public Response update(StudentDTO student)
	{
		bean.update(student.fromDTO());
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
	
	// Endpointy do obs³ugi listy op³at
	
	@GET
	@Path("/{id}/Oceny")
	public Response getOceny(@PathParam("id") int id) 
	{
	    Student student = bean.get(id);
	    List<Ocena> list = student.getOplaty();

	    if(student==null)
	    	return Response.status(404).build();
	 
	    if(list.size()==0)
	    	return Response.status(204).build();
	    else
	    {
	    	List<OcenaPrzedmiotDTO> dtoList = new ArrayList<OcenaPrzedmiotDTO>();
			for(Ocena ocena : list)
			{
				Przedmiot przedmiot = ocena.getPrzedmiot();
				OcenaPrzedmiotDTO para = new OcenaPrzedmiotDTO();
				para.setOcenaDTO(ocena.toDTO());
				para.setPrzedmiotDTO(przedmiot.toDTO());
				//para.setData(ocena.toDTO(), student.toDTO());
				dtoList.add(para);
			}
			return Response.ok(dtoList).build();
	    }
	    	
	}

	@POST
	@Path("/{id}/Oplata")
	public Response addOplata(@PathParam("id") int id, OcenaDTO oplata) 
	{
	    if(bean.addObject(id,oplata.fromDTO()))
	    	return Response.ok().build();
	    else
	    	return Response.status(404).build();
	}

	@PUT
	@Path("/{id}/Oplata/{oplataId}")
	public Response updateOplataToStudent(@PathParam("id") int id, @PathParam("oplataId") int oplataId)
	{
		if(bean.addObject(id, oplataId))
			return Response.ok().build();
		else
			return Response.status(404).build();
	}

	@DELETE
	@Path("/{id}/Oplata/{oplataId}")
	public Response deleteOplataFromStudent(@PathParam("id") int id, @PathParam("oplataId") int oplataId)
	{
		if(bean.removeObject(id,oplataId))
			return Response.ok().build();
		else
			return Response.status(404).build();
	}
}
