package pattern.creation.builder.director;

public class CheapComputerBuilder extends ComputerBuilder {

	@Override
	public void buildDisplay() {
        computer.setDisplay("LCD");
	}

	@Override
	public void buildSystemBlock() {
		computer.setSystemBlock("4chip");
	}

	@Override
	public void buildManipulators() {
		computer.setManipulators("mouse + keyboard");
	}

}
