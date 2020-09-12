package main.com.ik0v;
/**
 * BinaryTreeClient.java - book "Programmering i Java", 4.utgave.
 * Section 21, challenge nr.2
 * Client program for binary search tree
 */

class BinaryTreeClient {
  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree();
    System.out.println("Tree in sorted sequence: " + tree.toString());
    tree.putValueInn(5);
    tree.putValueInn(3);
    tree.putValueInn(1);
    tree.putValueInn(2);
    tree.putValueInn(4);
    tree.putValueInn(7);
    System.out.println("Tree in sorted sequence: " + tree.toString());
    String result = (tree.searchForValue(2) != null)? "true" : "false";
    System.out.println("Is there nr. 2 in tree: " + result);
    result = (tree.searchForValue(6) != null)? "true" : "false";
    System.out.println("Is there nr. 6 in tree: " + result);
    System.out.println("Delete 2 from  tree: " + tree.deleteValue(2));
    System.out.println("Tree in sorted sequence: " + tree.toString());
    System.out.println("Delete 3 from  tree: " + tree.deleteValue(3));
    System.out.println("Tree in sorted sequence: " + tree.toString());
    System.out.println("Delete 5 from  tree: " + tree.deleteValue(5));
    System.out.println("Tree in sorted sequence: " + tree.toString());
  }
}
