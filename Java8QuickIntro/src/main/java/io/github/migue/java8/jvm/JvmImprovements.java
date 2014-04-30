package io.github.migue.java8.jvm;

/**
 * Removal of the PermGem
 *
 *  Region of Java Heap for JVM class metadata
 *  Representation of classes
 *      Class hierarchy information, method, fields
 *      Method compilation information and bytecodes
 *      VTables
 *      Constant Pool and symbolic resolution
 *      Interned Strings (moved out in Java 7)
 *
 *  This space has been moved into native memory.
 *
 *  Why has been eliminated?
 *
 *      Fixed size at startup
 *      Improved GC Performance
 *          Special iterators for metadata
 *          Deallocate class data concurrently and not during GC pauses
 *      Enable future improvements
 *
 * The new memory area is called MetaSpace
 *       Class metadata area has the same lifecycle as their loaders'
 *       Per loader storage area
 *             Linear bump allocation
 *             No individual reclamation
 *             Not scanned by GC and not compacted
 *             Allocated objects here never relocate
 *             Reclamation en-masse (when classloader is dead)
 *
 * Other improvements
 *
 * Exact math intrinsics
 * Fence intrinsics
 * Annotations on Java types
 * Enhanced verification errors
 * Reduced cache contention on specified fields
 * @author Miguel Pastor
 */
public class JvmImprovements {
}
