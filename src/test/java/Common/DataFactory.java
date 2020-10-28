package Common;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class DataFactory {

    //Setup
    private static final SecureRandom rnd = new SecureRandom();
    private static final AtomicInteger uidCounter = new AtomicInteger(1);



    //Numbers
    public static int getRandomIntBetween(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getUniqueID() {
        DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("uuuuMMddhhmmss");
        return formatter.format(LocalDateTime.now()) + "." + uidCounter.getAndIncrement();
    }



    //Dates
    public static LocalDate getDateBetween(LocalDate minDate, LocalDate maxDate) {
        int minDay = (int) minDate.toEpochDay();
        int maxDay = (int) maxDate.toEpochDay();
        long randomDay = getRandomIntBetween(minDay, maxDay);

        return LocalDate.ofEpochDay(randomDay);
    }



    //User Attributes
    public static String generateFirstName() {
        String[] firstNames = {"Sophia", "Jacob", "Isabella", "Mason", "Emma", "William", "Olivia", "Jayden",
                "Ava", "Noah", "Emily", "Michael", "Abigail", "Ethan", "Madison", "Alexander", "Mia", "Aiden",
                "Chloe", "Daniel"};
        return firstNames[rnd.nextInt(firstNames.length)];
    }

    public static String generateLastName() {
        String[] lastNames = {"Smith", "Jones", "Taylor", "Williams", "Brown", "Davies", "Evans", "Wilson",
                "Thomas", "Roberts", "Johnson", "Lewis", "Walker", "Robinson", "Wood", "Thompson", "White",
                "Watson", "Jackson", "Wright"};
        return lastNames[rnd.nextInt(lastNames.length)];
    }

    public static String generateGender() {
        String[] genders = {"Male", "Female", "N/A"};
        return genders[rnd.nextInt(genders.length)];
    }

    public static String generateAddr1() {
        String[] streetNames = {"Ash", "Aspen", "Beech", "Birch", "Cherry", "Chestnut", "Elm", "Fir", "Hawthorn",
                "Hemlock", "Hickory", "Larch", "Maple", "Oak", "Pine", "Cedar", "Sycamore", "Spruce", "Walnut",
                "Willow"};
        String[] streetSuffixes = {"Avenue", "Bend", "Court", "Drive", "Extension", "Ford", "Glen", "Hill", "Inlet",
                "Junction", "Knoll", "Lane", "Manor", "Neck", "Orchard", "Path", "Road", "Street", "Trail", "Union",
                "Valley", "Way"};
        return rnd.nextInt(99) + " " + streetNames[rnd.nextInt(streetNames.length)]
                + " " + streetSuffixes[rnd.nextInt(streetSuffixes.length)];
    }

    public static String generateAddr2() {
        return (rnd.nextBoolean()) ? "" : "Apt " + rnd.nextInt(999);
    }

    public static String generateCity() {
        String[] cities = { "Pallet Town", "Viridian City", "Pewter City", "Vermillion City", "Lavender Town",
                "Celadon City", "Fuschia City", "Saffron City", "Cinnabar Island" };
        return cities[rnd.nextInt(cities.length)];
    }

    public static String generateState() {
        String[] states = { "Alabama", "Alaska", "American Samoa", "Arizona", "Arkansas", "California", "Colorado",
                "Connecticut", "Delaware", "District of Columbia", "Florida", "Georgia", "Guam", "Hawaii", "Idaho",
                "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts",
                "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire",
                "New Jersey", "New Mexico",  "New York", "North Carolina", "North Dakota",  "Ohio", "Oklahoma",
                "Oregon", "Pennsylvania", "Puerto Rico", "Rhode Island", "South Carolina", "South Dakota", "Tennessee",
                "Texas", "Utah", "Vermont", "Virgin Islands", "Virginia", "Washington", "West Virginia", "Wisconsin",
                "Wyoming"};
        return states[rnd.nextInt(states.length)];
    }

    public static String generateZip() {
        return Integer.toString((1 + rnd.nextInt(9)) * 10000 + rnd.nextInt(10000));
    }

    public static String generatePhoneNumber(){
        return  String.format("(%03d) %03d-%04d",
                (int) Math.floor(999*Math.random()),
                (int) Math.floor(999*Math.random()),
                (int) Math.floor(9999*Math.random()));
    }

    public static String generateEmailAddress() {
        return "student" + getUniqueID() + "@example.com";
    }

}
