/**
Main class that does all of the calculations required by this project.
 */
public class Calculator {
    /**
     * The amount of people that will be involved in this system
     */
    public int amountOfPeopele;
    /**
     * The total amount each person owes
     */
    public double[] totals;

    /**
     *  Constructor for the calculator, sets the number of people along with a new array for amounts
     * @param peopleNum number people involved in this system
     */
    public Calculator (int peopleNum){
        amountOfPeopele = peopleNum;
        totals = new double[peopleNum];
    }


    /**
     * Sets the given user as having paid a certain amount of money
     * @param user The user that paid for a transaction
     * @param amount The amount they paid
     */
    public void owedAmount(int user, double amount) {
        totals[user] = totals[user] -= amount;
    }

    /**
     * Sets the given user to owe a certain amount of money
     * @param user The user that did not pay for a transaction
     * @param amount The amount they owe
     */
    public void oweAmont(int user, double amount){
        totals[user] = totals[user] += amount;
    }

    /**
     * Handles a single transaction
     * @param userThatPaid The user that paid for the given transaction
     * @param amount The amount the user paid for the transaction
     */
    public void transaction(int userThatPaid, double amount) {
        double amountOtherUsersOwe = amount / (double) amountOfPeopele;
        owedAmount(userThatPaid, amount);
        for (int i = 0; i < amountOfPeopele && i != userThatPaid; i++) {
            oweAmont(i, amountOtherUsersOwe);
        }
    }

}
