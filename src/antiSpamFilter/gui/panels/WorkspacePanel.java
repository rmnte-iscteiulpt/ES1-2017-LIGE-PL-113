package antiSpamFilter.gui.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import antiSpamFilter.datastore.RulesConfigList;
import antiSpamFilter.gui.frames.MainWindow;
import antiSpamFilter.gui.panes.TablePane;

@SuppressWarnings("serial")
/**
 * The panel that contains most of the working elements. This includes the table, evaluate buttons, results panel, etc...
 * @author skner
 *
 */
public class WorkspacePanel extends JPanel	{
	
	private MainWindow mainWindow;	// Pointer to the main window
	private TablePane tablePane;	// The visual table view
	private JPanel resultsPanel;	// The results panel, showing to the user the returning results from the evaluation
	private JTextField fpValue;	// Value shown on the FP field
	private JTextField fnValue;	// Value shown on the FN field
	
	/**
	 * Constructor
	 * @param bounds Size and position of the panel
	 * @param configList Initial configuration list to apply to the table
	 * @param mainWindow The main frame where to insert this panel in
	 * @param editableWeights Makes the table editable or not
	 */
	public WorkspacePanel(Rectangle bounds, RulesConfigList configList, MainWindow mainWindow, boolean editableWeights)	{
		tablePane = new TablePane(new Rectangle(10, 11, 249, 150), configList, editableWeights);
		this.mainWindow = mainWindow;
		setBackground(Color.LIGHT_GRAY);
		setBounds(bounds);
		setLayout(null);
		add(tablePane);
		JLabel resultsText = new JLabel("Results");
		add(resultsText);
		resultsText.setBounds(330, 7, 100, 20);
		add(resultsPanel = setupResultsPanel());
		resultsPanel.setBounds(280, 27, 150, 100);
	}

	/**
	 * Sets up the results panel
	 * @return The results panel
	 */
	private JPanel setupResultsPanel() {
		resultsPanel = new JPanel();
		resultsPanel.setLayout(null);
		
		JLabel fpText = new JLabel("False Positives");
		resultsPanel.add(fpText);
		fpText.setBounds(10, 11, 100, 20);
		fpText.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLabel fnText = new JLabel("False Negatives");
		resultsPanel.add(fnText);
		fnText.setBounds(10, 34, 100, 20);
		fnText.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		// Fields to be updated as the data changes
		fpValue = new JTextField("" + 0);
		fpValue.setEditable(false);
		fpValue.setHorizontalAlignment(JTextField.CENTER);
		resultsPanel.add(fpValue);
		fpValue.setBounds(110, 10, 26, 20);
		fnValue = new JTextField("" + 0);
		fnValue.setEditable(false);
		fnValue.setHorizontalAlignment(JTextField.CENTER);
		resultsPanel.add(fnValue);
		fnValue.setBounds(110, 35, 26, 20);
		
		return resultsPanel;
	}
	
	/**
	 * Updates the table with a new RulesConfigList configuration
	 * @param arg New configuration list
	 */
	public void updateTableContent(RulesConfigList arg)	{
		tablePane.updateContent(arg);
	}
	
	/**
	 * Updates results showed on the results panel
	 * @param res The result array to show in the panel
	 */
	public void updateResults(int[] res)	{
		fpValue.setText("" + res[0]);
    	fnValue.setText("" + res[1]);
	}

	/**
	 * Getter for the main window frame
	 * @return The main window
	 */
	protected MainWindow getMainWindow() {
		return mainWindow;
	}

	/**
	 * Getter for the table pane
	 * @return The table pane
	 */
	protected TablePane getTablePane() {
		return tablePane;
	}

	/**
	 * Getter for the results panel
	 * @return The results panel
	 */
	protected JPanel getResultsPanel() {
		return resultsPanel;
	}
	
	
	
}
