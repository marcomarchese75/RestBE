package it.padova.sanita.restbe.services;

import it.padova.sanita.restbe.dao.PatientDAO;
import it.padova.sanita.restbe.dto.Patient;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/rest")
@Stateless
public class PatientService {
    
	private Gson gson = new Gson();
	private PatientDAO patientDAO = new PatientDAO();
	
    /** Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
	@Path("/patient")
	@GET 
    @Produces("text/plain")
    public String getIt() {
        return "Hello page!";
    }

	@GET
	@Path("patient/{id}")
	@Produces("application/json")
	public Response getPatient(@PathParam("id") Long id)
	{
		try
		{
			//Get specific values
			Patient _patient = patientDAO.findById(id);

			if(_patient != null) {
				return Response.status(200).entity(gson.toJson(_patient)).build(); 
			} else {
				return Response.status(404).entity("NOT FOUND").build();
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
			return Response.status(500).entity("ERROR").build();
		}

	}
	
}
