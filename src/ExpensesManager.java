import java.util.ArrayList;
import java.util.HashMap;

public class ExpensesManager {
    HashMap<String, ArrayList<Double>> expensesByCategories;

    ExpensesManager() {
        expensesByCategories = new HashMap<>();
    }

    double saveExpense(double moneyBeforeSalary, double expense, String category) {
        moneyBeforeSalary = moneyBeforeSalary - expense;
        System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);

        ArrayList<Double> expensesList;
        if (expensesByCategories.containsKey(category)) {
            expensesList = expensesByCategories.get(category);
            expensesList.add(expense);
        } else {
            expensesList = new ArrayList<>();
            expensesList.add(expense);
            expensesByCategories.put(category, expensesList);
        }
        if (moneyBeforeSalary < 1000) {
            System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
        }
        return moneyBeforeSalary;
    }

    void printAllExpensesByCategories() {
        for (String category : expensesByCategories.keySet()) {
            System.out.println(category);
            ArrayList<Double> expensesList = expensesByCategories.get(category);
            for (Double expense : expensesList) {
                System.out.println(expense);
            }
        }
    }

    double findMaxExpenseInCategory(String category) {
        double maxExpense = 0;
        if (expensesByCategories.containsKey(category)) {
            ArrayList<Double> expensesList = expensesByCategories.get(category);
            for (Double expense : expensesList) {
                if (expense > maxExpense) {
                    maxExpense = expense;
                }
            }
        } else System.out.println("Такой категории пока нет.");
        return maxExpense;
    }

    void removeAllExpenses() {
        expensesByCategories.clear();
        System.out.println("Траты удалены.");
    }

    double getExpensesSum() {
        double result = 0;
        for (ArrayList<Double> expenseList : expensesByCategories.values()) {
            for (Double expense : expenseList) {
                result += expense;
            }
        }
        return result;
    }

    void removeCategory(String category) {
        expensesByCategories.remove(category);
    }

    String getMaxCategoryName() {
        double maxCategorySum = 0;
        String maxCategoryName = "";

        for (String category : expensesByCategories.keySet()) {
            Double sum = 0.0;
            ArrayList<Double> expensesList = expensesByCategories.get(category);
            for (Double expense : expensesList) {
                sum += expense;
            }
            if (sum > maxCategorySum) {
                maxCategorySum = sum;
                maxCategoryName = category;
            }
        }
        return maxCategoryName;
    }
}