package model;

// С лимитом  – первые 250 единиц энергии клиент получает по цене,
// как для обычных клиентов (15 коп.), а всё, что потреблено сверх 250 единиц,
// оплачивается по тарифу на ⅓ больше (20 коп.)

public class LimitConsumers extends EnergyCompany {

    private static int limit; //250
    private static double coefficient; //20копеек

    static {
        limit = 250;
        coefficient = 4 / 3.; //20коп.
    }

    public LimitConsumers() {
    }

    public LimitConsumers(String userName, double amount) {
        super(userName, amount);
    }

    public static int getLimit() {
        return limit;
    }

    public static void setLimit(int limit) {
        LimitConsumers.limit = limit;
    }

    public static double getCoefficient() {
        return coefficient;
    }

    public static void setCoefficient(double coefficient) {
        LimitConsumers.coefficient = coefficient;
    }

    @Override
    public double calculationAmountElectric() {
        double paymentLimit = limit * getTariff();
        double paymentOverLimit = (getAmount() - limit) * (getTariff() * coefficient);
        double payment = paymentLimit + paymentOverLimit;
        if (getAmount() > limit) {
            return payment;
        } else {
            return getAmount() * getTariff();
        }
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LimitConsumers{");
        sb.append("userName='").append(getUserName()).append('\'');
        sb.append(", amount=").append(getAmount());
        sb.append(", calculationAmountElectric=").append(calculationAmountElectric());
        sb.append('}');
        return sb.toString();
    }
}
