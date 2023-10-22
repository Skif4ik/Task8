package model;

public abstract class EnergyCompany {
    private static int tariff;
    private String userName;
    private double amount;

    static {
        tariff = 15;
    }

    public EnergyCompany() {
    }

    public EnergyCompany(String userName, double amount) {
        this.userName = userName;
        this.amount = amount;
    }

    public static int getTariff() {
        return tariff;
    }

    public static void setTariff(int tariff) {
        EnergyCompany.tariff = tariff;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // абстрактный метод расчета за электричество
    public abstract double calculationAmountElectric();


    // Сортировка по убыванию потребленной энергии
    public static void sortByAmountDown(EnergyCompany[] energyCompanies) {
        EnergyCompany temp = null;
        for (int i = 0; i < energyCompanies.length; i++) {
            for (int j = 0; j < energyCompanies.length - 1; j++) {
                if (energyCompanies[j].getAmount() < energyCompanies[i].getAmount()) {
                    temp = energyCompanies[j];
                    energyCompanies[j] = energyCompanies[i];
                    energyCompanies[i] = temp;
                }
            }
        }
    }


    // Сортировка по величине оплаты
    public static void sortBySummaUpCmp(EnergyCompany[] energyCompanies) {
        EnergyCompany temp = null;
        for (int i = 0; i < energyCompanies.length; i++) {
            for (int j = 0; j < energyCompanies.length - 1 - i; j++) {
                if (energyCompanies[j].calculationAmountElectric() > energyCompanies[j + 1].calculationAmountElectric()) {
                    temp = energyCompanies[j];
                    energyCompanies[j] = energyCompanies[j + 1];
                    energyCompanies[j + 1] = temp;
                }
            }
        }
    }


    // общая сумма всех потребителей
    public static double calculationGeneralSum(EnergyCompany[] energyCompanies) {
        double sum = 0.0;
        for (EnergyCompany employee : energyCompanies) {
            sum += employee.calculationAmountElectric();
        }
        return sum;
    }


    // Общий размер льгот
    public static double calculationlimitSum(EnergyCompany[] energyCompanies) {
        double sum = 0.0;
        double sumBonus = 0.0;
        for (EnergyCompany employee : energyCompanies) {
            sum = sum + (employee.getAmount() * getTariff());
        }
        sumBonus = sum - calculationGeneralSum(energyCompanies);
        return sumBonus;
    }

}
