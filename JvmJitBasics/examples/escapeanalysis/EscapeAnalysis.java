package inlining;

public class EscapeAnalysis {
	public void foo() {
		Point p = new Point(1, 10);

		doCompute(p);
	}

	protected void doCompute(Point p) {
		System.out.println("Computing on " + p.x + ":" + p.y);

		doMoreCompute(p);
	}

	protected void doMoreCompute(Point p) {
		System.out.println("More Computing on " + p.x  + ":" + p.y);
	}

	private static class Point {
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		int x, y;
	}
}
