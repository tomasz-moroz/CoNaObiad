package pl.conaobiad.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.conaobiad.dao.IngredientDao;
import pl.conaobiad.dto.IngredientDto;
import pl.conaobiad.model.Ingredient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequestScoped
public class IngredientService {
    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private IngredientDao ingredientDao;

    public void addIngredient(IngredientDto ingredientDto) {
        Ingredient ingredient = IngredientDto.dtoToIngredient(ingredientDto);
        ingredientDao.addIngredient(ingredient);
    }

    public void editIngredient(IngredientDto ingredientDTO) {
        Ingredient ingredient = IngredientDto.dtoToIngredient(ingredientDTO);
        ingredientDao.editIngredient(ingredient);
    }

    public Ingredient getIngredientByName(String name) {
        logger.info("Get Ingredient by name");
        return ingredientDao.getIngredientByName(name);
    }

    public Ingredient getIngredientById(Long id) {
        return ingredientDao.getIngredientById(id);
    }

    public void deleteCategoryById(Long id) {
        ingredientDao.deleteIngredientById(id);
    }


    @Transactional
    public List<IngredientDto> getIngredientsList() {
        return ingredientDao.getIngredientsList()
                .stream()
                .map(IngredientDto::ingredientToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public Set<String> getUniqueIngredientsNameList() {
        return ingredientDao.getIngredientsList()
                .stream()
                .map(Ingredient::getName)
                .collect(Collectors.toSet());
    }
}

