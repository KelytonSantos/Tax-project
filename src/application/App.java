package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<TaxPayer> lista = new ArrayList<>();


        System.out.print("Digite o número de contribuintes: ");
        int number_tax = sc.nextInt();

        for(int i = 1; i <= number_tax; i++){
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Pessoa fisica ou juridica (f/j)? ");
            char test = sc.next().charAt(0);

            System.out.print("Nome do contribuinte: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Renda anual do Contribuinte: ");
            double anualIncome = sc.nextDouble();

            if(test == 'f'){
                System.out.print("Digite os gastos com saúde: ");
                double healthExpenditures = sc.nextDouble();

                TaxPayer taxPayer = new Individual(name, anualIncome, healthExpenditures);
                lista.add(taxPayer);
            } else {
                System.out.print("Digite o número de funcionários: ");
                Integer numberOfEmployees = sc.nextInt();

                TaxPayer taxPayer1 = new Company(name, anualIncome, numberOfEmployees);
                lista.add(taxPayer1);
            }
                
        }

        System.out.println();
        System.out.println("Impostos pagos: ");
        for (TaxPayer tz : lista) {
            System.out.println(tz.getName() + ": $ " + String.format("%.2f", tz.tax())); 
        }


        sc.close();
    }
}
