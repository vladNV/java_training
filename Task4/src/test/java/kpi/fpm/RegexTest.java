package kpi.fpm;

import org.junit.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static kpi.fpm.controller.RegularExpression.*;
import static org.junit.Assert.*;

public class RegexTest {

    @Test
    public void testName(){
        assertEquals(false, checkRegex("vlad",REGEXP_NAME));
        assertEquals(true, checkRegex("Vlad", REGEXP_NAME));
        assertEquals(false, checkRegex("323928239823", REGEXP_NAME));
        assertEquals(false, checkRegex("VV", REGEXP_NAME));
        assertEquals(false, checkRegex("V", REGEXP_NAME));
    }

    @Test
    public void testLogin(){
        assertEquals(true, checkRegex("d90as789sd", REGEXP_LOGIN));
        assertEquals(false, checkRegex("d90as 789sd", REGEXP_LOGIN));
        assertEquals(false, checkRegex("sdaas(*&&", REGEXP_LOGIN));
    }

    @Test
    public void testMobileUA(){
        assertEquals(true, checkRegex("+380993255594", REGEXP_MOBILE_NUMBER_UA));
        assertEquals(true, checkRegex("380993255594", REGEXP_MOBILE_NUMBER_UA));
        assertEquals(true, checkRegex("0503268575", REGEXP_MOBILE_NUMBER_UA));
        assertEquals(true, checkRegex("+38099-32-55-594", REGEXP_MOBILE_NUMBER_UA));
        assertEquals(true, checkRegex("+38099-325-55-94", REGEXP_MOBILE_NUMBER_UA));
        assertEquals(true, checkRegex("0993268575", REGEXP_MOBILE_NUMBER_UA));
        assertEquals(false, checkRegex("+7878932559", REGEXP_MOBILE_NUMBER_UA));
    }

    @Test
    public void testEmail() {
        assertEquals(true, checkRegex("vlad.nagaev.vn@gmail.com", REGEXP_EMAIL));
        assertEquals(false, checkRegex("VladNagaevVn@gmail.com", REGEXP_EMAIL));
        assertEquals(false, checkRegex("vlad.nagaev.vn@", REGEXP_EMAIL));
        assertEquals(false, checkRegex("vlad.nagaev.vn@dasd", REGEXP_EMAIL));
        assertEquals(false, checkRegex("v*(&(sd", REGEXP_EMAIL));
    }

    @Test
    public void testContactGroup(){
        assertEquals(false,checkRegex("whatislove", REGEXP_CONTACT_GROUP));
        assertEquals(true, checkRegex("Friend", REGEXP_CONTACT_GROUP));
        assertEquals(true, checkRegex("Coworker", REGEXP_CONTACT_GROUP));
        assertEquals(true,checkRegex("Colleague", REGEXP_CONTACT_GROUP));
    }

    @Test
    public void testNumber(){
        assertEquals(true,checkRegex("5", REGEXP_NUMBER));
        assertEquals(false,checkRegex("A", REGEXP_NUMBER));
        assertEquals(false,checkRegex("33433342323332214124", REGEXP_NUMBER));
    }

    @Test
    public void testAddress(){
        assertEquals(false,checkRegex("1", REGEXP_ADDRESS));
        assertEquals(true,checkRegex("Marine Pkwy", REGEXP_ADDRESS));
        assertEquals(true,checkRegex("st. Shevchenko", REGEXP_ADDRESS));
    }

    @Test
    public void testNumHouse(){
        assertEquals(true,checkRegex("1A", REGEXP_NUM_HOUSE));
        assertEquals(true,checkRegex("1/3", REGEXP_NUM_HOUSE));
        assertEquals(true,checkRegex("1/3B", REGEXP_NUM_HOUSE));
        assertEquals(false,checkRegex("Hreshatik 223", REGEXP_NUM_HOUSE));
        assertEquals(true,checkRegex("4a", REGEXP_NUM_HOUSE));
        assertEquals(false,checkRegex("sda", REGEXP_NUM_HOUSE));
        assertEquals(false,checkRegex("31212", REGEXP_NUM_HOUSE));
    }

    private boolean checkRegex(String input, String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }


}
