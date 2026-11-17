package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Asset> assets = new ArrayList<>();

        Asset house = new House("Main Home", "10-12-2022", new BigDecimal("270000"),
                "Despair Street", 1, 1520, 40);
        Asset vacationHouse = new House("Vacation Home", "12-31-2025", new BigDecimal("200000"),
                "Jolly Street", 2, 1200, 30);

        Asset car = new Vehicle("Main Car", "10-12-2022", new BigDecimal("4000"), "Toyota", 2022, 120000);
        Asset fancyCar = new Vehicle("Fancy Car", "12-20-2026", new BigDecimal("8000"), "Lamborghini", 2025, 100001);

        assets.add(house);
        assets.add(vacationHouse);
        assets.add(car);
        assets.add(fancyCar);

        for (Asset asset : assets) {
            System.out.printf("Description: %s%n" +
                    "Date Acquired: %s%n" +
                    "Original Cost: $%.2f%n" +
                    "Value: $%.2f%n",
                    asset.getDescription(), asset.getDateAcquired(), asset.getOriginalCost(), asset.getValue());

            if (asset instanceof House) {
                System.out.printf("Address: %s%n%n", ((House) asset).getAddress());
            } else if (asset instanceof Vehicle) {
                System.out.printf("Make/Model: %s%n" +
                        "Year: %s%n%n", ((Vehicle) asset).getMakeModel(), ((Vehicle) asset).getYear());
            }

        }


    }
}
