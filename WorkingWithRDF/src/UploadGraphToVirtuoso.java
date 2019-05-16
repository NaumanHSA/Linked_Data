import org.apache.jena.rdf.model.Model;
import org.apache.jena.util.FileManager;
import virtuoso.jena.driver.*;
import java.io.InputStream;
import java.io.InputStreamReader;

public class UploadGraphToVirtuoso {
	public static void main(String args[])
	{

		try {
			  String nfile = "labels_en.nt";
			  Model model = VirtModel.openDatabaseModel("DBpedia_English", "jdbc:virtuoso://localhost:1111", "dba", "dba");
			  InputStream in = FileManager.get().open( nfile );
			  if (in == null) {
			      throw new IllegalArgumentException( "File: " + nfile + " not found");
			  }
			  model.read(new InputStreamReader(in), null, "N-TRIPLE");
			  model.close();

			} catch (Exception e) {
			  System.out.println("Ex="+e);
		}
	}
}
