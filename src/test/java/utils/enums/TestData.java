package utils.enums;

public enum TestData {
    POST_ID_99(99),
    POST_ID_150(150),
    POST_USER_ID_1(1),
    POST_USER_ID_10(10),
    USER_ID_5(5);

    TestData(Integer value) {
        this.value = value;
    }

    private final Integer value;

    public Integer getValue() {
        return value;
    }
}
