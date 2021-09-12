package homeWorkFour;

import java.util.HashMap;
import java.util.HashSet;

public class PhoneBook {
    private HashMap<String, HashSet<Integer>> phoneBook = new HashMap<>();

    void add(String lastname, Integer phone){
        HashSet<Integer> numbers = phoneBook.getOrDefault(lastname,new HashSet<>());
        numbers.add(phone);
        phoneBook.put(lastname,numbers);
    }

    public HashSet<Integer> get(String lastname){ return phoneBook.get(lastname); }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Petrov", 2747474);
        phoneBook.add("Petrov", 5747474);
        phoneBook.add("Sidorov", 2747490);
        phoneBook.add("kozlov", 2747477);

        System.out.println(phoneBook.get("Petrov"));
        System.out.println(phoneBook.get("Sidorov"));
        System.out.println(phoneBook.get("kozlov"));
    }


}
