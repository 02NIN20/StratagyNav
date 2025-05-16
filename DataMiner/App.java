public class App {
    public static void main(String[] args) {
        DataMiner miner1 = new DocDataMiner();
        miner1.mine("documento.doc");

        DataMiner miner2 = new CSVDataMiner();
        miner2.mine("datos.csv");

        DataMiner miner3 = new PDFDataMiner();
        miner3.mine("informe.pdf");
    }
}
