package webservices;

import metiers.ModuleBusiness;
import entities.Module;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/module")
public class ModuleWS {

    ModuleBusiness helper = new ModuleBusiness();

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response
                .status(200)
                .entity(helper.getAllModules())
                .build();
    }

    @Path("/add")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addModule(Module module) {
        if (helper.addModule(module)) {
            return Response.status(201).entity("object added").build();
        } else return Response.status(400).entity("object not added").build();

    }
}