package antiSpamFilter.engines;

import java.util.ArrayList;
import java.util.Observable;

import antiSpamFilter.misc.RulesConfigList;

/**
 * @author skner
 *
 */
public class AutomaticEngine extends Observable	{

	private RulesConfigList configList;
	
	public AutomaticEngine() {
		this(new ArrayList<String>());
	}
	
	public AutomaticEngine(ArrayList<String> list)	{
		configList = new RulesConfigList(list);
	}

	public void updateRules(ArrayList<String> rulesList) {
		configList.updateRules(rulesList);
		updateAutoPanel();
	}

	public RulesConfigList getConfigList()	{
		return configList;
	}
	
	private void updateAutoPanel()	{
		setChanged();
		notifyObservers(this.configList);
	}
}
