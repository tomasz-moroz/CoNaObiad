package pl.conaobiad.dto;

import pl.conaobiad.model.Ingredient;
import pl.conaobiad.model.Meal;

import java.util.ArrayList;
import java.util.List;

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
        meal.setCustom(mealDto.getCustom());
        meal.setApproved(mealDto.getApproved());

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
        mealDto.setCustom(meal.isCustom());
        mealDto.setApproved(meal.isApproved());

        return  mealDto;
    }

    public MealDto(Long id, String name, CategoryDto category, String countryOfOrigin, String recipe, String imageUrl, String youtubeLink, String tagsList, List<IngredientDto> ingredientList, String source, Boolean isCustom, Boolean isApproved) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.countryOfOrigin = countryOfOrigin;
        this.recipe = recipe;
        this.imageUrl = imageUrl;
        this.youtubeLink = youtubeLink;
        this.tagsList = tagsList;
        this.ingredientList = ingredientList;
        this.source = source;
        this.isCustom = isCustom;
        this.isApproved = isApproved;
    }

    public MealDto() {
    }

    public MealDto(String name, String countryOfOrigin, String recipe) {
        this.name = name;
        this.countryOfOrigin = countryOfOrigin;
        this.recipe = recipe;
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

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    public String getTagsList() {
        return tagsList;
    }

    public void setTagsList(String tagsList) {
        this.tagsList = tagsList;
    }

    public List<IngredientDto> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<IngredientDto> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Boolean getCustom() {
        return isCustom;
    }

    public void setCustom(Boolean custom) {
        isCustom = custom;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }

    @Override
    public String toString() {
        return "MealDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                ", recipe='" + recipe + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", youtubeLink='" + youtubeLink + '\'' +
                ", tagsList='" + tagsList + '\'' +
                ", ingredientList=" + ingredientList +
                ", source='" + source + '\'' +
                ", isCustom=" + isCustom +
                ", isApproved=" + isApproved +
                '}';
    }
}
