package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class rajat {

    @RequestMapping("/index")
    public String index(ModelMap map) {
        return "index1";
    }

    @RequestMapping("/login")
    public String processdata(ModelMap map) {
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(ModelMap map) {
        return "logout";
    }

    @RequestMapping("/reg")
    public String news(ModelMap map) {
        return "reg";
    }

    @RequestMapping("/success")
    public String ok(ModelMap map) {
        return "success";
    }

    @RequestMapping("/welcome")
    public String okcab(ModelMap map) {
        return "welcome";
    }

    @RequestMapping("/registration")
    public @ResponseBody
    String viewcab(HttpServletRequest request, @RequestBody String user) {
        try {
            System.out.println("user = " + user);
            user = URLDecoder.decode(user, "UTF-8");
            System.out.println(" user = " + user);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode input = mapper.readTree(user);

            System.out.println(" input " + input);
            System.out.println(" input fName " + input.get("fName").asText());
            String fName = input.get("fName").asText();
            String lName = input.get("lname").asText();
            String email = input.get("email").asText();
            String uname = input.get("uname").asText();
            String pass = input.get("pass").asText();

            /*
            Now as you have all the variables required to register , you can write your registration code here 
            Below code from Registration.jsp
            
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
            "hackathon", "hackathon");
    Statement st = con.createStatement();
    //ResultSet rs;
    int i = st.executeUpdate("insert into members(first_name, last_name, email, uname, pass,account) values ('" + fname + "','" + lname + "','" + email + "','" + user + "','" + pwd + "','" + account + "')");
    ....
            
    Also, there was no valiation here , if user provides same userid , that would become an issue
            
             */
            return "success";
        } catch (JsonProcessingException ex) {
            Logger.getLogger(rajat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(rajat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(rajat.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "error";
    }

    @RequestMapping("/index1")
    public String index1(ModelMap map) {
        return "index1";
    }

    @RequestMapping("/company")
    public String company(ModelMap map) {
        return "company";
    }

}
