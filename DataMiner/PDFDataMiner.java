public class PDFDataMiner extends DataMiner {
    @Override
    protected Object openFile(String path) {
        System.out.println("Abriendo archivo PDF: " + path);
        return new Object();
    }

    @Override
    protected String extractData(Object file) {
        return "Datos crudos del PDF";
    }

    @Override
    protected String parseData(String raw) {
        return "Datos parseados del PDF";
    }
}
