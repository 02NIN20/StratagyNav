public abstract class DataMiner {
    protected String filePath;
    protected String rawData;
    protected String parsedData;
    protected String analysis;

    public final void mine(String path) {
        Object file = openFile(path);
        rawData = extractData(file);
        parsedData = parseData(rawData);
        analysis = analyzeData(parsedData);
        sendReport(analysis);
        closeFile(file);
    }

    protected abstract Object openFile(String path);
    protected abstract String extractData(Object file);
    protected abstract String parseData(String raw);

    protected String analyzeData(String data) {
        return "Resultado del análisis de: " + data;
    }

    protected void sendReport(String analysis) {
        System.out.println("Enviando reporte: " + analysis);
    }

    protected void closeFile(Object file) {
        System.out.println("Cerrando archivo...");
    }
}
