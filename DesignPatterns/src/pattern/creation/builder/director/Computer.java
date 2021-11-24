package pattern.creation.builder.director;

public class Computer {

	String display;
	String systemBlock;
	String manipulators;	

	public void setDisplay(String display) {
		this.display = display;
	}
	public void setSystemBlock(String systemBlock) {
		this.systemBlock = systemBlock;
	}
	public void setManipulators(String manipulators) {
		this.manipulators = manipulators;
	}
	
	@Override
	public String toString() {
		return "Computer [display=" + display + ", systemBlock=" + systemBlock + ", manipulators=" + manipulators + "]";
	}
}
