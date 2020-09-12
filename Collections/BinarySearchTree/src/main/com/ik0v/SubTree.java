package main.com.ik0v;
/**
 * Class for parts of binary search tree.
 * Sub-trees, including blades,consist of new objects of that class.
 */

class SubTree {
  private SubTree rightTree = null;
  private SubTree leftTree = null;
  private SubTree parent = null;
  private int value = 0;

  public SubTree(int value) {
    this.value = value;
  }

  public SubTree getRightTree() {
    return rightTree;
  }

  public void setRightTree(SubTree rightTree) {
    this.rightTree = rightTree;
  }

  public SubTree getLeftTree() {
    return leftTree;
  }

  public void setLeftTree(SubTree leftTree) {
    this.leftTree = leftTree;
  }

  public int getValue() {
    return value;
  }

  public SubTree(int value, SubTree parent) {
    this.value = value;
    this.parent = parent;
  }

  /**
   * Method puts inn new value in this (sub)tree.
   */
  public void putValueInn(int nyVerdi) {
    if (value >= nyVerdi) {
      if (leftTree != null) {
        leftTree.putValueInn(nyVerdi);
      } else {
        leftTree = new SubTree(nyVerdi, this);
      }
    } else {
      if (rightTree != null) {
        rightTree.putValueInn(nyVerdi);
      } else {
        rightTree = new SubTree(nyVerdi, this);
      }
    }
  }

  /**
   * Method traverses tree infiks and returns text with
   * content, separated by whitespace.
   */
  public String toString () {
    String returnText = "";
    if (leftTree != null) {
      returnText = leftTree.toString() + " ";
    }
    returnText = returnText + value;
    if (rightTree != null) {
      returnText = returnText + " " + rightTree.toString();
    }
    return returnText;
  }

  /**
   * Method returns Subtree with provided value, if it finds in tree
   */
  public SubTree searchForValue(int searchValue) {
    if (searchValue == value) {
      return this;
    }
    if (value > searchValue) {
      if (leftTree != null) {
        return leftTree.searchForValue(searchValue);
      } else {
        return null;
      }
    } else {
      if (rightTree != null) {
        return rightTree.searchForValue(searchValue);
      } else {
        return null;
      }
    }
  }

  /**
   * Method deletes Subtree with provided value from the tree
   * If Subtree has one or more child, links to them are deleted firstly.
   *
   */
  public boolean deleteValue(int delValue) {
    if(leftTree != null) {
      setLeftTree(null);
    } if(rightTree != null) {
      setRightTree(null);
    }
    if(parent.getLeftTree() != null && parent.getLeftTree().getValue() == delValue) {
      parent.setLeftTree(null);
      return true;
    } else if (parent.getRightTree() != null && parent.getRightTree().getValue() == delValue) {
      parent.setRightTree(null);
      return true;
    }
    return false;
  }
}