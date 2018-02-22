package pl.nbp.model;

public enum NameTable {
    A("A"),
    B("B"),
    C("C");

    private String table;

    NameTable(String table) {
        this.table = table;
    }

    public String getTable() {
        return table;
    }
}
