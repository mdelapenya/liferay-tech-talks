package unrolling;

public class Unrolling {
	public static final String[] OPTIONS = { "YES" , "NO", "MAYBE", "NEVER" };

	public void iterate() {
		for (String option : OPTIONS) {
			process(option);
		}
	}

	protected void process(String option) {
		System.out.println(option);
	}

}
