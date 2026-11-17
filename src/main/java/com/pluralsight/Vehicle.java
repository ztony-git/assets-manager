package com.pluralsight;

import java.math.BigDecimal;
import java.time.Year;

public class Vehicle extends Asset {
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, BigDecimal originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public BigDecimal getValue() {
        BigDecimal value = getOriginalCost();
        int age = Year.now().getValue() - year;

        if (age <= 3) {
            BigDecimal reduction = new BigDecimal("1.00").subtract(new BigDecimal("0.03").multiply(BigDecimal.valueOf(age)));
            value = value.multiply(reduction);
        } else if (age <= 6) {
            BigDecimal reduction = new BigDecimal("1.00").subtract(new BigDecimal("0.06").multiply(BigDecimal.valueOf(age)));
            value = value.multiply(reduction);
        } else if (age <= 10) {
            BigDecimal reduction = new BigDecimal("1.00").subtract(new BigDecimal("0.08").multiply(BigDecimal.valueOf(age)));
            value = value.multiply(reduction);
        } else {
            value = new BigDecimal("1000.00");
        }

        if (makeModel.equalsIgnoreCase("Honda") || makeModel.equalsIgnoreCase("Toyota")) {
            return value;
        }

        if (odometer > 100_000) {
            value = value.multiply(new BigDecimal(".75"));
        }

        return value;
    }
}
