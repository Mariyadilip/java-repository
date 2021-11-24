package pattern.creation.builder.director;

public class ExpensiveComputerBuilder extends ComputerBuilder {

	@Override
	public void buildDisplay() {
		computer.setDisplay("IPC");

	}

	@Override
	public void buildSystemBlock() {
		computer.setSystemBlock("8chip");

	}

	@Override
	public void buildManipulators() {
		computer.setManipulators("mouse + keyboard + touchpen + wireless charging");

	}

}
