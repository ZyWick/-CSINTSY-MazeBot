public class Node {
    private String action;
    private Node left = null;
    private Node right = null;


    public Node(String action){
        this.action = action;
    }

    public String getAction() {
        return this.action;
    }

    public Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }

    public void setLeft(Node node) {
        this.left = node;
    }

    public void setRight(Node node) {
        this.right = node;
    }
}
