/**
 * Implementierung der Klasse Stack nach den Vorgaben des KCs der gymnasialen Oberstufe (Niedersachsen).
 *
 * @author Alexander Reimer (GitHub: Alexander-Reimer, email: alexander.reimer2357@gmail.com)
 * @author Yannick Weigert (GitHub: GelbEinhalb, email: yannick@gelbeinhalb.com)
 * @version 09.03.2024
 *
 */
public class Stack<Type> {

    private static class Item<Type> {

        private Item<Type> below;
        private Type content;

        public Item(Type content) {
            setContent(content);
        }

        public void setContent(Type content) {
            this.content = content;
        }

        public Type getContent() {
            return this.content;
        }

        public Item<Type> getBelow() {
            return this.below;
        }

        public void setBelow(Item<Type> next) {
            this.below = next;
        }

    }

    private Item<Type> top = null; // Das oberste Element

    /**
     * Ein leerer Stapel wird angelegt.
     */
    public Stack() {
        // Hier passiert nichts
    }

    /**
     * Wenn der Stapel kein Element enthält, wird der Wert wahr zurückgegeben, sonst
     * der Wert falsch
     *
     * @return Ob der Stapel leer ist.
     */
    public boolean isEmpty() {
        return this.top == null;
    }

    /**
     * Der Inhalt des obersten Elements des Stapels wird zurückgegeben, das Element
     * aber nicht entnommen.
     *
     * @return Inhalt des obersten Elements.
     */
    public Type top() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Der Stapel ist leer!");
        }
        return this.top.getContent();
    }

    /**
     * Ein neues Element mit dem übergebenen Inhalt wird oben auf den Stapel gelegt.
     *
     * @param inhalt Inhalt des neuen Elements.
     */
    public void push(Type inhalt) {
        Item<Type> newItem = new Item<>(inhalt);
        newItem.setBelow(this.top);
        this.top = newItem;
    }

    /**
     * Das oberste Element des Stapels wird entnommen. Der Inhalt dieses Elements
     * wird zurückgegeben.
     * 
     * @return Inhalt des obersten Elements.
     */
    public Type pop() {
        Type content = top();
        this.top = this.top.getBelow();
        return content;
    }

}
