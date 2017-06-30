package cap.bouygues.rest;

import cap.bouygues.model.Person;
import cap.bouygues.service.IPersonService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by sbouzaab on 01/05/2017.
 */
@Component
@Path("/personWS")
public class PersonWebService {


    @Autowired
    IPersonService personService;
    final static Logger logger = Logger.getLogger(PersonWebService.class);

    @GET
    @Path("/sayHello")
    public Response getMessage() {

        String result = personService.sayHello();

        return Response.status(200).entity(result).build();

    }

    //http://localhost:8080/rest/personWS/sayHello

    //http://localhost:8080/rest/personWS/getPersons


    @GET
    @Path("/getAllPersons")
    @Produces("application/json")
    public List<Person> getAllPersons() {
        logger.info("+ getAllPerson : " );
        List personList = personService.getListAllPerson();
        logger.info("- getAllPerson : " + personList);
        return personList;
    }

    //http://localhost:8080/rest/personWS/createPerson
//[{"id":1,"nom":"bouzaabit","prenom":"said"}
    @POST
    @Path("/addPerson")
    @Consumes(MediaType.APPLICATION_JSON) //application/json
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPerson(Person per) {
        logger.info("+ createPerson : " + per);
        /*per.setNom(per.getNom());
        per.setPrenom(per.getPrenom());*/
        personService.addPerson(per);
        logger.info("- createPerson : " + per);
        return Response.status(201).entity(per).build();

        //return Response.ok().build();
    }

    //http://localhost:8080/rest/personWS/getPersonById/{id}

    @GET
    @Path("/getPersonById/{id}")
    @Produces("application/json")
    public Person getPersonById(@PathParam("id") String idPerson ) { //Person getPersonById(@QueryParam("id") String idPerson)
        logger.info("+ idperson : "+idPerson );
            Long id = Long.valueOf(idPerson);
         Person prs= personService.getPersonById(id);
        return prs;
         //Response.status(200).entity("getPersonrById is called, id : " + id).build();

    }


    @GET
    @Path("/getPersonByName/{nom}")
    @Produces("application/json")
    public Person getPersonByName(@PathParam("nom") String nomPerson ) { //Person getPersonById(@QueryParam("id") String idPerson)
        Person prs= personService.getPersonByName(nomPerson);
        return prs;
        //Response.status(200).entity("getPersonrById is called, id : " + id).build();

    }

    //http://localhost:8080/rest/personWS/updatePerson
//[{"id":1,"nom":"bouzaabit","prenom":"said"}
    @POST
    @Path("/updatePerson")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePerson(Person person) {
        logger.info("+ updatePerson : " + person.getId());
        personService.updatePerson(person);
        logger.info("- updatePerson : " + person.getId());
        return Response.status(201).entity(person).build();
                /*.header("Access-Control-Allow-Origin", "*") //pour les acces CORSE
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();*/
    }

    //http://localhost:8080/rest/personWS/deletePersonById/{id}
    @GET
    @Path("/deletePerson/{id}")
    @Produces("application/json")
    public List<Person> deletePerson(@PathParam("id") int id){
        logger.info(" + deletePerson : " + id);
        Long idP = Long.valueOf(id);
        personService.deletePerson(idP);
        List personList = personService.getListAllPerson();
        logger.info(" - deletePerson : " + idP);
        return personList;

    }




}

