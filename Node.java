public class Node {
    private String kmer;
    // private int frequency = 1;
    private Node left = null;
    private Node right = null;


    public Node(String kmer){
        this.kmer = kmer;
    }

    public String getKmer() {
        return this.kmer;
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
