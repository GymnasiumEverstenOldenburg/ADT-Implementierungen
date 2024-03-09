package main.java;

/**
 * Implementierung der Klasse BinTree nach den Vorgaben des KCs der gymnasialen Oberstufe (Niedersachsen).
 *
 * @author Alexander Reimer (GitHub: Alexander-Reimer, email: alexander.reimer2357@gmail.com)
 * @author Yannick Weigert (GitHub: GelbEinhalb, email: yannick@gelbeinhalb.com)
 * @version 06.03.2024
 *
 */
public class BinTree<Type> {

    private Type content;
    private BinTree<Type> left;
    private BinTree<Type> right;

    BinTree() {
        // Hier passiert nichts
    }

    BinTree(Type inhalt) {
        setItem(inhalt);
    }

    /**
     * Die Wurzel des Baums erhält den übergebenen Inhalt als Wert.
     * 
     * @param inhalt Inhalt der Wurzel.
     */
    void setItem(Type inhalt) {
        this.content = inhalt;
    }

    /**
     * Die Operation löscht den Inhaltswert der Wurzel des Baums.
     */
    void deleteItem() {
        this.content = null;
    }

    /**
     * Die Operation gibt den Inhaltswert der Wurzel des Baumes zurück.
     * 
     * @return Inhalt der Wurzel.
     */
    Type getItem() {
        return this.content;
    }

    /**
     * Wenn die Wurzel des Baums einen Inhaltswert besitzt, wird der Wert wahr
     * zurückgegeben, sonst der Wert falsch.
     * 
     * @return Ob die Wurzel einen Inhaltswert besitzt.
     */
    boolean hasItem() {
        return this.content != null;
    }

    /**
     * Der übergebene Baum wird als linker Teilbaum gesetzt.
     * 
     * @param b Neuer linker Teilbaum.
     */
    void setLeft(BinTree<Type> b) {
        this.left = b;
    }

    /**
     * Die Operation löscht den linken Teilbaum.
     */
    void deleteLeft() {
        this.left = null;
    }

    /**
     * Die Operation gibt den linken Teilbaum zurück.
     * 
     * @return Linker Teilbaum.
     */
    BinTree<Type> getLeft() {
        return this.left;
    }

    /**
     * Wenn der Baum einen linken Teilbaum besitzt, wird der Wert wahr
     * zurückgegeben, sonst der Wert falsch.
     * 
     * @return Ob der Baum einen linken Teilbaum besitzt.
     */
    boolean hasLeft() {
        return this.left != null;
    }

    /**
     * Der übergebene Baum wird als rechter Teilbaum gesetzt.
     * 
     * @param b Neuer rechter Teilbaum.
     */
    void setRight(BinTree<Type> b) {
        this.right = b;
    }

    /**
     * Die Operation löscht den rechten Teilbaum.
     */
    void deleteRight() {
        this.right = null;
    }

    /**
     * Die Operation gibt den rechten Teilbaum zurück.
     * 
     * @return Rechter Teilbaum.
     */
    BinTree<Type> getRight() {
        return this.right;
    }

    /**
     * Wenn der Baum einen rechten Teilbaum besitzt, wird der Wert wahr
     * zurückgegeben, sonst der Wert falsch.
     * 
     * @return Ob der Baum einen rechten Teilbaum besitzt.
     */
    boolean hasRight() {
        return this.right != null;
    }

    /**
     * Wenn der Baum keine Teilbäume besitzt, die Wurzel des Baums also ein Blatt
     * ist, wird der Wert wahr zurückgegeben, sonst der Wert falsch.
     * 
     * @return Ob der Baum ein Blatt ist.
     */
    boolean isLeaf() {
        return (!hasLeft()) && (!hasRight());
    }

}
