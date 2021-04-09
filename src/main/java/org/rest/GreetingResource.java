package org.rest;

import org.rest.services.FruitService;
import org.rest.services.model.FruitDto;

import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/fruit")
public class GreetingResource {

    @Inject
    FruitService fruitService;

    public class Error {
        public String code;
        public String description;

        public Error(String code, String description) {
            this.code = code;
            this.description = description;
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFruits(){
        List<FruitDto> fruitDtos = fruitService.getFruits();
        return Response.ok(fruitDtos).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createFruit(FruitDto fruit, @Context UriInfo uriInfo){
        FruitDto fruitDto = fruitService.addFruit(fruit);
        if(fruitDto != null){
            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            uriBuilder.path(Integer.toString(fruitDto.getId()));
            return Response.created(uriBuilder.build()).entity(fruitDto).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity(new Error("VD-0001", "Invalid request in validation. >>")).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response removeFruit(@PathParam("id") Integer id){
        String message = fruitService.removeFruit(id);
        return Response.ok(message).build();
    }


}