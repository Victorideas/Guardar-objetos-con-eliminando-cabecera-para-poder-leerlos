
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Víctor
 */
public class MiObjetcOutputStream extends ObjectOutputStream {

    public MiObjetcOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    protected MiObjetcOutputStream() throws IOException, SecurityException {
        super();
    }

    protected void writeStreamHeader() throws IOException {

    }
}
