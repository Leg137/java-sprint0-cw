public class Expense {

    private double value;
    private int transaction;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Integer getTransaction() {
        return transaction;
    }

    public void setTransaction(Integer transaction) {
        this.transaction = transaction;
    }

    /* в конструкторе мы сгенерируем уникальный номер транзакции от 0 до 1 000 000
	с помощью функции Math.random(); */
    public Expense(double value) {
        this.value = value;
        // реализуйте создание уникального номера транзакции
        double d = Math.random() * 1_000_000;
        this.transaction = (int) d;
    }
}