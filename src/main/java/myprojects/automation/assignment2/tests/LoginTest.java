package myprojects.automation.assignment2.tests;

import myprojects.automation.assignment2.BaseScript;
import org.testng.annotations.Test;

public class LoginTest extends BaseScript {

    //    public static void main(String[] args) throws InterruptedException {
    // - doesn't seem Ok to me running tests from 'main()' method. OR does it ??

    /**
     * Скрипт А. Логин в Админ панель
     */
    @Test
    public void scriptA(){

        openLoginPage()
                .loginAsAdmin("webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw")
                .logout();
    }
}

