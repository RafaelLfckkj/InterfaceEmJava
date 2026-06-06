package entities;

import java.time.Duration;

public class RentalService {
    private double pricePerDay;
    private double pricePerHour;

    private BrazilTaxService taxService;

    public RentalService(double pricePerDay, double pricePerHour, BrazilTaxService taxService) {
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
        this.taxService = taxService;
    }

    public void processInvoice(CarRental carRental){

        double minutes = Duration.between(carRental.getStart(), carRental.getFisish()).toMinutes();
        double hours = minutes / 60.0 ;

        double basicPayment;

        if(hours <= 12.0){
            basicPayment = pricePerHour * Math.ceil(hours) ;
        }else{
            basicPayment = pricePerDay * Math.ceil(hours  / 24);
        }

        double tax = taxService.tax(basicPayment);

        carRental.setInvoice(new Invoice(basicPayment, tax));
    }

    
}
