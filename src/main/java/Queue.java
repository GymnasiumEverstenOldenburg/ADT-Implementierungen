package main.java;

/**
 * Implementierung der Klasse Queue nach den Vorgaben des KCs der gymnasialen Oberstufe (Niedersachsen).
 *
 * @author Alexander Reimer (GitHub: Alexander-Reimer, email: alexander.reimer2357@gmail.com)
 * @author Yannick Weigert (GitHub: GelbEinhalb, email: yannick@gelbeinhalb.com)
 * @version 09.03.2024
 *
 */
public class Queue<Type> {

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

    /**
     * Eine leere Schlange wird angelegt.
     */
    public Queue() {
        // Hier passiert nichts
    }

    /**
     * Wenn die Schlange kein Element enthält, wird der Wert wahr zurückgegeben,
     * sonst der Wert falsch.
     * 
     * @return Ob die Schlange leer ist.
     */
    public boolean isEmpty() {
        return this.first == null;
    }

    /**
     * Der Inhalt des vordersten Elements der Schlange wird zurückgegeben, das
     * Element aber nicht entnommen.
     * 
     * @return Inhalt des vordersten Elements.
     */
    public Type head() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Die Schlange ist leer!");
        }

        return this.first.getContent();
    }

    /**
     * Ein neues Element mit dem übergebenen Inhalt wird am Ende der dynamischen
     * Reihung angefügt.
     * 
     * @param inhalt Das Element, das hinzugefügt wird.
     */
    public void enqueue(Type inhalt) {

        if (this.isEmpty()) {
            this.first = new Item<>(inhalt);
            this.last = this.first;
            return;
        }

        this.last.setNext(new Item<>(inhalt));
        this.last = this.last.getNext();
    }

    /**
     * Das vorderste Element wird entnommen. Der Inhalt dieses Elements wird
     * zurückgegeben.
     * 
     * @return Inhalt des vordersten Elements.
     */
    public Type dequeue() {
        Type content = head();
        this.first = this.first.getNext();
        // Wenn Nachfolger von first null ist, dann war es das letzte Element,
        // also muss Zeiger auf last auch auf null gesetzt werden
        if (this.first == null) {
            this.last = null;
        }
        return content;
    }

}