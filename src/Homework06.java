import java.util.*;
import java.util.stream.Collectors;

public class Homework06 {

    /**
     * Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
     * Создать множество ноутбуков.
     * Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
     * отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например: “Введите цифру, соответствующую необходимому критерию:
     * 1 - ОЗУ
     * 2 - Объем ЖД
     * 3 - Операционная система
     * 4 - Цвет …
     * Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
     * Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
     */
    public Homework06() {
        Set<Laptop> laptops = initNotebooks();
        System.out.println("Количество ноутбуков: " + laptops.size());
        Map<Integer, String> filter = inputFilters();
        Set<Laptop> filteredLaptops = Laptop.filter(laptops, filter);
        System.out.println("Количество совпадений: " + filteredLaptops.size() + "\n");
        for (Laptop laptop : filteredLaptops) {
            System.out.println(laptop.draw());
        }

    }

    private Map<Integer, String> inputFilters() {
        Map<Integer, String> filters = new HashMap<>();
        try (Scanner scanner = new Scanner(System.in)) {
            Map<Integer, String> filterList = Laptop.initFilterList();
            System.out.println("Введите ниже значение каждого фильтра или -, если фильтр не нужен");
            for (var filter : filterList.entrySet()) {
                System.out.printf(filter.getValue() + ": ");
                String value = scanner.next();
                filters.put(filter.getKey(), value);
            }
        } catch (Exception e) {
            System.out.printf("Ошибка: %s", e.getMessage());
        }
        return filters;
    }

    private Set<Laptop> initNotebooks() {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add((new Laptop("Ромашка", "X1"))
                .setRAMSize(256)
                .setHardDriveSize(512)
                .setOS("Windows"));
        laptops.add((new Laptop("Ромашка", "X2"))
                .setRAMSize(512)
                .setHardDriveSize(1024)
                .setOS("Linux"));
        laptops.add((new Laptop("Ромашка", "X3"))
                .setRAMSize(512)
                .setHardDriveSize(1024)
                .setOS("Linux"));
        laptops.add((new Laptop("Ромашка", "X4"))
                .setRAMSize(1024)
                .setHardDriveSize(2048)
                .setOS("Linux"));
        laptops.add((new Laptop("Ромашка", "X5"))
                .setRAMSize(1024)
                .setHardDriveSize(512)
                .setOS("Linux"));
        laptops.add((new Laptop("Рога и копыта", "SPACE"))
                .setRAMSize(1024)
                .setHardDriveSize(2048)
                .setOS("Windows"));
        return laptops;
    }

}
