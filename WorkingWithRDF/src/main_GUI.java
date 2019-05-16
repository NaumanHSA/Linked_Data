import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.Box;

public class main_GUI {

	private JTextArea search_textArea = new JTextArea();
	private JFrame frame;
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private JTextArea textFieldFrom = new JTextArea();
	private JTextArea textFieldTo = new JTextArea();
	private RetriveData rdo = new RetriveData();
	
	public JFrame frmPaperDetails;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JTextField textField_4;
	public JTextField textField_5;
	public JTextField textField_6;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_GUI window = new main_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public main_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setForeground(Color.BLACK);
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(500, 200, 1330, 766);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 210, 1324, 513);
        
        String [] header = {"Paper Titles"};
        
		model = new DefaultTableModel(null, header);
		table = new JTable(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Paper Titles"
			}
		));
		table.setBorder(new EmptyBorder(40, 0, 0, 40));
		table.setFont(new Font("Monospaced", Font.PLAIN, 22));
		scrollPane.setViewportView(table);
	
		table.setBounds(0, 0, 1000, 400);
		table.setRowHeight(40);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	
	        	if (!event.getValueIsAdjusting() && table.getSelectedRow() != -1) {
	        		
	        		EventQueue.invokeLater(new Runnable()
	        		{
	        			@Override
	        			public void run() {
	        				try {
	        					int column = 0;
	        					int row = table.getSelectedRow();
	        					String value = table.getModel().getValueAt(row, column).toString();
	        					
	        					paperDetails_GUI details = new paperDetails_GUI();
	        					details.initialize();
	        					rdo.RetrievePaperDetails(value);
	        					details.setValues(rdo);
	        					
	        				} catch (Exception e) {
	        					e.printStackTrace();
	        				}
	        			}
	        		});
	        	}
	        }
	    });
		
		frame.setVisible(true);
		
		try {
	            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
	                    | UnsupportedLookAndFeelException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	    }
			
		JButton btnShowMessage = new JButton("Search");
		btnShowMessage.setForeground(new Color(0, 0, 139));
		btnShowMessage.setBounds(1122, 166, 178, 33);
		btnShowMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				rdo.RetrievePapers(table, search_textArea.getText(), textFieldFrom.getText().trim(), textFieldTo.getText().trim());
				
			}
		});
		
		btnShowMessage.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 24));
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(scrollPane);
		frame.getContentPane().add(btnShowMessage);
		search_textArea.setText("");
		search_textArea.setWrapStyleWord(true);
		search_textArea.setToolTipText("");
		
		
		search_textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		search_textArea.setBackground(SystemColor.menu);
		search_textArea.setBounds(185, 166, 927, 33);
		frame.getContentPane().add(search_textArea);
		
		JLabel lblIeee = new JLabel("IEEE Digital Library");
		lblIeee.setForeground(new Color(0, 0, 139));
		lblIeee.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 46));
		lblIeee.setBounds(302, 11, 717, 47);
		frame.getContentPane().add(lblIeee);
		
		textFieldFrom.setToolTipText("");
		textFieldFrom.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textFieldFrom.setText("1900");
		textFieldFrom.setBackground(SystemColor.menu);
		textFieldFrom.setBounds(259, 127, 86, 28);
		frame.getContentPane().add(textFieldFrom);
		textFieldFrom.setColumns(10);
		
		textFieldTo.setToolTipText("2019");
		textFieldTo.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textFieldTo.setText("2019");
		textFieldTo.setColumns(10);
		textFieldTo.setBackground(SystemColor.menu);
		textFieldTo.setBounds(427, 127, 92, 28);
		frame.getContentPane().add(textFieldTo);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setForeground(SystemColor.text);
		lblFrom.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 22));
		lblFrom.setBounds(187, 127, 62, 28);
		frame.getContentPane().add(lblFrom);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setForeground(Color.WHITE);
		lblTo.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 22));
		lblTo.setBounds(373, 127, 62, 28);
		frame.getContentPane().add(lblTo);
		
		JLabel lblDateRange = new JLabel("Date Range");
		lblDateRange.setForeground(Color.WHITE);
		lblDateRange.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 22));
		lblDateRange.setBounds(10, 127, 158, 28);
		frame.getContentPane().add(lblDateRange);
		
		JLabel lblSearchPaper = new JLabel("Search Paper");
		lblSearchPaper.setForeground(Color.WHITE);
		lblSearchPaper.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 22));
		lblSearchPaper.setBounds(10, 166, 165, 28);
		frame.getContentPane().add(lblSearchPaper);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(10, 69, 1304, 30);
		frame.getContentPane().add(horizontalStrut);
		
	}
}
