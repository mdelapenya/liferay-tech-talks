package io.github.migue.java8.nashrom;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Replacement of Rhino JavaScript Engine
 *
 * 1. running from the command line jjs
 *
 * 2. Use it from Java with the ScriptEngineManager
 * @author Miguel Pastor
 */
public class NashromEngine {
	public static void main(String[] args) throws ScriptException {
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();

		ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");

		Object eval = nashorn.eval("'hello world'.length");

		System.out.println(eval);

		// We can invoke methods

		Bindings bindings = nashorn.createBindings();

		bindings.put("s", new String("foo"));

		Object result = nashorn.eval("s.foo = 'changed from JS'; s", bindings);

		System.out.println(result);

	}

	class Foo {
		String s;
		public Foo(String s) {
			this.s = s;
		}

		public void setFoo(String s) {
			this.s = s;
		}
	}
}
