package ua.ithillel.phonebook;

import java.util.ArrayList;
import java.util.List;

public class Phonebook {

    private static final List<Entry> entries = new ArrayList<>();

    public static void add(String name, Long number) {
        if (name != null && number != null) entries.add(new Entry(name, number));
    }

    public static Entry find(String name) {
        return entries.stream()
                .filter(entry -> name.equalsIgnoreCase(entry.name()))
                .findFirst()
                .orElse(null);
    }

    public static List<Entry> findAll(String name) {
        if (find(name) == null) return null;

        return entries.stream()
                .filter(entry -> name.equalsIgnoreCase(entry.name()))
                .toList();
    }

    public static List<Entry> getEntries() {
        return entries;
    }
}
