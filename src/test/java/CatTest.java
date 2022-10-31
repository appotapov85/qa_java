
import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getSoundTest() {
        Cat cat = new Cat(feline);
        Assert.assertEquals("Мяу", cat.getSound());

    }

    @Test
    public void getFoodTest() throws Exception {
        Cat cat = new Cat(feline);
        List<String> food = List.of("Животные", "Птицы", "Печеньки");
        Mockito.when(feline.eatMeat()).thenReturn(food);
        Assert.assertEquals(food, cat.getFood());
    }
}