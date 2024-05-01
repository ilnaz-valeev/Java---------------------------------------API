import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        // Создаем HashMap для хранения имени и списка телефонов
        HashMap<String, List<String>> phoneBook = new HashMap<>();

        // Пример входных данных
        String[][] inputData = {
            {"Иван", "123456"},
            {"Петр", "789012"},
            {"Мария", "345678"},
            {"Иван", "456789"},
            {"Петр", "901234"},
            {"Анна", "567890"},
            {"Мария", "234567"}
        };

        // Заполняем телефонную книгу
        for (String[] entry : inputData) {
            String name = entry[0];
            String phone = entry[1];

            if (phoneBook.containsKey(name)) {
                phoneBook.get(name).add(phone);
            } else {
                List<String> phones = new ArrayList<>();
                phones.add(phone);
                phoneBook.put(name, phones);
            }
        }

        // Сортируем по убыванию числа телефонов
        List<Map.Entry<String, List<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        // Выводим результат
        for (Map.Entry<String, List<String>> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
