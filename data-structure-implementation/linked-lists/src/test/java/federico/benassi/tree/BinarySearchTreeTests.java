package federico.benassi.tree;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTreeTests {

    @Test
    public void givenBinarySearchTreeAddMethodShouldAddTheValue(){
        BinarySearchTree<String> binaryTree = new BinarySearchTree<>();

        binaryTree.add("Federico");
        binaryTree.add("Benassi");
        binaryTree.add("Alice");
        binaryTree.add("Gauss");
        Assert.assertTrue(binaryTree.search("Federico"));
        Assert.assertTrue(binaryTree.search("Benassi"));
        Assert.assertTrue(binaryTree.search("Alice"));
        Assert.assertTrue(binaryTree.search("Gauss"));
    }


    @Test
    public void GivenBinarySearchTreeDeleteMethodShouldDeleteRootWithNoChild(){
        BinarySearchTree<String> binaryTree = new BinarySearchTree<>();

        binaryTree.add("Federico");
        binaryTree.delete("Federico");
        Assert.assertFalse(binaryTree.search("Federico"));
    }

    @Test
    public void GivenBinarySearchTreeDeleteMethodShouldDeleteTheNodeWithNoChild(){
        BinarySearchTree<String> binaryTree = new BinarySearchTree<>();

        binaryTree.add("Federico");
        binaryTree.add("Annunziata");
        binaryTree.add("Benassi");
        binaryTree.delete("Benassi");
        Assert.assertFalse(binaryTree.search("Benassi"));
    }

    @Test
    public void GivenBinarySearchTreeDeleteMethodShouldDeleteRootWithOneChild(){
        BinarySearchTree<String> binaryTree = new BinarySearchTree<>();

        binaryTree.add("Federico");
        binaryTree.add("Gauss");
        binaryTree.delete("Federico");
        Assert.assertFalse(binaryTree.search("Federico"));
        Assert.assertTrue(binaryTree.search("Gauss"));
    }

    @Test
    public void GivenBinarySearchTreeDeleteMethodShouldDeleteTheNodeWithOneChild(){
        BinarySearchTree<String> binaryTree = new BinarySearchTree<>();

        binaryTree.add("Federico");
        binaryTree.add("Annunziata");
        binaryTree.add("Benassi");
        binaryTree.delete("Annunziata");
        Assert.assertTrue(binaryTree.search("Federico"));
        Assert.assertTrue(binaryTree.search("Benassi"));
    }

    @Test
    public void GivenBinarySearchTreeDeleteMethodShouldDeleteRootWithTwoChild(){
        BinarySearchTree<String> binaryTree = new BinarySearchTree<>();

        binaryTree.add("Federico");
        binaryTree.add("Gauss");
        binaryTree.add("Annunziata");
        binaryTree.delete("Federico");
        Assert.assertFalse(binaryTree.search("Federico"));
        Assert.assertTrue(binaryTree.search("Gauss"));
        Assert.assertTrue(binaryTree.search("Annunziata"));
    }

    @Test
    public void GivenBinarySearchTreeDeleteMethodShouldDeleteNodeWithTwoChild(){
        BinarySearchTree<String> binaryTree = new BinarySearchTree<>();

        binaryTree.add("Federico");
        binaryTree.add("Annunziata");
        binaryTree.add("Benassi");
        binaryTree.add("Baba");
        binaryTree.delete("Annunziata");
        Assert.assertTrue(binaryTree.search("Federico"));
        Assert.assertTrue(binaryTree.search("Benassi"));
        Assert.assertTrue(binaryTree.search("Baba"));
    }
}
