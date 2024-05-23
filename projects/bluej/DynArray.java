
/**
 * Implementierung der Klasse DynArray nach den Vorgaben des KCs der gymnasialen Oberstufe (Niedersachsen).
 *
 * @author Alexander Reimer (GitHub: Alexander-Reimer, email: alexander.reimer2357@gmail.com)
 * @author Yannick Weigert (GitHub: GelbEinhalb, email: yannick@gelbeinhalb.com)
 * @version 09.03.2024
 *
 * -- Neuste Version:
 * https://github.com/GymnasiumEverstenOldenburg/ADT-Implementierungen/blob/main/src/main/java/DynArray.java
 *
 */
public class DynArray<Type> {

    public static class Item<Type> {

        private Item<Type> next;
        private Type content;

        public Item(Type content) {
            setContent(content);
        }

        public void setContent(Type content) {
            this.content = content;
        }

        public Type getContent() {
            return content;
        }

        public Item<Type> getNext() {
            return next;
        }

        public void setNext(Item<Type> next) {
            this.next = next;
        }

    }

    private Item<Type> first = null; // Das erste Element
    private Item<Type> last = null; // Das letzte Element
    private int length = 0; // Die Länge des DynArrays

    /**
     * Eine leere dynamische Reihung wird angelegt.
     */
    public DynArray() {
        // Hier passiert nichts
    }

    /**
     * Traversiere das DynArray bis zum index und gib das entsprechende Item-Objekt zurück.
     *
     * @param index (beginnend bei 0)
     * @return Item des DynArrays mit ggb. index.
     */
    private Item<Type> getItemClass(int index) {
        if (index >= this.length || index < 0) {
            throw new IllegalArgumentException("Ungültiger Index!");
        }
        Item<Type> current = this.first;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    /**
     * Wenn die dynamische Reihung kein Element enthält, wird der Wert wahr zurückgegeben, sonst der Wert falsch.
     *
     * @return Ob die Reihung Elemente enthält.
     */
    public boolean isEmpty() {
        return this.first == null;
    }

    /**
     * Der Inhalt des Elements an der Position index wird zurückgegeben.
     * 
     * @param index Der Index des Elements.
     * @return Inhalt des Elements an der Position index.
     */
    public Type getItem(int index) {
        return getItemClass(index).getContent();
    }

    /**
     * Ein neues Element mit dem übergebenen Inhalt wird am Ende der dynamischen Reihung angefügt.
     *
     * @param inhalt Das Element, das hinzugefügt wird.
     */
    public void append(Type inhalt) {
        this.length++;

        if (this.isEmpty()) {
            this.first = new Item<>(inhalt);
            this.last = this.first;
            return;
        }

        this.last.setNext(new Item<>(inhalt));
        this.last = this.last.getNext();
    }

    /**
     * Ein neues Element mit dem übergebenen Inhalt wird an der Position index in die dynamische Reihung eingefügt. Das
     * Element, das sich vorher an dieser Position befunden hat, und alle nachfolgenden werden nach hinten verschoben.
     * Entspricht der Wert von index der Länge der dynamischen Reihung, so wird ein neues Element am Ende der
     * dynamischen Reihung angefügt.
     *
     * @param index  Der Index an dem das Element eingefügt wird.
     * @param inhalt Das Element, das eingefügt werden soll.
     */
    public void insertAt(int index, Type inhalt) {
        Item<Type> previous = getItemClass(index - 1);
        Item<Type> newItem = new Item<>(inhalt);

        newItem.setNext(previous.getNext());
        previous.setNext(newItem);

        this.length++;
    }

    /**
     * Der Inhalt des Elementes an der Position index wird durch den übergebenen Inhalt ersetzt.
     *
     * @param index  Der Index an dem das existierende Element ersetzt werden soll.
     * @param inhalt Das Element, dass das aktuelle Element ersetzten soll.
     */
    public void setItem(int index, Type inhalt) {
        Item<Type> current = getItemClass(index);
        current.content = inhalt;
    }

    /**
     * Das Element an der Position index wird entfernt. Alle folgenden Elemente werden um eine Position nach vorne
     * geschoben.
     *
     * @param index Der Index an dem das Element gelöscht werden soll.
     */
    public void delete(int index) {
        if (this.length == 0) {
            throw new IllegalArgumentException("Die dynamische Reihung ist leer!");
        }
        if (index == 0) {
            if (this.length == 1) {
                this.first = null;
                this.last = null;
                this.length = 0;
                return;
            }
            this.first = this.first.getNext();
            this.length--;
            return;
        }
        Item<Type> previous = getItemClass(index - 1);
        Item<Type> current = previous.getNext();
        Item<Type> next = current.getNext();
        previous.setNext(next);
        this.length--;
    }

    /**
     * Die Anzahl der Elemente der dynamischen Reihung wird zurückgegeben.
     * 
     * @return Die Länge des DynArrays
     */
    public int getLength() {
        return this.length;
    }

}