package controllers;

import entities.Deliveryman;
import filters.customAnnotations.JWTTokenNeeded;
import services.interfaces.IDeliverymanService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@JWTTokenNeeded
@Path("deliverymen")
public class DeliverymanController {
    @Inject
    private IDeliverymanService iDeliverymanServiceService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDeliverymen() {
        List<Deliveryman> deliverymen;
        try {
            deliverymen = iDeliverymanServiceService.getAll();
        } catch (ServerErrorException ex) {
            return Response
                    .status(500).entity(ex.getMessage()).build();
        }

        return Response
                .ok(deliverymen)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDeliveryman(Deliveryman deliveryman) {
        boolean created;
        try {
            created = iDeliverymanServiceService.create(deliveryman);
        } catch (ServerErrorException ex) {
            return Response.serverError().entity(ex.getMessage()).build();
        }

        if (!created) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("Deliveryman account cannot be created!")
                    .build();
        }

        return Response
                .status(Response.Status.CREATED)
                .entity("Deliveryman account created successfully!")
                .build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeliveryman(@PathParam("id") int id) {
        Deliveryman deliveryman;
        try {
            deliveryman = iDeliverymanServiceService.get(id);
        } catch (ServerErrorException ex) {
            return Response
                    .status(500).entity(ex.getMessage()).build();
        }

        if (deliveryman == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Deliveryman account does not exist!")
                    .build();
        }

        return Response
                .status(Response.Status.OK)
                .entity(deliveryman)
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDeliveryman(@PathParam("id") int id) {
        boolean removed;

        try {
            removed = iDeliverymanServiceService.delete(id);
        } catch (ServerErrorException ex) {
            return Response
                    .status(500).entity(ex.getMessage()).build();
        }

        if (removed) {
            return Response.ok("A deliveryman account was removed successfully!").build();
        } else {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("A delivery account with such id was not found!")
                    .build();
        }
    }
}
