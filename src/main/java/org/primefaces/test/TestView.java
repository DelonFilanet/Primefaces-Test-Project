package org.primefaces.test;

import java.io.Serializable;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import lombok.Data;

@Data
@Named
@ViewScoped
public class TestView implements Serializable {

    private String string;
    private List<TestObject> testTableList;
    private List<TestObject> filteredList;
    private TreeNode<String> testTreeNode;
    private TreeNode<String> selectedNode;

    @PostConstruct
    public void init() {
        string = "Welcome to PrimeFaces!!!";
        testTableList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            testTableList.addAll(Arrays.asList(new TestObject("Thriller" + " " + i, "Michael Jackson" + " " + i, 1982),
                    new TestObject("Back in Black" + " " + i, "AC/DC" + " " + i, 1980),
                    new TestObject("The Bodyguard" + " " + i, "Whitney Houston" + " " + i, 1992),
                    new TestObject("The Dark Side of the Moon" + " " + i, "Pink Floyd" + " " + i, 1973)));
        }
        testTreeNode = new DefaultTreeNode<>("", null);
        var childNode1 = new DefaultTreeNode<>("Level 1", testTreeNode);
        var childNode2 = new DefaultTreeNode<>("Level 2", childNode1);
        new DefaultTreeNode<>("Level 3", childNode2);

    }

    public List<TestObject> getTestTableList() {
        return testTableList;
    }

    public void setTestTableList(List<TestObject> list) {
        testTableList = list;
    }

    public List<TestObject> getFilteredList() {
        return filteredList;
    }

    public void setFilteredList(List<TestObject> list) {
        filteredList = list;
    }

    public TreeNode<String> getTestTreeNode() {
        return testTreeNode;
    }

    public void setTestTreeNode(TreeNode<String> node) {
        testTreeNode = node;
    }

    public TreeNode<String> getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode<String> node) {
        selectedNode = node;
    }

}
