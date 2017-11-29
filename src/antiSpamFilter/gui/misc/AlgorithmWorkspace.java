/**
 * 
 */
package antiSpamFilter.gui.misc;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import antiSpamFilter.gui.panels.WorkspacePanel;
import antiSpamFilter.misc.RulesConfigList;

/**
 * @author skner
 *
 */
@SuppressWarnings("serial")
public class AlgorithmWorkspace extends WorkspacePanel implements Observer	{

	public AlgorithmWorkspace(Rectangle bounds, RulesConfigList configList) {
		super(bounds, configList, false);
		generateAlgorithmLayout();
	}

	private void generateAlgorithmLayout() {
		// TODO Decide what buttons it should have, deppending on how the algorithm works, this can only be added once basic funcionality is added
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}



}