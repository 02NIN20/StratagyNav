public class DocDataMiner extends DataMiner {
    @Override
    protected Object openFile(String path) {
        System.out.println("Abriendo archivo DOC: " + path);
        return new Object(); // Simulación
    }

    @Override
    protected String extractData(Object file) {
        return "Datos crudos del DOC";
    }

    @Override
    protected String parseData(String raw) {
        return "Datos parseados del DOC";
    }
}
