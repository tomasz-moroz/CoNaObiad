package pl.conaobiad.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.conaobiad.model.Ingredient;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientDto {

    private Long id;
    private String name;
    private String measure;

    public static Ingredient dtoToIngredient(IngredientDto ingredientDto){
        Ingredient ingredient = new Ingredient();
        ingredient.setName(ingredientDto.getName());
        ingredient.setMeasure(ingredientDto.getMeasure());
        return ingredient;
    }

    public static IngredientDto ingredientToDto(Ingredient ingredient){
        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setId(ingredient.getId());
        ingredientDto.setName(ingredient.getName());
        ingredientDto.setMeasure(ingredient.getMeasure());
        return ingredientDto;
    }
}
