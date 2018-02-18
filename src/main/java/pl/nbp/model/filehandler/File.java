package pl.nbp.model.filehandler;

import pl.nbp.model.User;

import java.io.IOException;
import java.util.ArrayList;

public interface File {
    public void isExist() throws IOException;

    public void isEmpty() throws IOException;

    public ArrayList read(/*ArrayList arrayList*/) throws IOException;

    public void write(User user) throws IOException;
}
