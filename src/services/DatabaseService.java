package services;

import java.io.*;

public class DatabaseService {
    private final String filepath;

    public DatabaseService(
            String filepath
    ) {
        this.filepath = filepath;
        this.initializeFile(); // cria o arquivo de forma proativa antes de qualquer uso
    }

    private void initializeFile() {
        File file = new File(this.filepath);

        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void serializeObjectToFile(
            Object obj
    ) throws java.io.IOException {
        try (FileOutputStream fileout = new FileOutputStream(this.filepath);
             ObjectOutputStream out = new ObjectOutputStream(fileout)
        ) {
            out.writeObject(obj);
        }
    }

    public Object readObjectFromFile() throws java.io.IOException, java.lang.ClassNotFoundException {
        try (
                FileInputStream filein = new FileInputStream(this.filepath);
                ObjectInputStream in = new ObjectInputStream(filein)
        ) {
            return in.readObject();
        }
    }
}
