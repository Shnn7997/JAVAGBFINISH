
import java.util.*;

public class Notebook {
    private String brand;
    private int ram;
    private int hdd;
    private String os;
    private String color;
    private double price;

    public Notebook(String brand, int ram, int hdd, String os, String color, double price) {
        this.brand = brand;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public int getRam() {
        return ram;
    }

    public int getHdd() {
        return hdd;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public static void main(String[] args) {
        // Создаем множество ноутбуков
        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(new Notebook("Lenovo", 8, 1000, "Windows 10", "Black", 500.0));
        notebooks.add(new Notebook("Dell", 16, 2000, "Windows 10", "Silver", 1000.0));
        notebooks.add(new Notebook("HP", 8, 500, "Windows 7", "Red", 400.0));
        notebooks.add(new Notebook("Asus", 4, 250, "Windows 8", "White", 300.0));
        notebooks.add(new Notebook("Acer", 8, 750, "Windows 10", "Blue", 600.0));
        notebooks.add(new Notebook("Apple", 16, 1000, "macOS", "Gray", 1500.0));
        notebooks.add(new Notebook("MSI", 16, 2000, "Windows 10", "Black", 1200.0));
        notebooks.add(new Notebook("Huawei", 8, 512, "Windows 10", "Silver", 800.0));
        notebooks.add(new Notebook("Samsung", 4, 500, "Windows 10", "Black", 400.0));
        notebooks.add(new Notebook("Toshiba", 8, 1000, "Windows 10", "White", 600.0));

        // Map с критериями фильтрации
        Map<Integer, String> criteria = new HashMap<>();
        criteria.put(1, "RAM");
        criteria.put(2, "HDD");
        criteria.put(3, "OS");
        criteria.put(4, "Color");

        // Запрашиваем у пользователя критерии фильтрации
        Scanner scanner = new Scanner(System.in);
        Map<String, String> filters = new HashMap<>();
        for (Map.Entry<Integer, String> entry : criteria.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        System.out.println("Enter comma separated criteria numbers:");
        String[] criteriaNumbers = scanner.nextLine().split(",");
        for (String number : criteriaNumbers) {
            int criteriaNumber = Integer.parseInt(number.trim());
            System.out.println("Enter minimum value for " + criteria.get(criteriaNumber) + ":");
            String minValue = scanner.nextLine();
            filters.put(criteria.get(criteriaNumber), minValue);
        }

        // Отфильтровываем ноутбуки
        Set<Notebook> filteredNotebooks = new HashSet<>();
        for (Notebook notebook : notebooks) {
            if (notebook.getRam() >= Integer.parseInt(filters.getOrDefault("RAM", "0")) &&
                    notebook.getHdd() >= Integer.parseInt(filters.getOrDefault("HDD", "0")) &&
                    notebook.getOs().toLowerCase().contains(filters.getOrDefault("OS", "").toLowerCase()) &&
                    notebook.getColor().toLowerCase().contains(filters.getOrDefault("Color", "").toLowerCase())) {
                filteredNotebooks.add(notebook);
            }
        }

        // Выводим отфильтрованные ноутбуки
        for (Notebook notebook : filteredNotebooks) {
            System.out.println("Brand: " + notebook.getBrand() +
                    ", RAM: " + notebook.getRam() +
                    ", HDD: " + notebook.getHdd() +
                    ", OS: " + notebook.getOs() +
                    ", Color: " + notebook.getColor() +
                    ", Price: " + notebook.getPrice());
        }
    }
}
