import java.sql.*;

public class Transaction_Handling {

    public static void transfer(
            Connection con,
            int fromAcc,
            int toAcc,
            double amount) {

        try {

            con.setAutoCommit(false);

            PreparedStatement debit =
                    con.prepareStatement(
                            "UPDATE accounts SET balance=balance-? WHERE id=?");

            PreparedStatement credit =
                    con.prepareStatement(
                            "UPDATE accounts SET balance=balance+? WHERE id=?");

            debit.setDouble(1, amount);
            debit.setInt(2, fromAcc);
            debit.executeUpdate();

            credit.setDouble(1, amount);
            credit.setInt(2, toAcc);
            credit.executeUpdate();

            con.commit();

            System.out.println("Transfer Successful");

        } catch (Exception e) {

            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            System.out.println("Transfer Failed");
        }
    }
}