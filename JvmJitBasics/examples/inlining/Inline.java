package inlining;

public class Inline {
	public static int addAll(int max) {
		int accumulator = 0;

		for (int i = 0; i < max; ++i) {
			accumulator = add(accumulator,i);
			int min = Math.min(accumulator, 10000);
		}

		return accumulator;
	}

	public static int add (int x, int y) {
		return x + y;
	}

	public static void main(String[] args) {
		int max = Integer.parseInt(args[0]);

		System.out.println(addAll(max));
	}
}
