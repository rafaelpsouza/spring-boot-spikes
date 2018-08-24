package br.eng.rafaelpsouza.contract;

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

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

//https://jersey.java.net/documentation/latest/jaxrs-resources.html#d0e1914
//http://tools.ietf.org/html/rfc7231#section-4.3
@Path("/v1")
@Api(tags = "items")
public class Endpoint {

	@Context
	UriInfo uriInfo;

	@GET
	@Path("/items")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "List all items", response = Item.class, responseContainer = "List")
	public List<Item> list() {
		return ItemMock.listAll();
	}

	@GET
	@Path("/items/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Get item by id", response = Item.class)
	public Item get(@ApiParam(value = "Item id", required = true) @PathParam("id") Long id) {
		return ItemMock.getById(id);
	}

	@DELETE
	@Path("/items/{id}")
	@ApiOperation(value = "Delete Item")
	@ApiResponses({ @ApiResponse(code = 204, message = "Deleted") })
	public Response delete(@ApiParam(value = "Item id", required = true) @PathParam("id") Long id) {
		ItemMock.delete(id);
		return Response.noContent().build();
	}

	@POST
	@Path("/items")
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Create Item")
	@ApiResponses({ @ApiResponse(code = 201, message = "Created") })
	public Response create(@ApiParam(value = "Item to add", required = true) Item item) {
		ItemMock.add(item);
		return Response.created(uriInfo.getAbsolutePathBuilder().path(String.valueOf(item.getId())).build()).build();
	}

	@PUT
	@Path("/items/{id}")
	@ApiOperation(value = "Update Item")
	@ApiResponses({ @ApiResponse(code = 203, message = "Updated") })
	public Response update(@ApiParam(value = "Item id", required = true) @PathParam("id") Long id, 
			@ApiParam(value = "barCode") @QueryParam("barCode") String barCode,
			@ApiParam(value = "Description") @QueryParam("description") String description,
			@ApiParam(value = "Price") @QueryParam("price") BigDecimal price) {
		ItemMock.update(id, barCode, description, price);
		return Response.ok().build();
	}

}
