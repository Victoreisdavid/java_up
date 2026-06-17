package services;

import java.io.*;

public class DatabaseService {
    private final String filepath;
    private final File file;

    public DatabaseService(
            String filepath
    ) {
        this.filepath = filepath;
        this.file = new File(this.filepath);
    }

    private void initializeFile() {
        if(!this.file.exists()) {
            try {
                this.file.getParentFile().mkdirs();
                this.file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean fileExists() {
        return this.file.exists();
    }

    public void serializeObjectToFile(
            Object obj
    ) throws java.io.IOException {
        this.initializeFile();

        try (FileOutputStream fileout = new FileOutputStream(this.filepath);
             ObjectOutputStream out = new ObjectOutputStream(fileout)
        ) {
            out.writeObject(obj);
        }
    }

    public Object readObjectFromFile() throws java.io.IOException, java.lang.ClassNotFoundException {
        if (!this.fileExists()) {
            throw new FileNotFoundException("Arquivo não encontrado: " + this.file.getPath());
        }

        try (
                FileInputStream filein = new FileInputStream(this.filepath);
                ObjectInputStream in = new ObjectInputStream(filein)
        ) {
            return in.readObject();
        }
    }

    public void deleteFile() {
        if(!this.fileExists()) {
            return;
        }

        this.file.delete();
    }
}
