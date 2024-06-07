package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final String type;

    public IngredientTypeTest(String type) {
        this.type = type;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"SAUCE"},
                {"FILLING"},
        };
    }

    @Test
    public void presenceIngredientTest() {
        IngredientType ingredientType = IngredientType.valueOf(type);
        assertThat(ingredientType, is(notNullValue()));
    }
}