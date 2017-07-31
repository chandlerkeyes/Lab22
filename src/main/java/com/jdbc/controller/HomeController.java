package com.jdbc.controller;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.servlet.ModelAndView;

        import java.sql.*;
        import java.util.ArrayList;

@Controller
public class HomeController {
    //this calls the method
    @RequestMapping("/")
    public String dbReturn(Model model) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/CoffeeShopDB";
        String userName = "chandlerkeyes";
        String password = "brokk123";
        String query = "SELECT * FROM Items";

        //creating connection
        Connection con = DriverManager.getConnection(url,userName, password);
        //create statement
        Statement st = con.createStatement();
        //retrieve results,The object used for executing a static SQL
        // statement and returning the results it produces.
        ResultSet rs = st.executeQuery(query);
        ArrayList<String> list = new ArrayList<String>();

        // step 6
        while (rs.next()) {
            String Name = rs.getString(1);
            String Description = rs.getString(2);
            int Quantity = rs.getInt(3);
            double Price = rs.getDouble(4);

            // populate data into the arraylist
            list.add(Name + " " + Description + " " + Quantity + " " + Price);
        }
        model.addAttribute("dbResult", list);

        rs.close();
        con.close();
        return "jdbc";
    }
    public static void insert(String username, String password) throws SQLException {
        String sql = "INSERT INTO users(username,password) VALUES(?,?)";

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CoffeeShopDB",
                "chandlerkeyes", "brokk123");

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
    }
    @RequestMapping("/function")
    public String functionClass(Model model, @RequestParam("username") String username,
                                @RequestParam("password") String password) throws ClassNotFoundException, SQLException {
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        HomeController.insert(username,password);

        return "function";
    }
    @RequestMapping("/registration")
    public ModelAndView registrationPage(){
        return new ModelAndView("registration","register", "register");
    }

}
