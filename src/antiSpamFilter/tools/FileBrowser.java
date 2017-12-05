package antiSpamFilter.tools;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

@SuppressWarnings("serial")
/**
 * Dialog window that will be used to help the user locate configuration files
 * @author rmnte-iscteiulpt
 *
 */
public class FileBrowser extends JFileChooser {

	/**
	 * Constructor
	 * @param file File that the FileBrowser should help locate
	 */
	public FileBrowser(String file) {
		super();
		setCurrentDirectory(new File(System.getProperty("user.dir") + "\\AntiSpamConfigurationForLeisureMailbox\\"));
		String fileFilterDescription = "";
		String fileExtension = "";
		if(file == "rules")	{
			fileFilterDescription = "Rules.cf File";
			fileExtension = "cf";
		}	else	if(file == "spam")	{
			fileFilterDescription = "Spam.log File";
			fileExtension = "log";
		}	else	{
			fileFilterDescription = "Ham.log File";
			fileExtension = "log";
		}
		FileNameExtensionFilter filter = new FileNameExtensionFilter(fileFilterDescription, fileExtension);
		setDialogTitle("Choose custom " + file + " file");
		addChoosableFileFilter(filter);
		setAcceptAllFileFilterUsed(false);
		
	}
	
	/**
	 * Method that will return the path chosen by the user after using the dialog
	 * @return Path chosen by the user
	 */
	public String getBrowsePath()	{
		int returnValue = showOpenDialog(null);
		String path = "";
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			path = getSelectedFile().getAbsolutePath();
		}
		return path;
	}
}
