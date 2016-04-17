package br.eng.rafaelpsouza.endpoint;

import java.math.BigDecimal;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import br.eng.rafaelpsouza.adapter.ItemAdapter;
import br.eng.rafaelpsouza.contract.v1.ExampleServiceContract;
import br.eng.rafaelpsouza.contract.v1.Item;
import br.eng.rafaelpsouza.impl.ItemMock;

@Path("/v1")
public class RestEndpoint implements ExampleServiceContract<Response> {

    @Context
    UriInfo uriInfo;
    ItemAdapter adapter = new ItemAdapter();

    @GET
    @Path("/items")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Item> list() {
        return adapter.bindFromModel(ItemMock.listAll());
    }

    @GET
    @Path("/items/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Item get(@PathParam("id") Long id) {
        return adapter.bindFromModel(ItemMock.getById(id));
    }

    @DELETE
    @Path("/items/{id}")
    @Override
    public Response delete(@PathParam("id") Long id) {
        ItemMock.delete(id);
        return Response.noContent().build();
    }

    @POST
    @Path("/items")
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response create(Item item) {
        ItemMock.add(adapter.bindToModel(item));
        return Response.created(uriInfo.getAbsolutePathBuilder().path(String.valueOf(item.id)).build()).build();
    }

    @PUT
    @Path("/items/{id}")
    @Override
    public Response update(@PathParam("id") Long id, @QueryParam("barCode") String barCode,
            @QueryParam("description") String description,
            @QueryParam("price") BigDecimal price) {
        ItemMock.update(id, barCode, description, price);
        return Response.ok().build();
    }

}
