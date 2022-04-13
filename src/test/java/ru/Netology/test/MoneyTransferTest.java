package ru.Netology.test;

import org.junit.jupiter.api.Test;
import ru.Netology.data.DataHelper;
import ru.Netology.page.CartPage;
import ru.Netology.page.DashboardPage;
import ru.Netology.page.LoginPageV1;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyTransferTest {
    @Test
    void shouldTransferMoneyBetweenOwnCardsV1() {
        open("http://localhost:9999");
        var loginPage = new LoginPageV1();
//    var loginPage = open("http://localhost:9999", LoginPageV1.class);
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        var firstCardInfo = DataHelper.getFirstCardInfo();
        var secondCardInfo = DataHelper.getSecondCardInfo();
        int amount = 1000;
        var expectedBalanceFirstCard = dashboardPage.getCardBalance(firstCardInfo) - amount;
        var expectedBalanceSecondCard = dashboardPage.getCardBalance(secondCardInfo) + amount;
        var transferPage = dashboardPage.selectCardToTransfer(secondCardInfo);
        dashboardPage = transferPage.makeTransfer(String.valueOf(amount), firstCardInfo);
        var actualBalanceFirstCard = dashboardPage.getCardBalance(firstCardInfo);
        var actualBalanceSecondCard = dashboardPage.getCardBalance(secondCardInfo);
        assertEquals(expectedBalanceFirstCard, actualBalanceFirstCard);
        assertEquals(expectedBalanceSecondCard, actualBalanceSecondCard);
    }


        @Test
        void shouldTransferMoneyBetweenOwnCardsV2() {
            open("http://localhost:9999");
            var loginPage = new LoginPageV1();
//    var loginPage = open("http://localhost:9999", LoginPageV1.class);
            var authInfo = DataHelper.getAuthInfo();
            var verificationPage = loginPage.validLogin(authInfo);
            var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
            var dashboardPage = verificationPage.validVerify(verificationCode);
            var firstCardInfo =DataHelper.getFirstCardInfo();
            var secondCardInfo=DataHelper.getSecondCardInfo();
            int amount = 1000;
            var expectedBalanceFirstCard = dashboardPage.getCardBalance(firstCardInfo) + amount;
            var expectedBalanceSecondCard = dashboardPage.getCardBalance(secondCardInfo) - amount;
            var transferPage = dashboardPage.selectCardToTransfer(firstCardInfo);
            dashboardPage = transferPage.makeTransfer(String.valueOf(amount), secondCardInfo);
            var actualBalanceFirstCard = dashboardPage.getCardBalance(firstCardInfo);
            var actualBalanceSecondCard = dashboardPage.getCardBalance(secondCardInfo);
            assertEquals(expectedBalanceFirstCard, actualBalanceFirstCard);
            assertEquals(expectedBalanceSecondCard, actualBalanceSecondCard);





    }
}
