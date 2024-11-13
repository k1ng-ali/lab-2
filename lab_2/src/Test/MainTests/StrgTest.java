package Test.MainTests;

import Main.ContainerStrg;
import Main.LiquidStrg;
import Main.Storages;
import Main.Storage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StrgTest {
    private Storages storage;

    public StrgTest() {};

    @BeforeEach
    public void setUp() {
        storage = new Storages(){
        };
    }

    @Test
    public void TestAddStrg() throws IOException {

        LiquidStrg liquidTest = new LiquidStrg(1111, 25000, 13700, "Нефть",
                    13700);
        storage.add_storage(liquidTest);

        Storage TestStrg = storage.getStorages().get(0);
        assertEquals(TestStrg.getNum_storage(), 1111, "Тест номоер склада");
        assertEquals(TestStrg.getMax_capacity(), 25000, "Тест вместимость склада");
        assertEquals(TestStrg.getCapacity(), 13700, "Тест груз склада");

        LiquidStrg testStrgNew = (LiquidStrg) TestStrg;
        assertEquals(testStrgNew.GetTypeLiquid(), "Нефть", "Тест тип груза склада");
    }
}
