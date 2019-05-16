import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import java.util.HashSet;


public class paperDetails_GUI {

	public JFrame frmPaperDetails;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_4;
	public JTextField textField_5;
	public JTextArea textArea;
	public JTextArea textArea_1;
	public JTextArea textArea_2;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize() {
		frmPaperDetails = new JFrame();
		frmPaperDetails.setResizable(false);
		
		frmPaperDetails.setTitle("Paper Details");
		frmPaperDetails.getContentPane().setBackground(SystemColor.activeCaption);
		frmPaperDetails.setBounds(100, 100, 971, 875);
		frmPaperDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPaperDetails.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("IEEE Digital Library");
		label.setForeground(new Color(0, 0, 139));
		label.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 46));
		label.setBounds(22, 11, 580, 47);
		frmPaperDetails.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Publication");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 18));
		label_1.setBounds(22, 122, 143, 30);
		frmPaperDetails.getContentPane().add(label_1);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 18));
		lblTitle.setBounds(22, 200, 143, 30);
		frmPaperDetails.getContentPane().add(lblTitle);
		
		JLabel lblAbstract = new JLabel("Abstract");
		lblAbstract.setForeground(Color.BLACK);
		lblAbstract.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 18));
		lblAbstract.setBounds(22, 277, 143, 30);
		frmPaperDetails.getContentPane().add(lblAbstract);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.inactiveCaptionBorder);
		textField.setEditable(false);
		textField.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textField.setBounds(22, 151, 927, 38);
		frmPaperDetails.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(SystemColor.inactiveCaptionBorder);
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(22, 228, 927, 38);
		frmPaperDetails.getContentPane().add(textField_1);
		
				
		JLabel lblYear = new JLabel("Authors");
		lblYear.setForeground(Color.BLACK);
		lblYear.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 18));
		lblYear.setBounds(22, 444, 143, 30);
		frmPaperDetails.getContentPane().add(lblYear);
		
		JLabel lblWebsite = new JLabel("Year");
		lblWebsite.setForeground(Color.BLACK);
		lblWebsite.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 18));
		lblWebsite.setBounds(22, 543, 143, 30);
		frmPaperDetails.getContentPane().add(lblWebsite);
		
		textField_4 = new JTextField();
		textField_4.setBackground(SystemColor.inactiveCaptionBorder);
		textField_4.setEditable(false);
		textField_4.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(22, 571, 927, 38);
		frmPaperDetails.getContentPane().add(textField_4);
		
		JLabel lblResourse = new JLabel("Resourse");
		lblResourse.setForeground(Color.BLACK);
		lblResourse.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 18));
		lblResourse.setBounds(22, 620, 143, 30);
		frmPaperDetails.getContentPane().add(lblResourse);
		
		textField_5 = new JTextField();
		textField_5.setBackground(SystemColor.inactiveCaptionBorder);
		textField_5.setEditable(false);
		textField_5.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textField_5.setColumns(10);
		textField_5.setBounds(22, 648, 927, 38);
		frmPaperDetails.getContentPane().add(textField_5);
		
		JLabel lblKeywords = new JLabel("Keywords");
		lblKeywords.setForeground(Color.BLACK);
		lblKeywords.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 18));
		lblKeywords.setBounds(22, 697, 143, 30);
		frmPaperDetails.getContentPane().add(lblKeywords);
		
		JLabel lblPaperDetails = new JLabel("Paper Details");
		lblPaperDetails.setForeground(new Color(0, 0, 139));
		lblPaperDetails.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 22));
		lblPaperDetails.setBounds(402, 61, 200, 38);
		frmPaperDetails.getContentPane().add(lblPaperDetails);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(10, 95, 933, 30);
		frmPaperDetails.getContentPane().add(horizontalStrut);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(22, 304, 927, 138);
		frmPaperDetails.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(22, 730, 927, 102);
		frmPaperDetails.getContentPane().add(scrollPane_1);
		
		textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textArea_1.setLineWrap(true);
		textArea_1.setEditable(false);
		scrollPane_1.setViewportView(textArea_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2.setBounds(22, 474, 927, 68);
		frmPaperDetails.getContentPane().add(scrollPane_2);
		
		textArea_2 = new JTextArea();
		textArea_2.setLineWrap(true);
		textArea_2.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textArea_2.setEditable(false);
		scrollPane_2.setViewportView(textArea_2);
		scrollPane.createVerticalScrollBar();
		
		frmPaperDetails.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try 
        {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
           e.printStackTrace();
        }
		frmPaperDetails.setVisible(true);
		frmPaperDetails.revalidate();
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void setValues(RetriveData rdo)
	{	
		String a = "", b = "";
		textField.setText(rdo._publication);
		textField_1.setText(rdo._title);
		textArea.append(rdo._abstract);
		textField_4.setText(rdo._year);
		textField_5.setText(rdo._resourse);
		
		HashSet<String> authors = new HashSet(rdo._authors);
		HashSet<String> keywords = new HashSet(rdo._keywords);
		
		for(String names : authors)
			a += names + ", ";
		
		for(String words : keywords)
			b += words + ", ";
		
		textArea_2.append(a);
		textArea_1.append(b);
		
		System.out.println(rdo._publication + rdo._resourse);
	}
}

