import java.util.*;

public class HomeWork5 {

    public static void main(String[] args) {
        Map<Integer, String> newHMap = new HashMap<>();
        Map<Integer, String> newTMap = new TreeMap<>();
        Scanner scanKey = new Scanner(System.in);
        Scanner scanValue = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Добавьте три элемента в коллекцию HashMap:");
        System.out.print("Введите первый ключ: ");
        Integer key = scanKey.nextInt();
        System.out.print("Введите первое значение: ");
        String value = scanValue.nextLine();
        newHMap.putIfAbsent(key, value);
        System.out.print("Введите второй ключ: ");
        key = scanKey.nextInt();
        System.out.print("Введите второе значение: ");
        value = scanValue.nextLine();
        newHMap.putIfAbsent(key, value);
        System.out.print("Введите третий ключ: ");
        key = scanKey.nextInt();
        System.out.print("Введите третье значение: ");
        value = scanValue.nextLine();
        newHMap.putIfAbsent(key, value);
        System.out.println("***************");

        System.out.println("Исходная коллекция HashMap:");
        System.out.println(newHMap);
        System.out.println("***************");
        newHMap.forEach((k, v) -> newHMap.compute(k, (k1, v1) -> v1 = v1 + "!"));
        System.out.println("Значения коллекции HashMap с восклицательными знаками:");
        System.out.println(newHMap);
        System.out.println("***************");

        System.out.println("Добавьте три элемента в коллекцию TreeMap:");
        System.out.print("Введите первый ключ: ");
        key = scanKey.nextInt();
        System.out.print("Введите первое значение: ");
        value = scanValue.nextLine();
        newTMap.putIfAbsent(key, value);
        System.out.print("Введите второй ключ: ");
        key = scanKey.nextInt();
        System.out.print("Введите второе значение: ");
        value = scanValue.nextLine();
        newTMap.putIfAbsent(key, value);
        System.out.print("Введите третий ключ: ");
        key = scanKey.nextInt();
        System.out.print("Введите третье значение: ");
        value = scanValue.nextLine();
        newTMap.putIfAbsent(key, value);
        System.out.println("***************");

        System.out.println("Исходная коллекция TreeMap:");
        System.out.println(newTMap);
        System.out.println("***************");

        System.out.println("Введите общую строку для заполнения коллекций:");
        String str = scanValue.nextLine();

        int sizeHM = newHMap.size();
        int sizeTM = newTMap.size();
        while (sizeHM < 1000) {
            key = rand.nextInt(1001);
            newHMap.putIfAbsent(key, str);
            sizeHM = newHMap.size();
        }
        while (sizeTM < 1000) {
            key = rand.nextInt(1001);
            newTMap.putIfAbsent(key, str);
            sizeTM = newTMap.size();
        }
        System.out.println("Количество элементов каждой коллекции увеличено до 1000");
        System.out.println("Коллекция HashMap:");
        System.out.println(newHMap);
        System.out.println("Коллекция TreeMap:");
        System.out.println(newTMap);
        System.out.println("***************");

        long start = System.currentTimeMillis();
        newHMap.forEach((k, v) -> v = v + "*");
        System.out.println("Время прямого перебора коллекции HashMap: " + (System.currentTimeMillis() -
                start) + " мск");
        start = System.currentTimeMillis();
        newTMap.forEach((k, v) -> v = v + "*");
        System.out.println("Время прямого перебора коллекции TreeMap: " + (System.currentTimeMillis() -
                start) + " мск");
        System.out.println();

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            int randomIndex = new Random().nextInt(1001);
            String strMap = newHMap.get(randomIndex);
        }
        System.out.println("Время случайного перебора коллекции HashMap: " + (System.currentTimeMillis() -
                start) + " мск");
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            int randomIndex = new Random().nextInt(1001);
            String strMap = newTMap.get(randomIndex);
        }
        System.out.println("Время случайного перебора коллекции TreeMap: " + (System.currentTimeMillis() -
                start) + " мск");
    }
}
