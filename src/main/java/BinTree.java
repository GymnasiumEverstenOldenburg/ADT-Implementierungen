package main.java;

/**
 * Implementierung der Klasse BinTree nach den Vorgaben des KCs der gymnasialen Oberstufe (Niedersachsen).
 *
 * @author Alexander Reimer (GitHub: Alexander-Reimer, email: alexander.reimer2357@gmail.com)
 * @author Yannick Weigert (GitHub: GelbEinhalb, email: yannick@gelbeinhalb.com)
 * @version 09.03.2024
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
     * Ein Baum wird erzeugt. Der Baum besitzt keine Teilbäume. Die Wurzel besitzt keinen Inhaltswert.
     */
    public BinTree() {
        // Hier passiert nichts
    }

    /**
     * Ein Baum wird erzeugt. Der Baum besitzt keine Teilbäume. Die Wurzel erhält den übergebenen Inhalt als
     * Wert.
     *
     * @param inhalt Inhalt der Wurzel
     */
    public BinTree(Type inhalt) {
        setItem(inhalt);
    }

    /**
     * Wenn die Wurzel des Baums einen Inhaltswert besitzt, wird der Wert wahr
     * zurückgegeben, sonst der Wert falsch.
     *
     * @return Ob die Wurzel einen Inhaltswert besitzt.
     */
    public boolean hasItem() {
        return this.content != null;
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
     * Die Wurzel des Baums erhält den übergebenen Inhalt als Wert.
     * 
     * @param inhalt Inhalt der Wurzel.
     */
    public void setItem(Type inhalt) {
        this.content = inhalt;
    }

    /**
     * Die Operation löscht den Inhaltswert der Wurzel des Baums.
     */
    public void deleteItem() {
        this.content = null;
    }

    /**
     * Wenn der Baum keine Teilbäume besitzt, die Wurzel des Baums also ein Blatt
     * ist, wird der Wert wahr zurückgegeben, sonst der Wert falsch.
     *
     * @return Ob der Baum ein Blatt ist.
     */
    public boolean isLeaf() {
        return (!hasLeft()) && (!hasRight());
    }

    /**
     * Wenn der Baum einen linken Teilbaum besitzt, wird der Wert wahr
     * zurückgegeben, sonst der Wert falsch.
     *
     * @return Ob der Baum einen linken Teilbaum besitzt.
     */
    public boolean hasLeft() {
        return this.left != null;
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
     * Die Operation löscht den linken Teilbaum.
     */
    public void deleteLeft() {
        this.left = null;
    }

    /**
     * Wenn der Baum einen rechten Teilbaum besitzt, wird der Wert wahr
     * zurückgegeben, sonst der Wert falsch.
     *
     * @return Ob der Baum einen rechten Teilbaum besitzt.
     */
    public boolean hasRight() {
        return this.right != null;
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
     * Die Operation löscht den rechten Teilbaum.
     */
    public void deleteRight() {
        this.right = null;
    }

}
