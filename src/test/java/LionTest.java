
import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Before
    public void setMock() {
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters(name = "{index}: {0}-{1}")
    public static Iterable<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {1, 1},
                {2, 2}
        });
    }

    @Parameterized.Parameter(0)
    public int volume;

    @Parameterized.Parameter(1)
    public int result;

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getKittens()).thenReturn(volume);
        Assert.assertEquals(result,lion.getKittens());
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        List<String> food = List.of("Животные", "Птицы", "Печеньки");
        Mockito.when(feline.getFood("Хищник")).thenReturn(food);
        Assert.assertEquals(food, lion.getFood());
    }

    @Test
    public void doesHaveManeTrueTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Assert.assertTrue(lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeFalseTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Assert.assertFalse(lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeNoneTest() throws Exception {
        Exception exception = Assert.assertThrows(Exception.class, () -> {
            new Lion("Самки", feline);
        });
        Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

}