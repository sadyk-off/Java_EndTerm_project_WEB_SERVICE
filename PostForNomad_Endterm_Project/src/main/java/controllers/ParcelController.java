package controllers;

import entities.Parcel;
import filters.customAnnotations.JWTTokenNeeded;
import services.interfaces.IParcelService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("parcels")
public class ParcelController {
    @Inject
    private IParcelService parcelService;

    @JWTTokenNeeded
    @GET
    public Response getAllParcels() {
        List<Parcel> parcels;
        try {
            parcels = parcelService.getAll();
        } catch (ServerErrorException ex) {
            return Response
                    .status(500).entity(ex.getMessage()).build();
        }

        return Response
                .ok(parcels)
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteParcel(@PathParam("id") int id) {
        boolean removed;

        try {
            removed = parcelService.delete(id);
        } catch (ServerErrorException ex) {
            return Response
                    .status(500).entity(ex.getMessage()).build();
        }

        if (removed) {
            return Response.ok("A parcel was removed successfully!").build();
        } else {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("A parcel with such id was not found!")
                    .build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createParcel(Parcel parcel) {
        boolean created;
        try {
            created = parcelService.create(parcel);
        } catch (ServerErrorException ex) {
            return Response.serverError().entity(ex.getMessage()).build();
        }

        if (!created) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("Parcel cannot be created!")
                    .build();
        }

        return Response
                .status(Response.Status.CREATED)
                .entity("Parcel created successfully!")
                .build();
    }

    @JWTTokenNeeded
    @GET
    @Path("/{id}")
    public Response getParcelById(@PathParam("id") int id) {
        Parcel parcel;
        try {
            parcel = parcelService.getParcelById(id);
        } catch (ServerErrorException ex) {
            return Response
                    .status(500).entity(ex.getMessage()).build();
        }

        if (parcel == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Parcel does not exist!")
                    .build();
        }

        return Response
                .status(Response.Status.OK)
                .entity(parcel)
                .build();
    }
}
