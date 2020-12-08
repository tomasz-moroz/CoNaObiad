package pl.conaobiad.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.conaobiad.model.Ingredient;
import pl.conaobiad.model.Meal;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MealDto {

    private Long id;
    private String name;
    private CategoryDto category;
    private String countryOfOrigin;
    private String recipe;
    private String imageUrl;
    private String youtubeLink;
    private String tagsList;
    private List<IngredientDto> ingredientList;
    private String source;
    private Boolean isCustom;
    private Boolean isApproved;

    public static Meal dtoToMeal(MealDto mealDto){
        Meal meal = new Meal();
        meal.setName(mealDto.getName());

        meal.setCategory(CategoryDto.dtoToCategory(mealDto.getCategory()));

        meal.setCountryOfOrigin(mealDto.getCountryOfOrigin());
        meal.setRecipe(mealDto.getRecipe());
        meal.setImageUrl(mealDto.getImageUrl());
        meal.setYoutubeLink(mealDto.getYoutubeLink());
        meal.setTagsList(mealDto.getTagsList());

        List<Ingredient> ingredientList = new ArrayList<>();
        mealDto.getIngredientList().forEach(ingredientDto -> {
            Ingredient ingredient = IngredientDto.dtoToIngredient(ingredientDto);
            ingredientList.add(ingredient);
        });

        meal.setSource(mealDto.getSource());
        meal.setCustom(mealDto.getIsCustom());
        meal.setApproved(mealDto.getIsApproved());

        return meal;
    }

    public static MealDto mealToDto(Meal meal){
        MealDto mealDto = new MealDto();
        mealDto.setName(meal.getName());

        mealDto.setCategory(CategoryDto.categoryToDto(meal.getCategory()));

        mealDto.setCountryOfOrigin(meal.getCountryOfOrigin());
        mealDto.setRecipe(meal.getRecipe());
        mealDto.setImageUrl(meal.getImageUrl());
        mealDto.setYoutubeLink(meal.getYoutubeLink());
        mealDto.setTagsList(meal.getTagsList());

        List<IngredientDto> ingredientDtoList = new ArrayList<>();
        meal.getIngredientsList().forEach(i -> {
            IngredientDto ingredientDto = IngredientDto.ingredientToDto(i);
            ingredientDtoList.add(ingredientDto);
        });
        mealDto.setIngredientList(ingredientDtoList);

        mealDto.setSource(meal.getSource());
        mealDto.setIsCustom(meal.isCustom());
        mealDto.setIsApproved(meal.isApproved());

        return  mealDto;
    }

}
