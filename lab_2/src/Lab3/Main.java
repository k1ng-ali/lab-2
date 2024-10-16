package Lab3;
import Main.Train;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static Random random = new Random();

    public static void main(String[] args) throws IOException {
        // Эксперименты для разных коллекций
        for (int i=10; i<=100000; i *= 10){
            runExperiment("ArrayList_",new ArrayList<>(), i);
            runExperiment("LinkkedList_", new LinkedList<>(), i);
        }
    }

    // Генерация ранд числа
    private static int RandInt() {
        return 100000000 + random.nextInt(900000000); // Число от 100000000 до 999999999
    }



    // Метод для выполнения экспериментов
    public static void runExperiment(String collectionType, Collection<Train> collection, int count_el) throws IOException {
        FileWriter logWriter = new FileWriter(collectionType + count_el + "_log.txt", true);

        logWriter.write("\nStart program: " + new Date() + "\n");
        logWriter.write(collectionType + count_el +"\n");

        // Добавляем объекты в коллекцию и логируем операции
        int totalAddTime = 0;
        int totalRemoveTime = 0;
        int elementCount = count_el; // Можно менять на 10, 100, 1000, 10000 и т.д.

        for (int i = 0; i < elementCount; i++) {
            long startTime = System.nanoTime();
            try {
                Train obj = new Train(RandInt());
                if (collection instanceof List) {
                    ((List<Train>) collection).add(obj);
                } else if (collection instanceof Map) {
                    ((Map<Integer, Train>) collection).put(i, obj);
                }

                long endTime = System.nanoTime();
                int operationTime = (int) (endTime - startTime);
                totalAddTime += operationTime;
                logWriter.write("add ID = " + i + " " + operationTime + "\n");
            }
            catch (Exception e) {
                logWriter.write("ID = " + i + " Error: " + e + "\n");
            }
        }

        logWriter.write("addTotalCount = " + elementCount + "\n");
        logWriter.write("addTotalTime = " + totalAddTime + "\n");
        logWriter.write("addMedianTime = " + (totalAddTime / elementCount) + "\n");


        // Удаление 10% элементов
        for (int i = 0; i < elementCount / 10; i++) {
            int CurrentSize = collection.size();
            int randomIndex = random.nextInt(CurrentSize);
            long startTime = System.nanoTime();

            if (collection instanceof List) {
                ((List<Train>) collection).remove(randomIndex);
            } else if (collection instanceof Map) {
                ((Map<Integer, Train>) collection).remove(randomIndex);
            }

            long endTime = System.nanoTime();
            int operationTime = (int) (endTime - startTime);
            totalRemoveTime += operationTime;
            logWriter.write("remove ID = " + randomIndex + " " + operationTime + "\n");
        }

        logWriter.write("removeTotalCount = " + (elementCount / 10) + "\n");
        logWriter.write("removeTotalTime = " + totalRemoveTime + "\n");
        logWriter.write("removeMedianTime = " + (totalRemoveTime / (elementCount / 10)) + "\n");

        logWriter.write("Finish program: " + new Date() + "\n");
        logWriter.close();
    }
}

