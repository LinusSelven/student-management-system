package se.iths.rest;


import se.iths.entity.Student;
import se.iths.rest.exceptions.StudentNotFoundException;
import se.iths.service.SchoolService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("school")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SchoolRest {


    @Inject
    SchoolService schoolService;


    @Path("getstudentsandsubjects/{lastname}/")
    @GET
    public Response getPlayerById(@PathParam("lastname") String name) {
        List<Student> player = schoolService.getStudentsAndTheirSubjectsByLastName(name);
        if (player != null) {
            return Response.ok(player).build();
        } else {
            throw new StudentNotFoundException("Student with name " + name + " not found.");
        }
    }


}