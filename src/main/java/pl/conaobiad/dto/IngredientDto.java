package pl.conaobiad.dto;

import pl.conaobiad.model.Ingredient;

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

    public IngredientDto() {
    }

    public IngredientDto(Long id, String name, String measure) {
        this.id = id;
        this.name = name;
        this.measure = measure;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    @Override
    public String toString() {
        return "IngredientDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", measure='" + measure + '\'' +
                '}';
    }
}
