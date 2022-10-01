package ua.ithillel.phonebook;

import java.util.List;
import java.util.Random;

import static ua.ithillel.phonebook.Phonebook.*;

public class PhonebookMain {

    public static void main(String[] args) {
        String[] names = {"Tom", "Alex", "David", "John", "Bob", "Richard", "Donald", "Jack"};
        Long[] numbers = {669879562L, 639451687L, 932154348L, 997987785L,
                973123753L, 984532487L, 674564873L, 501357897L};
        Random random = new Random();

        for (int i = 0; i < 11; i++) {
            add(names[random.nextInt(names.length)], numbers[random.nextInt(numbers.length)]);
        }
        System.out.println(getEntries());

        String nameToFind = names[random.nextInt(names.length)];
        Entry entry = find(nameToFind);
        if (entry != null) {
            System.out.println(entry);
        } else {
            System.out.printf("The name '%s' is not on the Phonebook%n", nameToFind);
        }

        String nameToFindAll = names[random.nextInt(names.length)];
        List<Entry> entryList = findAll(nameToFindAll);
        if (entryList != null) {
            System.out.println(entryList);
        } else {
            System.out.printf("The name '%s' is not on the Phonebook%n", nameToFindAll);
        }
    }
}
