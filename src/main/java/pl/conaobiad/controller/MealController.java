package pl.conaobiad.controller;

import pl.conaobiad.dto.MealDto;
import pl.conaobiad.service.MealService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MealController {

    @Inject
    MealService mealService;

    @POST
    public MealDto saveMealList(MealDto mealDto){
        mealService.addMeal(mealDto);
        return mealDto;
    }
    @Path("/{id}")
    @GET
    public Response getMealById(@PathParam("id")Long id){
        return Response.ok(mealService.getMealById(id)).build();
    }
    @GET
    public List<MealDto> getAll(){
        return mealService.getMealList();
    }
    @Path("/{id}")
    @DELETE
    public Response delete(@PathParam("id")Long id){
        mealService.deleteMealById(id);
        return Response.noContent().build();
    }
}
