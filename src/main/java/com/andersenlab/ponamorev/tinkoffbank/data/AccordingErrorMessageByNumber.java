package com.andersenlab.ponamorev.tinkoffbank.data;

public enum AccordingErrorMessageByNumber {
    PAYER_CODE("Поле неправильно заполнено", "Поле обязательное", "Код плательщика ЖКУ в Москве"),
    PERIOD("Поле заполнено некорректно", "Поле обязательное", "Период оплаты"),
    SUM("Поле заполнено неверно", "Поле обязательное", "Сумма платежа");

    private String invalidValueMessage;
    private String emptyFieldMessage;
    private String fieldName;

    AccordingErrorMessageByNumber(String invalidValueMessage,
                                  String emptyFieldMessage,
                                  String fieldName) {
        this.invalidValueMessage = invalidValueMessage;
        this.emptyFieldMessage = emptyFieldMessage;
        this.fieldName = fieldName;
    }

    public String getInvalidValueMessage() {
        return invalidValueMessage;
    }

    public String getEmptyFieldMessage() {
        return emptyFieldMessage;
    }

    @Override
    public String toString() {
        return fieldName;
    }
}