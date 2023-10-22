import model.*;

public class Main {
    public static void main(String[] args) {

        EnergyCompany[] energyCompanies = {
                new OrdinaryConsumers("GZSU", 280),
                new OrdinaryConsumers("Gomel Mechanical Plant", 325),
                new LimitConsumers("BMZ", 400),
                new LimitConsumers("ZLIN", 240),
                new PreferentialConsumers("Centrolite", 550),
                new PreferentialConsumers("Gomselmash", 750),
                new HeatingConsumers("School №12", 150),
                new HeatingConsumers("GUZ", 220),
        };
        //выводим информацио
        for (EnergyCompany energyCompany : energyCompanies) {
            System.out.println(energyCompany);
        }

        System.out.println();
        System.out.println("Сортировка по количеству потребленной энергии в порядке убывания");
        EnergyCompany.sortByAmountDown(energyCompanies);
        for (EnergyCompany energyCompany : energyCompanies) {
            System.out.println(energyCompany);
        }

        System.out.println();
        System.out.println("Сортировка по сумме оплаты в порядке увеличения");
        EnergyCompany.sortBySummaUpCmp(energyCompanies);
        for (EnergyCompany energyCompany : energyCompanies) {
            System.out.println(energyCompany);
        }

        System.out.println();
        System.out.println("Сумма за потребленную электроэнергию всех потребителей:  " + EnergyCompany.calculationGeneralSum(energyCompanies));
        System.out.println("Сумма льгот: " + EnergyCompany.calculationlimitSum(energyCompanies));
    }
}
