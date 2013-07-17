package clojure.lang;

import clojure.api.API;

/**
 * Internally, the stack is a Clojure vector held inside an Atom. Normal
 * method names treat the stack as a persistent data structure, dereferencing
 * the Atom as needed. Method names suffixed with "Mutable" denote mutable versions
 * that affect the state of the Atom holding the stack.
 */
public class GershwinStack {
    private static Atom stackAtom = new Atom(PersistentVector.EMPTY);
    private static IFn CLOJURE_CONJ = API.var("clojure.core", "conj");
    private static IFn CLOJURE_POP = API.var("clojure.core", "pop");
    private static String STACK_UNDERFLOW_MSG = "Data stack underflow. Can't take something off an empty data stack.";

    public static IPersistentStack conj(Object form) {
        return (IPersistentStack) CLOJURE_CONJ.invoke(stackAtom.deref(), form);
    }

    public static IPersistentStack conjMutable(Object form) {
        stackAtom.swap(CLOJURE_CONJ, form);
        return (IPersistentStack) stackAtom.deref();
    }

    /**
     * Custom mutable conj, never conjes the special value
     * :gershwin.core/stack-void
     */
    public static IPersistentStack conjIt(Object form) {
        if(form == null
           || !(form.equals(RT.STACK_VOID))) {
            stackAtom.swap(CLOJURE_CONJ, form);
        }
        return (IPersistentStack) stackAtom.deref();
    }

    /**
     * Like Clojure's peek, but throws an exception if the stack is empty.
     */
    public static Object peek() {
        IPersistentStack rawStack = (IPersistentStack) stackAtom.deref();
        if (rawStack.count() == 0)
            throw new StackUnderflowException(STACK_UNDERFLOW_MSG);
        return rawStack.peek();
    }

    public static IPersistentStack pop() {
        try {
            return (IPersistentStack) CLOJURE_POP.invoke(stackAtom.deref());
        } catch(IllegalStateException e) {
            throw new StackUnderflowException(STACK_UNDERFLOW_MSG, e);
        }
    }

    public static IPersistentStack popMutable() {
        try {
            return (IPersistentStack) stackAtom.swap(CLOJURE_POP);
        } catch(IllegalStateException e) {
            throw new StackUnderflowException(STACK_UNDERFLOW_MSG);
        }
    }

    /**
     * This is what a traditional mutable stack would simply call
     * 'pop', but I've reserved 'pop' to be used in accordance with
     * the Clojure idiom, which returns the remaining collection instead
     * of the item popped.
     */
    public static Object popIt() {
        IPersistentStack rawStack = (IPersistentStack) stackAtom.deref();
        Object item = rawStack.peek();
        try {
            // Try again if, between the above peek and the change to the atom,
            // the underlying value has changed.
            if(!stackAtom.compareAndSet(rawStack, rawStack.pop())) {
                return popIt();
            }
        } catch(IllegalStateException e) {
            throw new StackUnderflowException(STACK_UNDERFLOW_MSG);
        }
        return item;
    }

    public static IPersistentStack clear() {
        return (IPersistentStack) stackAtom.reset(PersistentVector.EMPTY);
    }

    public static int count() {
        IPersistentStack rawStack = (IPersistentStack) stackAtom.deref();
        return rawStack.count();
    }

    public static ISeq seq() {
        IPersistentStack rawStack = (IPersistentStack) stackAtom.deref();
        return rawStack.seq();
    }

    /**
     * Return the raw, underlying stack used for the implementation
     * of this class.
     */
    public static IPersistentStack getStack() {
        return (IPersistentStack) stackAtom.deref();
    }

    public static class StackUnderflowException extends IllegalStateException {
        public StackUnderflowException() {
            super();
        }

        public StackUnderflowException(String message) {
            super(message);
        }

        public StackUnderflowException(String message, Throwable e) {
            super(message, e);
        }
    }

}
