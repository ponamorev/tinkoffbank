package com.andersenlab.ponamorev.tinkoffbank.data;

public enum AccordingErrorMessageByNumber {
    PAYER_CODE("Поле неправильно заполнено", "Поле обязательное", "Код плательщика ЖКУ в Москве", 1),
    PERIOD("Поле заполнено некорректно", "Поле обязательное", "Период оплаты", 2),
    SUM("Поле заполнено неверно", "Поле обязательное", "Сумма платежа", 3);

    private String invalidValueMessage;
    private String emptyFieldMessage;
    private String fieldName;
    private int number;

    AccordingErrorMessageByNumber(String invalidValueMessage,
                                  String emptyFieldMessage,
                                  String fieldName,
                                  int number) {
        this.invalidValueMessage = invalidValueMessage;
        this.emptyFieldMessage = emptyFieldMessage;
        this.fieldName = fieldName;
        this.number = number;
    }

    public int getNumber() {
        return number;
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