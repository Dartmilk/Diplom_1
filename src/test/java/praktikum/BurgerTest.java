package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredientOne;
    @Mock
    Ingredient ingredientTwo;


    @Test
    public void setBuns() {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(ingredientOne);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        burger.removeIngredient(1);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(ingredientTwo, burger.ingredients.get(0));
    }

    @Test
    public void getPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        Mockito.when(bun.getPrice()).thenReturn(5f);
        Mockito.when(ingredientOne.getPrice()).thenReturn(10f);
        Assert.assertEquals(20.0, burger.getPrice(), 0);
    }

    @Test
    public void getReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        Mockito.when(bun.getName()).thenReturn("Булочка с кунжутом");
        Mockito.when(ingredientOne.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientOne.getName()).thenReturn("Две мясных котлеты гриль");
        System.out.println(burger.getReceipt());
        Assert.assertEquals(String.format("(==== Булочка с кунжутом ====)%n" +
                "= filling Две мясных котлеты гриль =%n" +
                "(==== Булочка с кунжутом ====)%n" +
                "%nPrice: 0,000000%n"), burger.getReceipt());
    }
}