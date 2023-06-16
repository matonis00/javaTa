package pl.take.akademiki;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

import javafx.util.Pair;

@Path("/Akademiki/Przedmiot")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class PrzedmiotREST {

	@EJB
	PrzedmiotEJB bean;
	
	@GET
	@Path("/{id}")
	public Response get(@PathParam("id") int id)
	{
		if(bean.get(id)==null)
			return Response.status(404).build();
		else
		{
			PrzedmiotDTO dto = bean.get(id).toDTO();
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
			List<Przedmiot> list = bean.getAll();
			List<PrzedmiotDTO> dtoList = new ArrayList<PrzedmiotDTO>();
			for(Przedmiot przedmiot : list)
			{
				dtoList.add(przedmiot.toDTO());
			}
			
			
			return Response.ok(dtoList).build();
		}
			
	}
	
	@POST
	public Response create(PrzedmiotDTO przedmiot)
	{
		bean.create(przedmiot.fromDTO());
		return Response.ok().build();
	}
	
	@PUT
	public Response update(PrzedmiotDTO przedmiot)
	{
		bean.update(przedmiot.fromDTO());
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
	@Path("/{id}/Oceny")
	public Response getOceny(@PathParam("id") int id) 
	{
	
	    Przedmiot przedmiot = bean.get(id);
	    Set<Ocena> list = przedmiot.getOceny();

	    if(przedmiot==null)
	    	return Response.status(404).build();
	 
	    if(list.size()==0)
	    	return Response.status(204).build();
	    else
	    {
	    	
	    	List<OcenaStudentDTO> dtoList = new ArrayList<OcenaStudentDTO>();
			for(Ocena ocena : list)
			{
				Student student = ocena.getStudent();
				OcenaStudentDTO para = new OcenaStudentDTO();
				para.setOcenaDTO(ocena.toDTO());
				para.setStudentDTO(student.toDTO());
				//para.setData(ocena.toDTO(), student.toDTO());
				dtoList.add(para);
			}
			return Response.ok(dtoList).build();
	    }
	    	
	     
	}
	
	@POST
	@Path("/{id}/Ocena")
	public Response addOcena(@PathParam("id") int id, OcenaDTO ocena) 
	{
	    if(bean.addObject(id,ocena.fromDTO()))
	    	return Response.ok().build();
	    else
	    	return Response.status(404).build();
	}
	
	@PUT
	@Path("/{id}/Ocena/{ocenaId}")
	public Response updateOcenaToPrzedmiot(@PathParam("id") int id, @PathParam("ocenaId") int ocenaId)
	{
		if(bean.addObject(id, ocenaId))
			return Response.ok().build();
		else
			return Response.status(404).build();
	}
	
	@DELETE
	@Path("/{id}/Ocena/{ocenaId}")
	public Response deleteOcenaFromStudent(@PathParam("id") int id, @PathParam("ocenaId") int ocenaId)
	{
		if(bean.removeObject(id,ocenaId))
			return Response.ok().build();
		else
			return Response.status(404).build();
	}
	
	@GET
	@Path("/{id}/Funkcje")
	public Response getFunkcje(@PathParam("id") int id) 
	{
	
	    Przedmiot przedmiot = bean.get(id);
	    Set<Funkcje> list = przedmiot.getFunkcje();

	    if(przedmiot==null)
	    	return Response.status(404).build();
	 
	    if(list.size()==0)
	    	return Response.status(204).build();
	    else
	    {
	    	
	    	List<FunkcjeProwadzacyDTO> dtoList = new ArrayList<FunkcjeProwadzacyDTO>();
			for(Funkcje funkcja : list)
			{
				Prowadzacy prowadzacy = funkcja.getProwadzacy();
				FunkcjeProwadzacyDTO para = new FunkcjeProwadzacyDTO();
				para.setFunkcje(funkcja.toDTO());
				para.setProwadzacy(prowadzacy.toDTO());
				//para.setData(ocena.toDTO(), student.toDTO());
				dtoList.add(para);
			}
			return Response.ok(dtoList).build();
	    }
	    	
	     
	}
	
	@POST
	@Path("/{id}/Funkcja")
	public Response addFunkcja(@PathParam("id") int id, FunkcjeDTO funkcje) 
	{
	    if(bean.addFunkcja(id,funkcje.fromDTO()))
	    	return Response.ok().build();
	    else
	    	return Response.status(404).build();
	}
	
	@PUT
	@Path("/{id}/Funkcja/{funkcjaId}")
	public Response updateFunkcjaToPrzedmiot(@PathParam("id") int id, @PathParam("funkcjaId") int funkcjaId)
	{
		if(bean.addFunkcja(id, funkcjaId))
			return Response.ok().build();
		else
			return Response.status(404).build();
	}
	
	@DELETE
	@Path("/{id}/Funkcja/{funkcjaId}")
	public Response deleteFunkcjaFromStudent(@PathParam("id") int id, @PathParam("funkcjaId") int funkcjaId)
	{
		if(bean.removeFunkcja(id,funkcjaId))
			return Response.ok().build();
		else
			return Response.status(404).build();
	}
}


