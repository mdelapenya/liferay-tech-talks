package locks;

public class Locks {

	public String[] OPTIONS = {"YES", "NO", "MAYBE"}; 

	public void lockedStuff() {
		for (String s : OPTIONS) {
			doStuff(s);
		}
	}

	public void overSync() {
		java.util.List l = new java.util.ArrayList();

		synchronized(l) {
			for (String s : OPTIONS)
				l.add(doMoreStuff(s));
		}
	}

	private synchronized void doStuff(String s) {
		// Thread unsafe code go here :)
	}

	private Object doMoreStuff(String s) {
		return new Object();
	}

}
