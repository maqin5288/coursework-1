package com.example.restful_service.rest;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.restful_service.model.User;

@Path("/user")
public class UserService {

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response findUser(@PathParam("id") String id) {
		Response response;
		if ("qin123".equalsIgnoreCase(id)) {
			User user = new User();
			user.setUserName(id);
			user.setAge(20);
			user.setDateJoined(new Date());
			user.setLastLogin(new Date());
			response = Response.ok(user).build();
		} else {
			response = Response.status(404).build();
		}
		return response;
	}
}
