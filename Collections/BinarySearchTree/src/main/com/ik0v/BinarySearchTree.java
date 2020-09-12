package main.com.ik0v;

class BinarySearchTree {
  private SubTree root;
  public String toString() {
    if (root != null) {
      return root.toString();
    } else {
      return null;
    }
  }

  public void putValueInn(int value) {
    if (root != null) {
      root.putValueInn(value);
    } else {
      root = new SubTree(value, null);
    }
  }

  public SubTree searchForValue(int searchValue) {
    if (root == null) {
      return null;
    }
    SubTree searchTree = root.searchForValue(searchValue);
    if(searchTree != null) {
      return searchTree;
    } else return null;
  }

  public boolean deleteValue(int deleteValue) {
    if (root == null) {
      return false;
    } if(root.getValue() == deleteValue) {
      root = null;
      return true;
    }
    SubTree searchTree = searchForValue(deleteValue);
    if(searchTree != null) {
      return searchTree.deleteValue(deleteValue);
    } else return false;
  }

}