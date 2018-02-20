package com.andersenlab.ponamorev.tinkoffbank.data;

public enum AccordingErrorMessageByNumber {
    PAYER_CODE("Поле неправильно заполнено", "Поле обязательное", "Код плательщика ЖКУ в Москве",
            ".ui-form__row_text.ui-form__row_default-error-view-visible"),
    PERIOD("Поле заполнено некорректно", "Поле обязательное", "Период оплаты",
            ".ui-form__row_date"),
    SUM("Поле заполнено неверно", "Поле обязательное", "Сумма платежа",
            ".ui-form__row_combination");

    private String invalidValueMessage;
    private String emptyFieldMessage;
    private String fieldName;
    private String cssParent;

    AccordingErrorMessageByNumber(String invalidValueMessage,
                                  String emptyFieldMessage,
                                  String fieldName,
                                  String cssParent) {
        this.invalidValueMessage = invalidValueMessage;
        this.emptyFieldMessage = emptyFieldMessage;
        this.fieldName = fieldName;
        this.cssParent = cssParent;
    }

    public String getCssParent() {
        return cssParent;
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