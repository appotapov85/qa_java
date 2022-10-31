
import static org.junit.Assert.assertEquals;
import com.example.Animal;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class FelineTest {

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        String family = feline.getFamily();
        assertEquals(family, "Кошачьи");
    }

    @Test
    public void getKittensTest() {
        Feline feline = new Feline();
        int kittens = feline.getKittens();
        assertEquals(kittens, 1);

    }

    @Test
    public void countKittensTest() {
        Feline feline = new Feline();
        int kittensCount = feline.getKittens(3);
        assertEquals(kittensCount, 3);

    }

    @Test
    public void eatMeatPredatorTest() throws Exception {
        Feline feline = new Feline();
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(food,feline.getFood("Хищник"));
    }

    @Test
    public void eatMeatHerbivoreTest() throws Exception {
        Feline feline = new Feline();
        List<String> food = List.of("Трава", "Различные растения");
        Assert.assertEquals(food,feline.getFood("Травоядное"));
    }

    @Test
    public void eatMeatUnknownFoodTest() throws Exception {
            Exception exception = Assert.assertThrows(Exception.class, () -> {
                Animal animal = new Animal();
                animal.getFood("неизвестный");
            });
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }
}
