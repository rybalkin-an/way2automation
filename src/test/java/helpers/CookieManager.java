package helpers;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class CookieManager {

    String fileName = "Cookies.data";
    File file;

    public CookieManager() {
        file = new File(fileName);
    }

    /**
     * Method gets Cookies set from the WebDriver
     * @return Cookies set
     */
    public Set<Cookie> getCookiesFromWebDriver() {
        return WebDriverRunner.getWebDriver().manage().getCookies();
    }

    /**
     * Method saves Cookies to a file
     * @param cookieSet set of Cookies from the WebDriver
     */
    public void writeToFile(Set<Cookie> cookieSet) {
        try (BufferedWriter Bw = new BufferedWriter(new FileWriter(file))) {
            for(Cookie cookie : cookieSet)
            {
                Bw.write((
                        cookie.getName() + ";" +
                        cookie.getValue() + ";" +
                        cookie.getDomain() + ";" +
                        cookie.getPath() + ";" +
                        cookie.isSecure()));
                Bw.newLine();
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Method gets saved cookies from a file
     * @return cookies set for the WebDriver
     * if something went wrong return an empty set
     */
    public Set<Cookie> getCookiesFromFile() {
        Set<Cookie> cookies = new HashSet<>();
        String strline;
        Date date = getDate();
        try (BufferedReader Br = new BufferedReader(new FileReader(file))) {
            while((strline = Br.readLine()) != null) {
                StringTokenizer token = new StringTokenizer(strline,";");
                while(token.hasMoreTokens()){
                    String name = token.nextToken();
                    String value = token.nextToken();
                    String domain = token.nextToken();
                    String path = token.nextToken();
                    Date expiry = new SimpleDateFormat("yyyyMMdd").parse(date.toString());
                    boolean isSecure = Boolean.parseBoolean(token.nextToken());
                    Cookie cookie = new Cookie(name, value, domain, path, expiry, isSecure);
                    cookies.add(cookie);
                }
            } return cookies;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Collections.emptySet();
    }

    /**
     * @return current date plus one year
     */
    private Date getDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);
        return calendar.getTime();
    }
}
