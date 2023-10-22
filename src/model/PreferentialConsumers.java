package model;


// Льготные – стоимость потреблённой энергии прямо пропорциональна
// потреблённой энергии, но применяется льготный тариф, который составляет ⅔ от тарифа
// для обычных клиентов (10 коп.)

public class PreferentialConsumers extends EnergyCompany {

    private static double coefficient;

    static {
        coefficient = 2/3.; //(10 коп.)
    }

    public PreferentialConsumers() {
    }

    public PreferentialConsumers(String userName, double amount) {
        super(userName, amount);
    }

    public static double getCoefficient() {
        return coefficient;
    }

    public static void setCoefficient(double coefficient) {
        PreferentialConsumers.coefficient = coefficient;
    }

    @Override
    public double calculationAmountElectric() {
        double payment = getAmount() * (getTariff() * coefficient);
        return payment;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PreferentialConsumers{");
        sb.append("userName='").append(getUserName()).append('\'');
        sb.append(", amount=").append(getAmount());
        sb.append(", calculationAmountElectric=").append(calculationAmountElectric());
        sb.append('}');
        return sb.toString();
    }
}
