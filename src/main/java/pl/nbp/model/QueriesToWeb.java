package pl.nbp.model;

import pl.nbp.model.Enum.*;

import java.beans.beancontext.BeanContext;

public class QueriesToWeb {

    //    private TableOrRate tableOrRate;
//    private NameTable nameTable;
//    private int topCount;
//    private CurrencyTypeInTableA tableA;
//    private CurrencyTypeInTableB tableB;
//    private CurrencyTypeInTableC tableC;
//    private String date;
//    private String startDate;
//    private String endDate;
    private static final String BEGIN_NAME_URL = "http://api.nbp.pl/api/exchangerates/";
    private static final String COMMA_DELIMITER = "/";

//
//
//    public QueriesToWeb(QueriesToWebBuilder queriesToWebBuilder) {
//        this.tableOrRate = queriesToWebBuilder.tableOrRate;
//        this.nameTable = queriesToWebBuilder.nameTable;
//        this.topCount = queriesToWebBuilder.topCount;
//        this.tableA = queriesToWebBuilder.tableA;
//        this.tableB = queriesToWebBuilder.tableB;
//        this.tableC = queriesToWebBuilder.tableC;
//        this.date = queriesToWebBuilder.date;
//        this.startDate = queriesToWebBuilder.startDate;
//        this.endDate = queriesToWebBuilder.endDate;
//    }

    public static String currencyTable(TableOrRate tableOrRate, NameTable nameTable) {
        StringBuilder stringBuilder = new StringBuilder(BEGIN_NAME_URL);
        stringBuilder.append(tableOrRate);
        stringBuilder.append(COMMA_DELIMITER);
        stringBuilder.append(nameTable);
        stringBuilder.append(COMMA_DELIMITER);
        return stringBuilder.toString();
    }

    public static String seriesOfLastCountCurrencyTable(TableOrRate tableOrRate, NameTable nameTable, int topCount) {
        StringBuilder stringBuilder = new StringBuilder(BEGIN_NAME_URL);
        stringBuilder.append(tableOrRate);
        stringBuilder.append(COMMA_DELIMITER);
        stringBuilder.append(nameTable);
        stringBuilder.append(COMMA_DELIMITER);
        stringBuilder.append("last");
        stringBuilder.append(COMMA_DELIMITER);
        stringBuilder.append(topCount);
        stringBuilder.append(COMMA_DELIMITER);
        return stringBuilder.toString();
    }

    public static String currencyTableWithDate(TableOrRate tableOrRate, NameTable nameTable, String date) {
        StringBuilder stringBuilder = new StringBuilder(BEGIN_NAME_URL);
        stringBuilder.append(tableOrRate);
        stringBuilder.append(COMMA_DELIMITER);
        stringBuilder.append(nameTable);
        stringBuilder.append(COMMA_DELIMITER);
        stringBuilder.append(date);
        stringBuilder.append(COMMA_DELIMITER);
        return stringBuilder.toString();
    }

    public static String currencyTableFromDateRange(TableOrRate tableOrRate, NameTable nameTable,
                                                    String startDate, String endDate) {

        StringBuilder stringBuilder = new StringBuilder(BEGIN_NAME_URL);
        stringBuilder.append(tableOrRate);
        stringBuilder.append(COMMA_DELIMITER);
        stringBuilder.append(nameTable);
        stringBuilder.append(COMMA_DELIMITER);
        stringBuilder.append(startDate);
        stringBuilder.append(COMMA_DELIMITER);
        stringBuilder.append(endDate);
        stringBuilder.append(COMMA_DELIMITER);
        return stringBuilder.toString();
    }

    public static String exchangeRate(TableOrRate tableOrRate, NameTable nameTable, CurrencyAllType currencyAllType) {
        StringBuilder stringBuilder = new StringBuilder(BEGIN_NAME_URL);
        stringBuilder.append(tableOrRate);
        stringBuilder.append(COMMA_DELIMITER);
        stringBuilder.append(nameTable);
        stringBuilder.append(COMMA_DELIMITER);
//        if (nameTable.equals("A")) {
//
//        }
        return stringBuilder.toString();
    }

//
//    public static class QueriesToWebBuilder {
//        private TableOrRate tableOrRate;
//        private NameTable nameTable;
//        private int topCount;
//        private CurrencyTypeInTableA tableA;
//        private CurrencyTypeInTableB tableB;
//        private CurrencyTypeInTableC tableC;
//        private String date;
//        private String startDate;
//        private String endDate;
//
//        public QueriesToWebBuilder tableOrRate(TableOrRate tableOrRate) {
//            this.tableOrRate = tableOrRate;
//            return this;
//        }
//
//        public QueriesToWebBuilder nameTable(NameTable nameTable) {
//            this.nameTable = nameTable;
//            return this;
//        }
//
//        public QueriesToWebBuilder topCount(int topCount) {
//            this.topCount = topCount;
//            return this;
//        }
//
//        public QueriesToWebBuilder tableA(CurrencyTypeInTableA tableA) {
//            this.tableA = tableA;
//            return this;
//        }
//
//        public QueriesToWebBuilder tableB(CurrencyTypeInTableB tableB) {
//            this.tableB = tableB;
//            return this;
//        }
//
//        public QueriesToWebBuilder tableC(CurrencyTypeInTableC tableC) {
//            this.tableC = tableC;
//            return this;
//        }
//
//        public QueriesToWebBuilder date(String date) {
//            this.date = date;
//            return this;
//        }
//
//        public QueriesToWebBuilder startDate(String startDate) {
//            this.startDate = startDate;
//            return this;
//        }
//
//        public QueriesToWebBuilder endDate(String endDate) {
//            this.endDate = endDate;
//            return this;
//        }
//
//        public QueriesToWeb build(){
//            QueriesToWeb queriesToWeb = new QueriesToWeb(this);
//            return queriesToWeb;
//        }
//    }
}
