import java.util.ArrayList;

public class Tree {

    Node root;

    //equivalent to create()
    public Tree () {
        this.root = null;
    }

    public void printTree(){
        if(root != null){
            printChild(root.getLeft());
            System.out.println("Kmer: " + root.getKmer());
            printChild(root.getRight());
        }
    }

    private void printChild(Node node){
        if(node != null){
            printChild(node.getLeft());
            System.out.println("Kmer: " + node.getKmer());
            printChild(node.getRight());
        }
    }

    public ArrayList<Kmer> generateKmerDist() {
        ArrayList<Kmer> kmerList = new ArrayList<Kmer>();
            kmerList.add(new Kmer(root.getKmer()));

            generateKmerDistChild(root.getLeft(), kmerList);
            generateKmerDistChild(root.getRight(), kmerList);
        
        return kmerList;
    }
    
    private void generateKmerDistChild(Node node, ArrayList<Kmer> kmerList) {
        if(node != null) {
            boolean result = false;
            for (Kmer theKmer : kmerList)
                if (theKmer.getKmerString().equals(node.getKmer())) {
                    theKmer.addOccurences();
                    result = true;
                }
            if(result == false) 
                kmerList.add(new Kmer(node.getKmer()));
            generateKmerDistChild(node.getLeft(), kmerList);
            generateKmerDistChild(node.getRight(), kmerList);
        }
    }

    public void insert(String newKmer) {
            if(root == null){
                root = new Node(newKmer);
            } else if(root.getKmer().compareTo(newKmer)>0){
                // System.out.println("went left");
                root.setLeft(insertKid(root.getLeft(), newKmer));
            } else {
                // System.out.println("went right");
                root.setRight(insertKid(root.getRight(), newKmer));
            }
    }

    private Node insertKid(Node currentNode, String newKmer) {
        if(currentNode == null){
            currentNode = new Node(newKmer);
        } else if(currentNode.getKmer().compareTo(newKmer)>0){
            // System.out.println("went left");
            currentNode.setLeft(insertKid(currentNode.getLeft(), newKmer));
        } else {
            // System.out.println("went right");
            currentNode.setRight(insertKid(currentNode.getRight(), newKmer));
        }
        return currentNode;   
    }

    public boolean search (String kmer) {
        boolean result = false;

        if(root.getKmer().equals(kmer)){
            result = true;
        } else if(root.getKmer().compareTo(kmer)>0 && root.getLeft() != null){
            result = search(root.getLeft(), kmer);
        } else if(root.getKmer().compareTo(kmer)<0 && root.getRight() != null) {
            result = search(root.getRight(), kmer);
        }
        return result;        
    }

    private  boolean search(Node node, String kmer){
        boolean result = false;

        if(node.getKmer().equals(kmer)){
            result = true;
        } else if(node.getKmer().compareTo(kmer)>0 && node.getLeft() != null){
            result = search(node.getLeft(), kmer);
        } else if(node.getKmer().compareTo(kmer)<0 && node.getRight() != null) {
            result = search(node.getRight(), kmer);
        }
        return result;
    }

    public void destroy() {
        root = null;
    }

}