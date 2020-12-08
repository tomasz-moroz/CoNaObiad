package pl.conaobiad.dao;

import pl.conaobiad.model.Category;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class CategoryDao {

    @PersistenceContext
    EntityManager entityManager;

    public Category saveCategory(Category category){
        entityManager.persist(category);
        return category;
    }

    public Category updateCategory(Category category) {
        return entityManager.merge(category);
    }

    public Category getCategoryById(Long id) {
        return entityManager.find(Category.class, id);
    }

    public List<Category> getCategoriesList() {
        return entityManager.createNamedQuery(Category.GET_CATEGORY_LIST, Category.class).getResultList();
    }
    public Category findCategoryByName(String name) {
        TypedQuery<Category> query = entityManager.createNamedQuery(Category.FIND_CATEGORY_BY_NAME, Category.class);
        query.setParameter("name", name);
        return query.getResultList().stream().findFirst().orElse(null);
    }
    public String[] getCategoryIds() {
        Query query = entityManager.createNamedQuery(Category.GET_CATEGORY_IDS);

        List<Long> ListaIds = query.getResultList();
        String[] tablica = new String[ListaIds.size()];
        for (int i = 0; i < ListaIds.size(); i++) {
            tablica[i] = ListaIds.get(i).toString();
        }
        return tablica;
    }

}
