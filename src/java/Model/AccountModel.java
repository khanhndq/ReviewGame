package Model;



import MyUtils.DBConnection;
import ObjecInfo.Account;
import ObjecInfo.CategoryException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vy
 */
public class AccountModel {

     
    private Connection con;
    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;
    private String str;

    /**
     * Account model
     *
     * @throws SQLException
     */
    public AccountModel() throws SQLException {
        try {
            con = DBConnection.getConnection();
            st = con.createStatement();
            pst = null;
            rs = null;
            str = "";
        } catch (Exception e) {
            throw new SQLException("PLEASE CONNECT TO DATABASE BEFORE START");
        }
    }

    /**
     * Load account
     *
     * @return
     * @throws SQLException
     */
    public ArrayList<Account> loadAccount() throws SQLException {
        ArrayList<Account> Accounts = new ArrayList<Account>();
        try {
            con = DBConnection.getConnection();
            st = con.createStatement();
            str = "SELECT * FROM `account`";
            rs = st.executeQuery(str);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int ID_Account = rs.getInt("ID_Account");
                    int ID_TypeAccount = rs.getInt("ID_TypeAccount");
                    String UserName = rs.getString("UserName");
                    String Password = rs.getString("Password");
                    int Gender = rs.getInt("Gender");
                    String Email = rs.getString("Email");
                    String FullName = rs.getString("FullName");
                    String PhoneNumber = rs.getString("PhoneNumber");
                    int Status = rs.getInt("Status");
                    if (Status != 0) {
                        Accounts.add(new Account(ID_Account, ID_TypeAccount, UserName, Password, Gender, Email, FullName, PhoneNumber, Status));
                    }
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Can't load games");
        }
        return Accounts;
    }

    /**
     * Insert account
     *
     * @param ID_TypeAccount
     * @param UserName
     * @param Password
     * @param Gender
     * @param Email
     * @param FullName
     * @param PhoneNumber
     * @throws SQLException
     */
    public void insertAccount(int ID_TypeAccount, String UserName,
            String Password, int Gender, String Email, String FullName, String PhoneNumber) throws SQLException {
        try {
            str = "INSERT INTO `account`(`ID_TypeAccount`, `UserName`, `Password`, "
                    + "`Gender`, `Email`, `FullName`, `PhoneNumber`, `Status`) "
                    + "VALUES (?,?,?,?,?,?,?,1)";
            pst = con.prepareStatement(str, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, ID_TypeAccount);
            pst.setString(2, UserName);
            pst.setString(3, Password);
            pst.setInt(4, Gender);
            pst.setString(5, Email);
            pst.setString(6, FullName);
            pst.setString(7, PhoneNumber);
            pst.executeUpdate();
            rs = pst.getGeneratedKeys();
            rs.next();
        } catch (SQLException e) {
            throw new SQLException("Can't insert account");
        }
    }

    /**
     * Update account
     *
     * @param ID_Account
     * @param ID_TypeAccount
     * @param UserName
     * @param Password
     * @param Gender
     * @param Email
     * @param FullName
     * @param PhoneNumber
     * @return
     * @throws SQLException
     * @throws CategoryException
     */
    public boolean updateAccount(int ID_Account, int ID_TypeAccount, String UserName,
            String Password, int Gender, String Email, String FullName, String PhoneNumber) throws SQLException, CategoryException {
        try {
            str = "UPDATE `account` SET `ID_TypeAccount`=?,"
                    + "`UserName`=?,`Password`=?,`Gender`=?,`Email`=?,"
                    + "`FullName`=?,`PhoneNumber`=? WHERE `ID_Account`=?";
            pst = con.prepareStatement(str);
            pst.setInt(1, ID_TypeAccount);
            pst.setString(2, UserName);
            pst.setString(3, Password);
            pst.setInt(4, Gender);
            pst.setString(5, Email);
            pst.setString(6, FullName);
            pst.setString(7, PhoneNumber);
            pst.setInt(8, ID_Account);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new SQLException("Can't update game");
        }
    }

    /**
     * Delete account
     *
     * @param ID_Account
     * @return
     * @throws SQLException
     */
    public boolean deleteAccount(int ID_Account) throws SQLException {
        try {
            str = "UPDATE `account` SET `Status`=0 WHERE `ID_Account`=?";
            pst = con.prepareStatement(str);
            pst.setInt(1, ID_Account);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new SQLException("Can't delete game");
        }
    }
    
    public String getNameAccount(String username) throws SQLException {
        String Name = "";
        try {
            
            con = DBConnection.getConnection();
            st = con.createStatement();
            str = "SELECT * FROM `account` where `UserName` = '" + username + "'";
            rs = st.executeQuery(str);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    Name = rs.getString("FullName");
                }
            }
            
        } catch (SQLException e) {
            throw new SQLException("Can't load games");
        }
        return Name;
    }
    
    public int getAccountIDByName(String username) throws SQLException {
        int Name = 1;
        try {
            
            con = DBConnection.getConnection();
            st = con.createStatement();
            str = "SELECT * FROM `account` where `UserName` = '" + username + "'";
            rs = st.executeQuery(str);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    Name = rs.getInt("ID_Account");
                }
            }
            
        } catch (SQLException e) {
            throw new SQLException("Can't load games");
        }
        return Name;
    }

    
    public String getNameAccountByID(int id) throws SQLException {
        String Name = "";
        try {
            
            con = DBConnection.getConnection();
            st = con.createStatement();
            str = "SELECT * FROM `account` where `ID_Account` = '" + id + "'";
            rs = st.executeQuery(str);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    Name = rs.getString("FullName");
                }
            }
            
        } catch (SQLException e) {
            throw new SQLException("Can't load games");
        }
        return Name;
    }
    
    public boolean checkAccountExits(String username){
        
        try {
            ArrayList<Account> listAcc = loadAccount();
            for (Account account : listAcc) {
                 if(username.equals(account.getUserName())){
                     return true;
                 }
            }     
        } catch (SQLException ex) {
            Logger.getLogger(AccountModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ArrayList<Account> loadAuthor() throws SQLException {
        ArrayList<Account> Accounts = new ArrayList<Account>();
        try {
            con = DBConnection.getConnection();
            st = con.createStatement();
            str = "SELECT * FROM `account`";
            rs = st.executeQuery(str);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int ID_Account = rs.getInt("ID_Account");
                    int ID_TypeAccount = rs.getInt("ID_TypeAccount");
                    String UserName = rs.getString("UserName");
                    String Password = rs.getString("Password");
                    int Gender = rs.getInt("Gender");
                    String Email = rs.getString("Email");
                    String FullName = rs.getString("FullName");
                    String PhoneNumber = rs.getString("PhoneNumber");
                    int Status = rs.getInt("Status");
                    if (Status != 0) {
                        if (ID_TypeAccount == 0 || ID_TypeAccount == 1) {
                            Accounts.add(new Account(ID_Account, ID_TypeAccount, UserName, Password, Gender, Email, FullName, PhoneNumber, Status));
                        }
                    }
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Can't load games");
        }
        return Accounts;
    }
    
    public static void main(String[] args) throws SQLException {
        AccountModel am = new AccountModel();
        ArrayList<Account> listAcc = am.loadAccount();
        
        System.out.println(am.checkAccountExits("khanh1234"));
        
//        for (Account account : listAcc) {
//            System.out.println(account.getFullName());
//        }
    }
}
