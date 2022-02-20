package questions.leetcode.scenerio;

import java.util.*;

public class DesignFileSystem {

    public DesignFileSystem() {
    }

    static TrieNode rootNode = new TrieNode();

    public static void main(String[] args) {
        String path = "";
        String content = "";

        List<String> stringList = listAll(path);
        System.out.println(stringList.size());

        mkDir(path);
        addContentToFile(path, content);

        String readContent = readContentFromFile(path);
        System.out.println(readContent);

    }

    private static String readContentFromFile(String path) {
        TrieNode currentNode = getCurrentNode(path);
        return currentNode.content;
    }

    private static TrieNode getCurrentNode(String path) {
        TrieNode currentNode = rootNode;
        String[] pathArray = path.split("/");
        for (String currentString : pathArray) {
            if (!currentNode.childrenMap.containsKey(currentString)) {
                currentNode.childrenMap.put(currentString, new TrieNode());
            }
            currentNode = currentNode.childrenMap.get(currentString);
        }
        return currentNode;
    }

    private static void addContentToFile(String path, String content) {
        TrieNode currentNode = getCurrentNode(path);
        if (currentNode.content == null) {
            currentNode.content = content;
        } else {
            currentNode.content += content;
        }
    }

    private static void mkDir(String path) {
        getCurrentNode(path);
    }

    private static List<String> listAll(String path) {
        TrieNode currentNode = rootNode;
        if (!path.equals("/")) {

            //find the directory
            String[] listItems = path.split("/");
            String currentString = null;
            for (int i = 0; i < listItems.length; i++) {
                currentString = listItems[i];
                currentNode = currentNode.childrenMap.get(currentString);

                //check if it is filePath
                if (i == listItems.length - 1 && null != currentNode.content) {
                    return Collections.singletonList(currentString);
                }
            }
        }
        List<String> children = new LinkedList<>(currentNode.childrenMap.keySet());
        Collections.sort(children);
        return children;
    }

    static class TrieNode {
        String content = null;
        Map<String, TrieNode> childrenMap = new HashMap<>();

        public TrieNode() {
        }

        public TrieNode(String content, Map<String, TrieNode> childrenMap) {
            this.content = content;
            this.childrenMap = childrenMap;
        }
    }
}
