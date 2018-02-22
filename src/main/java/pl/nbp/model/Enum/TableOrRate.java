package pl.nbp.model.Enum;

public enum TableOrRate {
    tables("tablica kursów"),
    rates("kurs waluty");

    private String tableOrRate;

    private TableOrRate(String tableOrRate) {
        this.tableOrRate = tableOrRate;
    }

    public String getTableOrRate() {
        return tableOrRate;
    }

//    public static TableOrRate fromValue(String s) {
//        for (TableOrRate type : values()) {
//            if (type.getTableOrRate().equals(s)) {
//                return type;
//            }
//        }
//        return null;
//    }
}
