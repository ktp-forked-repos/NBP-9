package pl.nbp.model;

public enum CurrencyTypeInTableC {
    USD("dolar amerykański"),
    AUD("dolar australijski"),
    CAD("dolar kanadyjski"),
    EUR("euro"),
    HUF("forint (Węgry)"),
    CHF("frank szwajcarski"),
    JPY("jen (Japonia)"),
    CZK("korona czeska"),
    DKK("korona duńska"),
    NOK("korona norweska"),
    SEK("korona szwedzka"),
    XDR("SDR (MFW)");

    private String currencyName;

    private CurrencyTypeInTableC(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyType() {
        return currencyName;
    }

    public static CurrencyTypeInTableC fromValue(String s) {
        for (CurrencyTypeInTableC type : values()) {
            if (type.getCurrencyType().equals(s)) {
                return type;
            }
        }
        return null;
    }
}
