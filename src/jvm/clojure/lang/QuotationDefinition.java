package clojure.lang;

public class QuotationDefinition extends PersistentVector {
    public QuotationDefinition(int cnt, int shift, Node root, Object[] tail) {
        super(cnt, shift, root, tail);
    }

    public QuotationDefinition(IPersistentMap meta, int cnt, int shift, Node root, Object[] tail) {
        super(meta, cnt, shift, root, tail);
    }
}
