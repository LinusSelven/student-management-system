package se.iths.rest;

import se.iths.entity.Student;
import se.iths.entity.Teacher;
import se.iths.rest.exceptions.StudentNotFoundException;
import se.iths.service.TeacherService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Set;

@Path("teacher")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeacherRest {

    @Inject
    TeacherService teacherService;

    @Path("add")
    @POST
    public Response createTeacher(Teacher teacher) {
        teacherService.createTeacher(teacher);
        return Response.ok(teacher).build();
    }

    @Path("all")
    @GET
    public Response getAllTeachers() {
        List<Teacher> teachers = teacherService.getAllTeachers();
        if(teachers.isEmpty()){
            throw new StudentNotFoundException("No teachers were found");
        } else {
            return Response.ok(teachers).build();
        }
    }

    @Path("getstudents/{teachername}/{subjectname}")
    @GET
    public Set<Student> getStudentsForSubject(@PathParam("teachername") String teacherName, @PathParam("subjectname") String subject) {
        return teacherService.getStudentsForSubject(teacherName, subject);
    }

    @Path("updateTeacher")
    @PUT
    public Response updateTeacher(Teacher teacher) {
        if(teacher != null)  {
            return Response.ok(teacherService.updateTeacher(teacher)).build();
        } else{
            throw new StudentNotFoundException("Something went wrong.");
        }
    }

    @Path("deleteTeacher/{id}")
    @DELETE
    public Response deleteTeacher(@PathParam("id") Long id) {
        Teacher teacher = teacherService.findTeacherById(id);
        if (teacher != null){
            teacherService.deleteTeacher(id);
            return Response.ok(teacher)
                    .entity("Player with ID " + id + " deleted.")
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build();
        }else  {
            return Response.noContent().build();
        }
    }



}
