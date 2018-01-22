package dk.jyskebank.tools.enunciate.modules.openapi.simple;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.webcohesion.enunciate.metadata.rs.ResourceGroup;
import com.webcohesion.enunciate.metadata.rs.TypeHint;


@ResourceGroup("Resource group text")
@Path("/path/{pathArg}")
public class DataResource {
	/**
	 * An initial summary.
	 * 
	 * Followed by a longer description.

     * <p>And some HTML</p>
	 * <pre>
	 * {
	 *  "weird" : "stuff"
	 * }
	 * </pre>
	 * 
	 * @param pathArg Argument on path.
	 */
	@TypeHint(DataDTO.class)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("pathArg") String pathArg) {
		return Response.ok(new DataDTO()).build();
	}


	/**
	 * Summary.
	 * 
	 * Description follows...
	 * 
     * @param pathArg Argument on path.
	 */
	@PUT
    @TypeHint(DataDTO.class)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("pathArg") String pathArg, DataDTO customerDTO) {
		return Response.ok(new DataDTO()).build();
	}

	/**
	 * Summary delete.
	 * 
	 * Description delete.
	 *
     * @param pathArg Argument on path.
	 * 
	 */
	@DELETE
	public Response delete(@PathParam("pathArg") String pathArg) {
		return Response.ok().build();
	}
}
