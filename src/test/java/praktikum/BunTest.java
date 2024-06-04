package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;
    private final float ACCURACY = 0.001F;

    public BunTest(String name, float price){
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters(){
        return new Object[][]{
                {"Флюоресцентная булка R2-D3", 52.22F},
                {"Краторная булка N-200i", 48.32F},
                {"Булочка с кунжутом", 22.432F},
        };
    }
    @Test
    public void getNameTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(), ACCURACY);
    }
}