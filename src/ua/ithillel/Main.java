package ua.ithillel;

import java.util.*;

public class Main {

    private static final String HELLO_WORLD = "Hello world!";
    private static final String WORLD = "world!";
    private static final String HELLO = "Hello";

    public static void main(String[] args) {

        List<String> listHelloWorld = new ArrayList<>();
        List<String> listHello = new ArrayList<>();
        List<String> listWorld = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            listHelloWorld.add(HELLO_WORLD);
            listHello.add(WORLD);
            listWorld.add(HELLO);
        }

        List<String> list = new ArrayList<>(listHelloWorld);
        list.addAll(listHello);
        list.addAll(listWorld);
        Collections.shuffle(list);

        long occurrence = countOccurrence(list, HELLO_WORLD);
        System.out.println("\n1. Occurrence of " + "\"" + HELLO_WORLD + "\"" + " = " + occurrence);

        int[] intArray = {1, 2, 2, 3, 3, 3, 4, 5, 6, 7, 5, 5, 8, 9, 7, 7, 7, 10, 11, 12, 13, 13, 13, 13};
        List<Integer> integerList = toList(intArray);

        System.out.println("\n2. List of intArray: " + integerList);

        System.out.println("\n3. List of unique numbers of integerList: " + findUnique(integerList));

        System.out.println("\n4.1. CalcOccurance:");
        calcOccurrence(list);

        System.out.println("\n4.2. Structure occurrence of List: ");
        findOccurrence(list).forEach(System.out::println);
    }

    private static long countOccurrence(List<String> stringList, String string) {
        return stringList.stream().filter(s -> s.equals(string)).count();
    }

    private static List<Integer> toList(int[] intArray) {
        return Arrays.stream(intArray).boxed().toList();
    }

    private static List<Integer> findUnique(List<Integer> integerList) {
        return integerList.stream().distinct().toList();
    }

    private static void calcOccurrence(List<String> stringList) {
        String stringPattern = "\"%s\": '%d'%n";
        stringList.stream()
                .distinct()
                .forEach(s -> System.out.printf(stringPattern, s, countOccurrence(stringList, s)));
    }

    private static List<String> findOccurrence(List<String> stringList) {
        String stringPattern = "{word: \"%s\", occurrence = '%d'}";
        return stringList.stream()
                .distinct()
                .map(s -> String.format(stringPattern, s, countOccurrence(stringList, s)))
                .toList();
    }
}