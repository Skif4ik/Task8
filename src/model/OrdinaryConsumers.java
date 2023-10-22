package model;


// Обычные клиенты
// Обычные – стоимость потреблённой энергии прямо пропорциональна потреблённой энергии.
// Одна единица потреблённой энергии стоит 15 коп.
public class OrdinaryConsumers extends EnergyCompany {

    public OrdinaryConsumers() {
    }

    public OrdinaryConsumers(String userName, double amount) {
        super(userName, amount);
    }


    @Override
    public double calculationAmountElectric() {
        double payment = getAmount() * getTariff();
        return payment;   // результат в копейках
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrdinaryConsumers{");
        sb.append("userName='").append(getUserName()).append('\'');
        sb.append(", amount=").append(getAmount());
        sb.append(", calculationAmountElectric=").append(calculationAmountElectric());
        sb.append('}');
        return sb.toString();
    }
}
