package pl.nbp.model;

import pl.nbp.model.Enum.*;

public class QueriesToWeb {

    private TableOrRate tableOrRate;
    private NameTable nameTable;
    private int topCount;
    private CurrencyTypeInTableA tableA;
    private CurrencyTypeInTableB tableB;
    private CurrencyTypeInTableC tableC;
    private String date;
    private String startDate;
    private String endDate;



    public QueriesToWeb(QueriesToWebBuilder queriesToWebBuilder) {
        this.tableOrRate = queriesToWebBuilder.tableOrRate;
        this.nameTable = queriesToWebBuilder.nameTable;
        this.topCount = queriesToWebBuilder.topCount;
        this.tableA = queriesToWebBuilder.tableA;
        this.tableB = queriesToWebBuilder.tableB;
        this.tableC = queriesToWebBuilder.tableC;
        this.date = queriesToWebBuilder.date;
        this.startDate = queriesToWebBuilder.startDate;
        this.endDate = queriesToWebBuilder.endDate;
    }

    public static class QueriesToWebBuilder {
        private TableOrRate tableOrRate;
        private NameTable nameTable;
        private int topCount;
        private CurrencyTypeInTableA tableA;
        private CurrencyTypeInTableB tableB;
        private CurrencyTypeInTableC tableC;
        private String date;
        private String startDate;
        private String endDate;

        public QueriesToWebBuilder tableOrRate(TableOrRate tableOrRate) {
            this.tableOrRate = tableOrRate;
            return this;
        }

        public QueriesToWebBuilder nameTable(NameTable nameTable) {
            this.nameTable = nameTable;
            return this;
        }

        public QueriesToWebBuilder topCount(int topCount) {
            this.topCount = topCount;
            return this;
        }

        public QueriesToWebBuilder tableA(CurrencyTypeInTableA tableA) {
            this.tableA = tableA;
            return this;
        }

        public QueriesToWebBuilder tableB(CurrencyTypeInTableB tableB) {
            this.tableB = tableB;
            return this;
        }

        public QueriesToWebBuilder tableC(CurrencyTypeInTableC tableC) {
            this.tableC = tableC;
            return this;
        }

        public QueriesToWebBuilder date(String date) {
            this.date = date;
            return this;
        }

        public QueriesToWebBuilder startDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        public QueriesToWebBuilder endDate(String endDate) {
            this.endDate = endDate;
            return this;
        }

        public QueriesToWeb build(){
            QueriesToWeb queriesToWeb = new QueriesToWeb(this);
            return queriesToWeb;
        }
    }
}
