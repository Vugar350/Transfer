package ru.Netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.Netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage   {
    private SelenideElement refill = $("data-test-id=amount");
    private SelenideElement from = $("data-test-id=from");
    ;

    public DashboardPage makeTransfer(String amount, DataHelper.CardInfo cardInfo) {
        refill.setValue(amount);
        from.setValue(cardInfo.getId());
        $("data-test-id=action-transfer").click();
        return  new DashboardPage();
    }

}
