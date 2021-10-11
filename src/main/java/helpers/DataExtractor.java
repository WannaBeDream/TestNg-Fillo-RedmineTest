package helpers;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.util.ArrayList;

public class DataExtractor {
    public ArrayList<String> userData = new ArrayList<String>();
    static String xPath = new File("xlsx/Test.xlsx").getAbsolutePath();

    public DataExtractor() {

    }

    public ArrayList<String> getDataForSimpleCheck(int idRow) {
        try {
            Fillo fill = new Fillo();
            Connection conn = fill.getConnection(xPath);
            Recordset rs = conn.executeQuery("Select * from Sheet1").where("id=" + idRow);
            while (rs.next()) {
                userData.add(rs.getField("login"));
                userData.add(rs.getField("email"));
                userData.add(rs.getField("password"));
                userData.add(rs.getField("passwordConfirm"));
                userData.add(rs.getField("firstName"));
                userData.add(rs.getField("lastName"));
                userData.add(rs.getField("IrcNick"));
                userData.add(rs.getField("searchValue"));
            }
            rs.close();
            conn.close();
        } catch (FilloException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userData;
    }

    public void createResultStyleSheet() {
        try {
            Fillo fillo = new Fillo();
            Connection connection = fillo.getConnection(xPath);
            connection.createTable("Result", new String[]{"inputName", "isPassed"});
            connection.close();
        } catch (FilloException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertResult(String name, String isPassed) {

        String query = "INSERT INTO Result(inputName,isPassed) VALUES('" + name + "','" + isPassed + "')";
        System.out.println(">>>>> " + query);
        try {

            Fillo fillo = new Fillo();
            Connection connection = fillo.getConnection(xPath);
            connection.executeUpdate(query);
            connection.close();
        } catch (FilloException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @DataProvider(name = "userData")
    static Object[][] userFormData() {
        return getDataForCheck();
    }

    public static Object[][] getDataForCheck() {
        try {
            Fillo fill = new Fillo();
            Connection conn = fill.getConnection(xPath);
            Object[][] userDataObj = null;
            Recordset rs = conn.executeQuery("Select * from Sheet1");
            userDataObj = new Object[rs.getCount()][9];
            int i = 0;
            while (rs.next()) {
                userDataObj[i][0] = rs.getField("id");
                userDataObj[i][1] = rs.getField("login");
                userDataObj[i][2] = rs.getField("email");
                userDataObj[i][3] = rs.getField("password");
                userDataObj[i][4] = rs.getField("passwordConfirm");
                userDataObj[i][5] = rs.getField("firstName");
                userDataObj[i][6] = rs.getField("lastName");
                userDataObj[i][7] = rs.getField("ircNick");
                userDataObj[i][8] = rs.getField("searchValue");
                i++;
            }
            rs.close();
            conn.close();

            return userDataObj;
        } catch (FilloException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}