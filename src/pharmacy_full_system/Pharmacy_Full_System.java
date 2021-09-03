package pharmacy_full_system;
// 08/29/2020
import GUI.Login;
 /*
    1. Update The Quantity Also (ModifyProducts) ☺Finished
    2. Delete Expired Products (ExpiredProducts) ☺Finished
    3. Add Customer_Name And Cust_ID To Payment System (Cash/Not Cash) ☺ (Cust_name must be entered if didn't pay cash) ☺Finished
    4. Test each process and function in system. ☺Finished
    5. Remove items form old receipt and modify payment in old receipt ☺Finished
    6. Quantities of items
*/
public class Pharmacy_Full_System 
{
    public static void main(String[] args) 
    {
        Login login = new Login();
        login.setVisible(true);
    }
}
