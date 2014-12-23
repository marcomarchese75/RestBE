
package it.padova.sanita.restbe.services;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/rest")
@Stateless
public class PatientService {
    
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
}
