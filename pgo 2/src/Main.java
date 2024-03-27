import java.util.Scanner;
public class MuseumTicketCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj wiek: ");
        int age = scanner.nextInt();
        System.out.print("Czy jesteś mieszkańcem Warszawy? (tak/nie): ");
        String resident = scanner.next().toLowerCase();
        System.out.print("Podaj dzień tygodnia (np. 'poniedziałek', 'czwartek'): ");
        String day = scanner.next().toLowerCase();
        double ticketPrice = calculateTicketPrice(age, resident.equals("tak"), day);
        String discountInfo = calculateDiscountInfo(age, resident.equals("tak"), day);
        System.out.println("Dane klienta: Wiek: " + age + " lat, Mieszkaniec Warszawy: " + resident + ", Dzień tygodnia: " + day);
        System.out.println("Cena biletu po rabacie: " + ticketPrice + " zł");
        System.out.println("Informacja o zniżce: " + discountInfo);
        runUnitTests();
    }
    public static double calculateTicketPrice(int age, boolean isWarsawResident, String day) {
        double basePrice = 40;
        double ticketPrice = basePrice;
        if (age < 10 || day.equals("czwartek")) {
            ticketPrice = 0;
        } else if (age >= 10 && age <= 18) {
            ticketPrice *= 0.5;
        }
        if (isWarsawResident) {
            ticketPrice *= 0.9;
        }
        return ticketPrice;
    }
    public static String calculateDiscountInfo(int age, boolean isWarsawResident, String day) {
        StringBuilder discountInfo = new StringBuilder();
        if (age < 10 || day.equals("czwartek")) {
            discountInfo.append("Bezpłatny wstęp");
        } else if (age >= 10 && age <= 18) {
            discountInfo.append("50% zniżki");
        }
        if (isWarsawResident) {
            if (discountInfo.length() > 0) {
                discountInfo.append(", ");
            }
            discountInfo.append("Dodatkowa 10% zniżki dla mieszkańców Warszawy");
        }
        return discountInfo.toString();
    }
    // Zadanie 2 (Testy jednostkowi)
    public static void runUnitTests() {
        testCalculateTicketPrice();
        testCalculateDiscountInfo();
    }
    public static void testCalculateTicketPrice() {
        assert calculateTicketPrice(5, false, "poniedziałek") == 0;
        assert calculateTicketPrice(15, false, "wtorek") == 20;
        assert calculateTicketPrice(25, true, "środa") == 18;
        assert calculateTicketPrice(30, false, "czwartek") == 0;
    }
    public static void testCalculateDiscountInfo() {
        assert calculateDiscountInfo(5, false, "poniedziałek").equals("Bezpłatny wstęp");
        assert calculateDiscountInfo(15, false, "wtorek").equals("50% zniżki");
        assert calculateDiscountInfo(25, true, "środa").equals("Dodatkowa 10% zniżki dla mieszkańców Warszawy");
        assert calculateDiscountInfo(30, false, "czwartek").equals("Bezpłatny wstęp");
    }
}