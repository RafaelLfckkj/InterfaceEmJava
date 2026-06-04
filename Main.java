
import entities.CarRental;
import entities.Vehicle;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner Scan = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Entre com dados do Aluguel: ");
        System.out.print("Modelo Do carro:");
        String carModel = Scan.nextLine();
        System.out.println("Retirada (dd/MM/yyyy hh:mm): ");
        LocalDateTime start = LocalDateTime.parse(Scan.nextLine(), fmt);
        System.out.println("Retorno (dd/MM/yyyy hh:mm): ");
        LocalDateTime fisish = LocalDateTime.parse(Scan.nextLine(), fmt);

        CarRental cr = new CarRental(start, fisish, new Vehicle(carModel));
    }
}