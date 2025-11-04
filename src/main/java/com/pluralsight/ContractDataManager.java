package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {
    public void saveContract(Contract contract) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("contracts.csv", true))) {
            Vehicle v = contract.getVehicleSold();
            StringBuilder sb = new StringBuilder();

            if (contract instanceof SalesContract sc) {
                sb.append("SALE|");
                sb.append(contract.getDate()).append("|");
                sb.append(contract.getCustomerName()).append("|");
                sb.append(contract.getCustomerEmail()).append("|");
                sb.append(v.getVin()).append("|");
                sb.append(v.getYear()).append("|");
                sb.append(v.getMake()).append("|");
                sb.append(v.getModel()).append("|");
                sb.append(v.getVehicleType()).append("|");
                sb.append(v.getColor()).append("|");
                sb.append(v.getOdometer()).append("|");
                sb.append(v.getPrice()).append("|");
                sb.append(sc.getSalesTaxAmount()).append("|");
                sb.append(sc.getRecordingFee()).append("|");
                sb.append(sc.getProcessingFee()).append("|");
                sb.append(sc.getTotalPrice()).append("|");
                sb.append(sc.isWantFinance() ? "YES" : "NO").append("|");
                sb.append(sc.getMonthlyPayment()).append("|");

            }

                if (contract instanceof LeaseContract lc){
                    sb.append("LEASE|");
                    sb.append(contract.getDate()).append("|");
                    sb.append(contract.getCustomerName()).append("|");
                    sb.append(contract.getCustomerEmail()).append("|");
                    sb.append(v.getVin()).append("|");
                    sb.append(v.getYear()).append("|");
                    sb.append(v.getMake()).append("|");
                    sb.append(v.getModel()).append("|");
                    sb.append(v.getVehicleType()).append("|");
                    sb.append(v.getColor()).append("|");
                    sb.append(v.getOdometer()).append("|");
                    sb.append(v.getPrice()).append("|");
                    sb.append(lc.getExpectedEndingValue()).append("|");
                    sb.append(lc.getLeaseFee()).append("|");
                    sb.append(lc.getTotalPrice()).append("|");
                    sb.append(lc.getMonthlyPayment()).append("|");
            }

                bw.write(sb.append("\n").toString());

        } catch (IOException e) {
            System.err.println("Error saving contract file");
        }

    }

}
