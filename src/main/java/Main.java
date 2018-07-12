import uInteraction.ReadWriteFile;

public class Main {

    public static void main(String[] args) {
        ReadWriteFile readWriteFile = new ReadWriteFile(args[0], args[1]);
        readWriteFile.start();
    }
}