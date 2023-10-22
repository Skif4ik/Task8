package model;

// Для нужд отопления. Стоимость потреблённой энергии прямо пропорциональна
// потреблённой энергии, но используется дешёвый тариф,
// составляющий 1⁄15 от тарифа для обычных клиентов (1 коп.)

public class HeatingConsumers extends EnergyCompany{

    private static double coefficient;

    static {
        coefficient = 1/15.;
    }

    public HeatingConsumers() {
    }

    public HeatingConsumers(String userName, double amount) {
        super(userName, amount);
    }

    public static double getCoefficient() {
        return coefficient;
    }

    public static void setCoefficient(double coefficient) {
        HeatingConsumers.coefficient = coefficient;
    }



    @Override
    public double calculationAmountElectric() {
        double payment = getAmount() * (getTariff() * coefficient);
        return payment;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HeatingConsumers{");
        sb.append("userName='").append(getUserName()).append('\'');
        sb.append(", amount=").append(getAmount());
        sb.append(", calculationAmountElectric=").append(calculationAmountElectric());
        sb.append('}');
        return sb.toString();
    }
}
