import java.util.*;

public class PhoneBook {
    Map<String, List<String>> book = new HashMap<>();
    public PhoneBook add(String name, String phoneNumber) {
        if (book.containsKey(name)) book.get(name).add(phoneNumber);
        else {
            List<String> numbers = new ArrayList<>();
            numbers.add(phoneNumber);
            book.putIfAbsent(name, numbers);
        }
        return this;
    }

    public void print() {
        for (var item : book.entrySet()) {
            System.out.printf("[%s]\n", item.getKey());
            for (var phone: item.getValue()) {
                System.out.printf("    [%s]\n", phone);
            }
        }
    }
}
