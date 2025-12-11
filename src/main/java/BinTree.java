package main.java;

/**
 * Implementierung der Klasse BinTree nach den Vorgaben des KCs der gymnasialen
 * Oberstufe (Niedersachsen).
 *
 * @author Alexander Reimer (GitHub: Alexander-Reimer, email: alexander.reimer2357@gmail.com)
 * @author Yannick Weigert (GitHub: GelbEinhalb, email: mail@yannick-weigert.de)
 * @version 2025-09-04
 *
 * -- Neuste Version:
 * https://github.com/GymnasiumEverstenOldenburg/ADT-Implementierungen/blob/main/src/main/java/BinTree.java
 *
 */
public class BinTree<Type> {

    private Type content;
    private BinTree<Type> left;
    private BinTree<Type> right;

    /**
     * Ein leerer Baum wird erzeugt. Er besitzt keinen Inhalt und keine
     * Teilbäume.
     */
    public BinTree() {
        // Hier passiert nichts
    }

    /**
     * Ein Baum wird erzeugt. Die Wurzel erhält den übergebenen Inhalt als Wert.
     * Der Baum besitzt jeweils einen leeren Baum als linken und rechten
     * Teilbaum.
     *
     * @param inhalt Inhalt der Wurzel
     */
    public BinTree(Type inhalt) {
        this.setItem(inhalt);
        this.setLeft(new BinTree<Type>());
        this.setRight(new BinTree<Type>());
    }

    /**
     * Wenn der Baum ein leerer Baum ist, wird der Wert wahr zurückgegeben,
     * sonst der Wert falsch.
     *
     * @return Ob der Baum leer ist (weder Inhalt besitzt, noch Teilbäume hat)
     */
    public boolean isEmpty() {
        return this.content == null && this.getLeft() == null && this.getRight() == null;
    }

    /**
     * Die Operation gibt den Inhaltswert der Wurzel des Baumes zurück.
     *
     * @return Inhalt der Wurzel.
     */
    public Type getItem() {
        return this.content;
    }

    /**
     * Die Wurzel des Baums erhält den übergebenen Inhalt als Wert. Bei einem
     * leeren Baum wird zusätzlich als linker und rechter Teilbaum jeweils ein
     * leerer Baum gesetzt.
     *
     * @param inhalt Neuer Inhalt der Wurzel.
     */
    public void setItem(Type inhalt) {
        if (this.isEmpty()) {
            this.setLeft(new BinTree<Type>());
            this.setRight(new BinTree<Type>());
        }
        this.content = inhalt;
    }

    /**
     * Wenn der Baum jeweils einen leeren Baum als linken und rechten Teilbaum
     * besitzt, also ein Blatt ist, wird der Wert wahr zurückgegeben, sonst der
     * Wert falsch.
     *
     * @return Ob der Baum ein Blatt ist.
     */
    public boolean isLeaf() {
        return this.getLeft() != null && this.getLeft().isEmpty() 
            && this.getRight() != null && this.getRight().isEmpty();
    }

    /**
     * Die Operation gibt den linken Teilbaum zurück.
     *
     * @return Linker Teilbaum.
     */
    public BinTree<Type> getLeft() {
        return this.left;
    }

    /**
     * Der übergebene Baum wird als linker Teilbaum gesetzt.
     *
     * @param b Neuer linker Teilbaum.
     */
    public void setLeft(BinTree<Type> b) {
        this.left = b;
    }

    /**
     * Die Operation gibt den rechten Teilbaum zurück.
     *
     * @return Rechter Teilbaum.
     */
    public BinTree<Type> getRight() {
        return this.right;
    }

    /**
     * Der übergebene Baum wird als rechter Teilbaum gesetzt.
     * 
     * @param b Neuer rechter Teilbaum.
     */
    public void setRight(BinTree<Type> b) {
        this.right = b;
    }
    
    /**
     * Der Baum wird zu einem leeren Baum, d. h. er besitzt keinen Inhalt und keine Teilbäume.
     */
    public void setEmpty() {
        this.setItem(null);
        this.setLeft(null);
        this.setRight(null);
    }
    
}
