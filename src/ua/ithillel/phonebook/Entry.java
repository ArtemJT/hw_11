package ua.ithillel.phonebook;

public record Entry(String name, Long number) {

    @Override
    public String toString() {
        String numberFormatted = String.valueOf(number)
                .replaceAll("([0-9]{2})([0-9]{3})([0-9]{2})([0-9]{2})", "+380 ($1) $2-$3-$4");
        return "Entry {" +
                "name: '" + name + '\'' +
                ", number: " + numberFormatted +
                '}';
    }
}
