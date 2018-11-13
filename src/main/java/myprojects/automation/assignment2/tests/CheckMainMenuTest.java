package myprojects.automation.assignment2.tests;

import myprojects.automation.assignment2.BaseScript;
import org.testng.annotations.Test;

public class CheckMainMenuTest extends BaseScript{

    /**
     * Скрипт Б. Проверка работоспособности главного меню Админ панели
     */
    @Test
    public void scriptB(){

        openLoginPage()
                .loginAsAdmin("webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw")
                .openEachItemOfMenuAndPrintItsTitle();
    }
}
