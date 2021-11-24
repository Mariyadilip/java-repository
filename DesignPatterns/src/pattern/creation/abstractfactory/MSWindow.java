package pattern.creation.abstractfactory;

//ConcreteProductA1

public class MSWindow implements Window {

	public void repaint() {
		// MS Windows specific behaviour
	}

	@Override
	public void setTitle(final String text) {
	}

}