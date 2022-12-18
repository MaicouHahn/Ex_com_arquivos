import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        String path = "C:\\Users\\Zeturiell\\Desktop\\programação\\Java\\EXUdemy\\lendo arquivos\\exFixacao\\source.csv";
        List<Product> product = new ArrayList<>();
        new File("C:\\Users\\Zeturiell\\Desktop\\programação\\Java\\EXUdemy\\lendo arquivos\\exFixacao\\"+"\\out").mkdir();

        String outPath="C:\\Users\\Zeturiell\\Desktop\\programação\\Java\\EXUdemy\\lendo arquivos\\exFixacao\\out\\summary.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            
            String line = br.readLine();
            String[] lineSplit = line.split(",");
            while (line != null) {
                
                //System.out.println(line);
                lineSplit = line.split(",");
                product.add(new Product(lineSplit[0], Double.parseDouble(lineSplit[1]), Integer.parseInt(lineSplit[2])));
                line = br.readLine();
            }
        
        } catch (IOException exception) {
            System.out.println("Erro: " + exception.getMessage());
        }
        
        try(BufferedWriter wr = new BufferedWriter(new FileWriter(outPath))){
            for(Product c: product){
                
                wr.write("Name: "+c.getName()+", Total Value: "+String.format("%.2f", c.getTotalValue()));
                wr.newLine();
            }

        }catch(IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
