import entities.BrazilTaxService;
import entities.CarRental;
import entities.RentalService;
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
        System.out.print("Modelo Do carro: ");
        String carModel = Scan.nextLine();
        System.out.print("Retirada (dd/MM/yyyy hh:mm): ");
        LocalDateTime start = LocalDateTime.parse(Scan.nextLine(), fmt);
        System.out.print("Retorno (dd/MM/yyyy hh:mm): ");
        LocalDateTime fisish = LocalDateTime.parse(Scan.nextLine(), fmt);

        CarRental cr = new CarRental(start, fisish, new Vehicle(carModel));

        System.out.print("Entre com o preoço por hora: ");
        double pricePerHour = Scan.nextDouble();
        System.out.print("Entre com o preoço por dia: ");
        double pricePerDay = Scan.nextDouble();

        RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());

        rentalService.processInvoice(cr);

        System.out.println("Fatura: ");
        System.out.println("Pagamento Basico: " + cr.getInvoice().getBasicPayment());
        System.out.println("Imposto: " + cr.getInvoice().getTax());
        System.out.println("Pagamento Total: " + cr.getInvoice().getTotalPayment());
        
        Scan.close();
    }
}