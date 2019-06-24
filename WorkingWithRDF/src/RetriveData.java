import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;
import java.util.*;
import javax.swing.JTable;
import javax.swing.table.*;
import java.lang.Object;
import org.apache.jena.util.FileManager;
import javax.swing.JOptionPane;

import virtuoso.jena.driver.VirtGraph;
import virtuoso.jena.driver.VirtuosoQueryExecution;
import virtuoso.jena.driver.VirtuosoQueryExecutionFactory;
import org.apache.jena.rdf.model.Model;

public class RetriveData {

	public static final String tdbDirectory = "<your graph (e.i .nt file) directory path>;
	public static final String dbdump = "<graph (e.i .nt file) file path>";
	
	public List<String> _authors = new ArrayList<String>();
	public List<String> _keywords = new ArrayList<String>();
	public String _publication;
	public String _title;
	public String _abstract;
	public String _year;
	public String _resourse;
	
	public void RetrieveLocalData(JTable table)
	{
		Model model = FileManager.get().loadModel(dbdump, tdbDirectory,  "N-TRIPLES");
		
        Query query = QueryFactory.create(); // the query above
        QueryExecution qExe = QueryExecutionFactory.create(query, model);
        ResultSet results = qExe.execSelect();
      
        while(results.hasNext())
        {
            QuerySolution sol = results.nextSolution();
            RDFNode subject = sol.get("s"); 
            RDFNode Predicate = sol.get("title"); 
            RDFNode object  = sol.get("o");

            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.addRow(new Object[]{subject, Predicate, object});
        }
        
       qExe.close();
	}
	
	public void RetrievePapers(JTable table, String title, String from, String to)
	{
		System.out.println(from + " " + to);
		String query = "PREFIX id:   <http://ieee.rkbexplorer.com/id/>\r\n" + 
				"PREFIX rdf:  <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\n" + 
				"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\n" + 
				"PREFIX akt:  <http://www.aktors.org/ontology/portal#>\r\n" + 
				"PREFIX owl:  <http://www.w3.org/2002/07/owl#>\r\n" + 
				"PREFIX akt:  <http://www.aktors.org/ontology/portal#>\r\n" + 
				"PREFIX akts: <http://www.aktors.org/ontology/support#>\r\n" + 
				"PREFIX iai:  <http://www.iai.uni-sb.de/resist#>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"SELECT ?title " +
				"From <http://localhost:8890/IEEE>  " +
				"WHERE {\r\n" +  
				"?s akt:has-title ?title \r\n" + 
				"FILTER REGEX(?title, \"" + title + "\", \"i\").\r\n" + 
				"?s akt:has-date ?date.\r\n" + 
				"  ?date akts:year-of ?year.\r\n" +
				"FILTER (?year > \"" + from + "\" && ?year <= \"" + to + "\"). \r\n" +
				"}";
		
		try {
			
			String url = "jdbc:virtuoso://localhost:1111";
			VirtGraph set = new VirtGraph (url, "dba", "dba");

            //Select all data in virtuoso     
	        Query sparql = QueryFactory.create(query);
	        VirtuosoQueryExecution vqe = VirtuosoQueryExecutionFactory.create (sparql, set);
	        ResultSet results = vqe.execSelect();

            while(results.hasNext())
            {
                QuerySolution sol = results.nextSolution();
                RDFNode titles = sol.get("title");

                DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                tableModel.addRow(new Object[]{titles});
            }
            vqe.close();
        }
        catch(Exception e) {	
        	JOptionPane.showMessageDialog(null, e.getMessage(), "Error Message", JOptionPane.WARNING_MESSAGE);
        }
	}
	
	public void RetrievePaperDetails(String t)
	{
		try {
			
			String url = "jdbc:virtuoso://localhost:1111";
			VirtGraph set = new VirtGraph (url, "dba", "dba");
			
			String query = "PREFIX id:   <http://ieee.rkbexplorer.com/id/>\r\n" + 
					"PREFIX rdf:  <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\n" + 
					"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\n" + 
					"PREFIX akte:  <http://www.aktors.org/ontology/extension#>\r\n" + 
					"PREFIX owl:  <http://www.w3.org/2002/07/owl#>\r\n" + 
					"PREFIX akt:  <http://www.aktors.org/ontology/portal#>\r\n" + 
					"PREFIX akts: <http://www.aktors.org/ontology/support#>\r\n" + 
					"PREFIX iai:  <http://www.iai.uni-sb.de/resist#>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"SELECT distinct ?pub ?title ?abstract ?author_name ?year ?website ?keywords " +
					"From <http://localhost:8890/IEEE> " +
					" WHERE {\r\n" + 
					"  ?pub akt:has-title ?title.\r\n" + 
					"  ?pub akte:has-abstract ?abstract.\r\n" + 
					"  ?pub akt:has-author ?author.\r\n" + 
					"  ?author akt:full-name ?author_name.\r\n" + 
					"  ?pub akt:has-date ?date.\r\n" + 
					"  ?date akts:year-of ?year.\r\n" + 
					"  ?pub akt:has-web-address ?website.\r\n" + 
					"  ?pub iai:has-ieee-keyword ?keywords.\r\n" + 
					"}";
			
            //Select all data in virtuoso     
	        Query sparql = QueryFactory.create(query);
	        VirtuosoQueryExecution vqe = VirtuosoQueryExecutionFactory.create (sparql, set);
	        ResultSet results = vqe.execSelect();
	        
            while(results.hasNext())
            {
                QuerySolution sol = results.nextSolution();
                RDFNode titles = sol.get("title");
                if(t.equals(titles.toString())) {
                	RDFNode pub = sol.get("pub");
                	RDFNode abs = sol.get("abstract");
                	RDFNode name = sol.get("author_name");
                	RDFNode y = sol.get("year");
                	RDFNode site = sol.get("website");
                	RDFNode words = sol.get("keywords");
                	
                	_publication = pub.toString();
                	_title = t;
                	_abstract = abs.toString();
                	_year = y.toString();
                	_resourse = site.toString();
                	_authors.add(name.toString());
                	_keywords.add(words.toString()); 
                }
            }
        	
            vqe.close();
        }
        catch(Exception e) {	
        	JOptionPane.showMessageDialog(null, e.getMessage(), "Error Message", JOptionPane.WARNING_MESSAGE);
        }
	}
	
	public void RetrieveOnlineData(JTable table)
	{

		Query query = QueryFactory.create();
        QueryExecution qExe = QueryExecutionFactory.sparqlService( "https://dbpedia.org/sparql", query );
        ResultSet results = qExe.execSelect();

        while(results.hasNext())
        {
            QuerySolution sol = results.nextSolution();
            RDFNode subject = sol.get("s"); 
            RDFNode stadium = sol.get("label"); 
            RDFNode lat  = sol.get("l");

            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.addRow(new Object[]{subject, stadium, lat});
        }
        
       qExe.close();
	}	
}
