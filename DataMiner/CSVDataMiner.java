public class CSVDataMiner extends DataMiner {
    @Override
    protected Object openFile(String path) {
        System.out.println("Abriendo archivo CSV: " + path);
        return new Object();
    }

    @Override
    protected String extractData(Object file) {
        return "Datos crudos del CSV";
    }

    @Override
    protected String parseData(String raw) {
        return "Datos parseados del CSV";
    }
}
