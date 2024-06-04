package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {

    private final Burger burger = new Burger();
    @Mock
    Database database;
    public List<Ingredient> ingredients = new ArrayList<>();

    @Before
    public void setupMockDatabase() {
        ingredients.add(new Ingredient(SAUCE, "Соус Spicy-X", 90));
        ingredients.add(new Ingredient(FILLING, "Мясо бессмертных моллюсков Protostomia", 1337));
        Mockito.when(database.availableIngredients()).thenReturn(ingredients);
    }

    @Test
    public void addIngredientsTest() {
        burger.addIngredient(database.availableIngredients().get(0));
        System.out.println("Ингредиенты после добавления: " + burger.ingredients);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientsTest() {
        burger.addIngredient(database.availableIngredients().get(0));
        System.out.println("Ингредиенты после удаления: " + burger.ingredients);
        burger.removeIngredient(0);
        System.out.println("Инегредиенты после перемещения: " + burger.ingredients);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(database.availableIngredients().get(1));
        burger.addIngredient(database.availableIngredients().get(0));
        System.out.println("Ингредиенты до смены мест: " + burger.ingredients);
        burger.moveIngredient(0, 1);
        System.out.println("Ингредиенты после смены мест: " + burger.ingredients);
        assertEquals(database.availableIngredients(), burger.ingredients);
    }
    @Test
    public void returnValueOfIngredientsTest(){
        Ingredient ingredient = new Ingredient(SAUCE, "Биг-Мак соус", 100.22F);
        assertEquals(100.22F, ingredient.getPrice(),0.001F);
        assertEquals(SAUCE, ingredient.getType());
        assertEquals("Биг-Мак соус", ingredient.getName());
    }

    }