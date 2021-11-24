package pattern.creation.builder.director;

public class Demo {

	public static void main(String[] args) {
		
		ComputerDirector cd = new ComputerDirector();
		cd.setComputer(new CheapComputerBuilder());
		cd.buildComputer();
		Computer computer = cd.getComputer();
		System.out.println(computer);
		
		cd.setComputer(new ExpensiveComputerBuilder());
		cd.buildComputer();
		computer = cd.getComputer();
		System.out.println(computer);
	}
}
