
public class Tree {

    Node root;

    //equivalent to create()
    public Tree () {
        this.root = null;
    }

    public void printTree(){
        if(root != null){
            printChild(root.getLeft());
            System.out.println("Action " + root.getAction());
            printChild(root.getRight());
        }
    }

    private void printChild(Node node){
        if(node != null){
            printChild(node.getLeft());
            System.out.println("Action: " + node.getAction());
            printChild(node.getRight());
        }
    }

    public void insert(String newAction) {
            if(root == null){
                root = new Node(newAction);
            } else if(root.getAction().compareTo(newAction)>0){
                // System.out.println("went left");
                root.setLeft(insertKid(root.getLeft(), newAction));
            } else {
                // System.out.println("went right");
                root.setRight(insertKid(root.getRight(), newAction));
            }
    }

    private Node insertKid(Node currentNode, String newAction) {
        if(currentNode == null){
            currentNode = new Node(newAction);
        } else if(currentNode.getAction().compareTo(newAction)>0){
            // System.out.println("went left");
            currentNode.setLeft(insertKid(currentNode.getLeft(), newAction));
        } else {
            // System.out.println("went right");
            currentNode.setRight(insertKid(currentNode.getRight(), newAction));
        }
        return currentNode;
    }

    public boolean search (String kmer) {
        boolean result = false;

        if(root.getAction().equals(kmer)){
            result = true;
        } else if(root.getAction().compareTo(kmer)>0 && root.getLeft() != null){
            result = search(root.getLeft(), kmer);
        } else if(root.getAction().compareTo(kmer)<0 && root.getRight() != null) {
            result = search(root.getRight(), kmer);
        }
        return result;
    }

    private  boolean search(Node node, String kmer){
        boolean result = false;

        if(node.getAction().equals(kmer)){
            result = true;
        } else if(node.getAction().compareTo(kmer)>0 && node.getLeft() != null){
            result = search(node.getLeft(), kmer);
        } else if(node.getAction().compareTo(kmer)<0 && node.getRight() != null) {
            result = search(node.getRight(), kmer);
        }
        return result;
    }

    public void destroy() {
        root = null;
    }

}
