package nl.kristalsoftware.guestbook.guest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

/**
 * Created by sjoerdadema on 03/01/2017.
 */
@Path("guests")
public class GuestsResource {

    @Inject
    private GuestService service;

    @GET
    public List<GuestEntry> all() {
        return service.all();
    }

    @GET
    @Path("{id}")
    public GuestEntry find(@PathParam("id") long id) {
        return service.find(id);
    }

    @POST
    public Response save(GuestEntry entry, @Context UriInfo info) {
        GuestEntry created = service.save(entry);
        long id = created.getId();
        URI uri = info.getAbsolutePathBuilder()
                .path("/" + id)
                .build();
        return Response.created(uri).build();
    }
}
