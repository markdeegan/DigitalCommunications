// Java program for the above approach:
import java.util.*;

// Class to represent huffman tree 
class Node {
	int data;
	Node left, right;
	Node(int x) {
		data = x;
		left = null;
		right = null;
	}
}

class GfG {

	// Function to traverse tree in preorder 
	// manner and push the huffman representation 
	// of each character.
	static void preOrder(Node root, ArrayList<String> ans, String curr) {
		if (root == null) return;

		// Leaf node represents a character.
		if (root.left == null && root.right == null) {
			ans.add(curr);
			return;
		}

		preOrder(root.left, ans, curr + '0');
		preOrder(root.right, ans, curr + '1');
	}

	static ArrayList<String> huffmanCodes(String s, int[] freq) {
		
		int n = s.length();
		
		// Min heap for node class.
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
		    if (a.data < b.data) return -1;
		    return 1;
		});
		for (int i = 0; i < n; i++) {
			Node tmp = new Node(freq[i]);
			pq.add(tmp);
		}

		// Construct huffman tree.
		while (pq.size() >= 2) {

			// Left node 
			Node l = pq.poll();

			// Right node 
			Node r = pq.poll();

			Node newNode = new Node(l.data + r.data);
			newNode.left = l;
			newNode.right = r;

			pq.add(newNode);
		}

		Node root = pq.poll();
		ArrayList<String> ans = new ArrayList<>();
		preOrder(root, ans, "");
		return ans;
	}

	public static void main(String[] args) {
		String s = "abcdef";
		int[] freq = {5, 9, 12, 13, 16, 45};
		ArrayList<String> ans = huffmanCodes(s, freq);
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
	}
}
