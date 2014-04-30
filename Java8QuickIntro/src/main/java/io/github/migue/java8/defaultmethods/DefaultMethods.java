package io.github.migue.java8.defaultmethods;

/**
 * Java 8 has included the ability to write concrete method definitions in
 * an interface. This approach will end up with the common pattern of having
 * and interface with an abstract class implementing most of its methods.
 *
 * Default methods rules:
 *
 * 1. Superclasses ALWAYS win. If a superclass provides a concrete method, an
 * existing default method with the same signature will be simply ignored
 *
 * 2. Interface clash. Two interfaces provides the same default method. In this
 * case the compiler will complain, and the developer must resolve the conflict
 *
 * @author Miguel Pastor
 */
public class DefaultMethods {
	public static void main(String[] args) {
		System.out.println(new InterfaceClassDefaultMethodCollision().a());

		System.out.println(new InterfaceInterfaceDefaultMethodCollistion().a());
	}
}

interface A {
	default String a() {
		return "Default method a() implemented in " +  A.class;
	}
}

interface B extends A {
	String b();
}

interface C {
	default String a() {
		return "Default method a() implemented in " +  C.class;
	}
}

class SimpleClass {
	public String a() { return "Method a defined on class. I WIN!!"; }

	public String c() { return "c"; }
}

class InterfaceClassDefaultMethodCollision extends SimpleClass implements B {

	@Override
	public String b() {
		return "b implemented in class";
	}
}

class InterfaceInterfaceDefaultMethodCollistion implements B, C {

	@Override
	public String a() {
		// The compiler will complain, so we need to resolve the issue
		// The line bellow would chose the method defined at the interface C
		//return C.super.a();
		return C.super.a();
	}

	@Override
	public String b() {
		return "b";
	}
}
