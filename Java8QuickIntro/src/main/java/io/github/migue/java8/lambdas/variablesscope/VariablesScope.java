package io.github.migue.java8.lambdas.variablesscope;

/**
 * We can identify three main parts in a lambda expression
 *
 * a. Block of code
 * b. Parameters
 * c. Free variables (variables no defined
 *
 * Lambad expressions can capture the value of a variable present in the enclosing
 * scope. Restrictions have been relaxed, an now lambdas can capture "effectively final" variables,
 * that's it, variables which have never been modified after its initialization
 *
 * @author Miguel Pastor
 */
public class VariablesScope {

	/**
	 * Note we are capturing the arguments "message" and "count" which are
	 * not defined in the lambda arguments
	 */
	static void printMessageInThread(String message, int count) {
		Runnable r = () -> {
			for (int i = 0; i < count; i++) {
				System.out.println(message);

				// DOES NOT COMPILE: variables should be effectively final
				// count--;

				Thread.yield();
			}
		};

		new Thread(r).start();
	}

	public static void main(String[] args) {
		printMessageInThread("Simple message", 11);
	}
}
