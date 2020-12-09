package pl.conaobiad.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.ArrayList;

@NamedQueries({
        @NamedQuery(
                name = Category.FIND_CATEGORY_BY_NAME,
                query = "SELECT distinct c FROM Category c WHERE c.name like :name"),

        @NamedQuery(
                name = Category.FIND_CATEGORY_BY_ID,
                query = "SELECT c FROM Category c WHERE c.id in :ids"),
        @NamedQuery(
                name = Category.GET_CATEGORY_LIST,
                query = "SELECT DISTINCT c FROM Category c"),
        @NamedQuery(
                name = Category.GET_CATEGORY_IDS,
                query = " SELECT c.id FROM Category c"),
        @NamedQuery(
                name = Category.FIND_DRINKS_BY_CATEGORY_NAME,
                query = " SELECT distinct m.name FROM Category u, Meal m JOIN u.mealList r WHERE r.id=u.id")
})

@Entity
@Table(name = "Category")
public class Category {

    public static final String FIND_CATEGORY_BY_NAME = "Category.findCategoryByName";
    public static final String FIND_CATEGORY_BY_ID = "Category.findCategoryById";
    public static final String GET_CATEGORY_LIST = "Category.getCategoryList";
    public static final String GET_CATEGORY_IDS = "Category.getCategoryIds";
    public static final String FIND_DRINKS_BY_CATEGORY_NAME = "Category.getDrinksListByCategoryName";

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String name;

    @OneToMany(mappedBy = "category", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Meal> mealList = new ArrayList<>();

    public Category(Long id, @NotNull String name, List<Meal> mealList) {
        this.id = id;
        this.name = name;
        this.mealList = mealList;
    }

    public Category(@NotNull String name) {
        this.name = name;
    }

    public Category() {
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

    public List<Meal> getMealList() {
        return mealList;
    }

    public void setMealList(List<Meal> mealList) {
        this.mealList = mealList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mealList=" + mealList +
                '}';
    }
}
