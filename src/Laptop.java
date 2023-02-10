import java.util.*;
import java.util.stream.Collectors;

public class Laptop {
    private final String creator;
    private final String model;
    private int RAMSize;
    private int hardDriveSize;
    private String OS;

    public Laptop(String creator, String model) {
        this.creator = creator;
        this.model = model;
    }

    public Laptop setRAMSize(int RAMSize) {
        this.RAMSize = RAMSize;
        return this;
    }

    public Laptop setHardDriveSize(int hardDriveSize) {
        this.hardDriveSize = hardDriveSize;
        return this;
    }

    public Laptop setOS(String OS) {
        this.OS = OS;
        return this;
    }

    public String draw() {
        StringBuilder sb = new StringBuilder();
        sb.append(creator).append(' ').append(model).append(' ').append(RAMSize).append("Mb ").append(hardDriveSize)
                .append("Gb ").append(OS);
        return sb.toString();
    }

    public static Map<Integer, String> initFilterList() {
        Map<Integer, String> filterList = new HashMap<>();
        filterList.put(0, "Объем ОЗУ равен");
        filterList.put(1, "Объем ЖД равен");
        filterList.put(2, "Операционная система равен");
        filterList.put(3, "Модель равен");
        filterList.put(4, "Производитель равен");
        filterList.put(5, "Объем ЖД больше, чем");
        filterList.put(6, "Объем ЖД меньше, чем");
        return filterList;
    }

    public static Set<Laptop> filter(Set<Laptop> laptops, Map<Integer, String> filter) {
        Set<Laptop> filteredLaptops = laptops
                .stream()
                .filter(laptop -> laptop.checkRAMSize(filter.get(0)))
                .filter(laptop -> laptop.checkHardDriveSize(filter.get(1),'='))
                .filter(laptop -> laptop.checkOS(filter.get(2)))
                .filter(laptop -> laptop.checkModel(filter.get(3)))
                .filter(laptop -> laptop.checkCreator(filter.get(4)))
                .filter(laptop -> laptop.checkHardDriveSize(filter.get(5),'>'))
                .filter(laptop -> laptop.checkHardDriveSize(filter.get(6),'<'))
                .collect(Collectors.toCollection(HashSet::new));
        return filteredLaptops;
    }

    private boolean checkCreator(String name) {
        if (Objects.equals(name, "-")) return true;
        try {
            return Objects.equals(creator, name);
        } catch (Exception e) {
            return true;
        }
    }

    private boolean checkModel(String name) {
        if (Objects.equals(name, "-")) return true;
        try {
            return Objects.equals(model, name);
        } catch (Exception e) {
            return true;
        }
    }

    private boolean checkRAMSize(String size) {
        if (Objects.equals(size, "-")) return true;
        try {
            return RAMSize == Integer.parseInt(size);
        } catch (Exception e) {
            return true;
        }
    }

    private boolean checkHardDriveSize(String size, char operator) {
        if (Objects.equals(size, "-")) return true;
        try {
            switch (operator) {
                case '<':
                    return hardDriveSize < Integer.parseInt(size);
                case '>':
                    return hardDriveSize > Integer.parseInt(size);
                case '=':
                    return hardDriveSize == Integer.parseInt(size);
                default:
                    throw new Exception("Unknown operator");
            }

        } catch (Exception e) {
            return true;
        }
    }

    private boolean checkOS(String name) {
        if (Objects.equals(name, "-")) return true;
        try {
            return Objects.equals(OS, name);
        } catch (Exception e) {
            return true;
        }
    }
}
