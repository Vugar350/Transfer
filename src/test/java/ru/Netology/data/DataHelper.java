package ru.Netology.data;

import lombok.Value;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getOtherAuthInfo(AuthInfo original) {
        return new AuthInfo("petya", "123qwerty");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    @Value
    public static class CardInfo {
        private String id;
        private String balance;
    }

    public static CardInfo getFirstCardInfo(CardInfo cardInfo) {
        return new CardInfo("5559 0000 0000 0001", "10 000");
    }

    public static CardInfo getSecondCardInfo(CardInfo cardInfo) {
        return new CardInfo("5559 0000 0000 0002", "10 000");
    }
}