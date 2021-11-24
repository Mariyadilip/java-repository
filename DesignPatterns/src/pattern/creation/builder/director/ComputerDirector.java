package pattern.creation.builder.director;

public class ComputerDirector {
 
	private ComputerBuilder computerBuilder;
	
	public void setComputer(ComputerBuilder computerBuilder) {
		this.computerBuilder = computerBuilder;
	}
	
	public Computer getComputer() {
		return computerBuilder.getComputer();
	}
	
	public void buildComputer() {
		computerBuilder.createNewComputer();
		computerBuilder.buildDisplay();
		computerBuilder.buildManipulators();
		computerBuilder.buildSystemBlock();
	}
}
