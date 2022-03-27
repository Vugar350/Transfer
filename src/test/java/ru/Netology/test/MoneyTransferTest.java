package ru.Netology.test;

import org.junit.jupiter.api.Test;
import ru.Netology.data.DataHelper;
import ru.Netology.page.DashboardPage;
import ru.Netology.page.LoginPageV1;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class MoneyTransferTest {
    @Test
    void shouldTransferMoneyBetweenOwnCardsV1() {
        open("http://localhost:9999");
        DashboardPage dashboardPage=new DashboardPage();
        var loginPage = new LoginPageV1();
//    var loginPage = open("http://localhost:9999", LoginPageV1.class);
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        dashboardPage.getCardBalance();


    }
}