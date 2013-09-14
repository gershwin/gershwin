package clojure.lang;

import clojure.api.API;

/**
 * Internally, the stack is a Clojure vector held inside an Atom. Normal
 * method names treat the stack as a persistent data structure, dereferencing
 * the Atom as needed. Method names suffixed with "Mutable" denote mutable versions
 * that affect the state of the Atom holding the stack.
 */
public class GershwinStack implements IPersistentStack {
    private IPersistentStack stack = PersistentVector.EMPTY;
    private static IFn CLOJURE_CONJ = API.var("clojure.core", "conj");
    private static IFn CLOJURE_POP = API.var("clojure.core", "pop");
    private static String STACK_UNDERFLOW_MSG = "Data stack underflow. Can't take something off an empty data stack.";

    public GershwinStack() {}

    public IPersistentStack conj(Object form) {
        return (IPersistentStack) CLOJURE_CONJ.invoke(stack, form);
    }

    public IPersistentStack conjMutable(Object form) {
        this.stack = (IPersistentStack) CLOJURE_CONJ.invoke(this.stack, form);
        return this.stack;
    }

    /**
     * Custom mutable conj, never conjes the special value
     * :gershwin.core/stack-void
     */
    public IPersistentStack conjIt(Object form) {
        if(form == null
           || !(form.equals(RT.STACK_VOID))) {
            this.stack = (IPersistentStack) CLOJURE_CONJ.invoke(this.stack, form);
        }
        return this.stack;
    }

    /**
     * Like Clojure's peek, but throws an exception if the stack is empty.
     */
    public Object peekSafe() {
        if (this.stack.count() == 0)
            throw new StackUnderflowException(STACK_UNDERFLOW_MSG);
        return this.stack.peek();
    }

    public Object peek() {
        return this.stack.peek();
    }

    public IPersistentStack pop() {
        try {
            return this.stack.pop();
        } catch(IllegalStateException e) {
            throw new StackUnderflowException(STACK_UNDERFLOW_MSG, e);
        }
    }

    public IPersistentStack popMutable() {
        try {
            this.stack = this.stack.pop();
            return this.stack;
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
    public Object popIt() {
        Object item = stack.peek();
        popMutable();
        return item;
    }

    public IPersistentStack clear() {
        this.stack = (IPersistentStack) PersistentVector.EMPTY;
        return this.stack;
    }

    public IPersistentCollection empty() {
        return this.stack.empty();
    }

    public int count() {
        return stack.count();
    }

    public ISeq seq() {
        return stack.seq();
    }

    /**
     * Return the raw, underlying stack used for the implementation
     * of this class.
     */
    public IPersistentStack getStack() {
        return this.stack;
    }

    public IPersistentCollection cons(Object o) {
        return this.stack.cons(o);
    }

    public boolean equiv(Object o) {
        return this.stack.equiv(o);
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
