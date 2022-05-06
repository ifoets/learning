package com.udemy.basic.dp.structural.decorator;

public class AbstractDecorator extends Component {

	protected Component comp;

	public void setComponent(Component comp) {
		this.comp = comp;
	}

	@Override
	public void doJob() {
		if (comp != null)
			comp.doJob();
	}
}

