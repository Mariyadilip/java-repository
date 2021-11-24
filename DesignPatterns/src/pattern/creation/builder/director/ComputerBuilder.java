package pattern.creation.builder.director;

public abstract class ComputerBuilder {

	protected Computer computer;
	
	public void createNewComputer() {
		computer = new Computer();
	}
	
	public Computer getComputer() {
		return computer;
	}
	
	public abstract void buildDisplay();
	public abstract void buildSystemBlock();
	public abstract void buildManipulators();
	
}
