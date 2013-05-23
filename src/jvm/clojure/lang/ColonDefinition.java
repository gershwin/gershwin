package clojure.lang;

public class ColonDefinition extends PersistentVector {
    public ColonDefinition(int cnt, int shift, Node root, Object[] tail) {
        super(cnt, shift, root, tail);
    }

    public ColonDefinition(IPersistentMap meta, int cnt, int shift, Node root, Object[] tail) {
        super(meta, cnt, shift, root, tail);
    }
}
