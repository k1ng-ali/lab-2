package Test.MainTests;
import Main.ContainerPm;
import Main.LogMode;
import Main.Platform;
import Main.Train;
import org.junit.jupiter.api.*;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class TrainTest {
    //private LinkedList<String> errors = new LinkedList<>();
    private Train test;

    public TrainTest() {}

    @BeforeEach
    public void setUp() {
        test = new Train(1111);
    }

    @AfterEach
    public void tearDown() {
        test = null;
    }

    @Test
    public void testTrainPlatformAdding() throws Exception {

        ContainerPm TestContainer = new ContainerPm(2222, 1200, 25000,
                    false);
        test.add_platform(TestContainer);

        Platform TestPm = test.getPlatforms().get(0);
        assertEquals(test.getNum_Train(), 1111, "Тест Номер Поезда");
        assertEquals(TestPm.getNum_platform(), 2222, "Тест номер платформы");
        assertEquals(TestPm.getCapacity(), 1200, "Тест груз платформы");
        assertEquals(TestPm.getMax_capacity(), 25000, "Тест грузопадьемность платформы");

    }

/*
    @Test
    void TrainTest() throws Exception {
        try{
            ContainerPm TestContainer = new ContainerPm(2222, 1200, 25000,
                    false);
            test.add_platform(TestContainer);
        }catch (Exception e){}

        Platform TestPm = test.getPlatforms().get(0);
        checkEquals(test.getNum_Train(), 1111, "Тест Номер Поезда");
        checkEquals(TestPm.getNum_platform(), 2222, "Тест номер платформы");
        checkEquals(TestPm.getCapacity(), 1200, "Тест груз платформы");
        checkEquals(TestPm.getMax_capacity(), 25000, "Тест грузопадьемность платформы");

        if (errors.size() != 0)
        {
            for (String error : errors) System.out.println(error);
        }
    }

    private void checkEquals(Object expected, Object actual,
                             String message) {
        if (!expected.equals(actual)) {
            this.errors.add(message + ": Введено=" + expected + ", получено=" + actual );
        }
    }
    */
}
