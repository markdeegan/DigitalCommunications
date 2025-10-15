# DigitalCommunications

## Huffman Coding
[Geeks for Geeks page](https://www.geeksforgeeks.org/dsa/huffman-coding-greedy-algo-3/)
Two steps:
* Build a Huffman Tree from input characters.
* Traverse the Huffman Tree and assign codes to characters
From GfG
*Algorithm:
The method which is used to construct optimal prefix code is called Huffman coding. This algorithm builds a tree in bottom up manner using a priority queue (or heap)

**Steps to build Huffman Tree
Input is an array of unique characters along with their frequency of occurrences and output is Huffman Tree. 

Create a leaf node for each unique character and build a min heap of all leaf nodes (Min Heap is used as a priority queue. The value of frequency field is used to compare two nodes in min heap. Initially, the least frequent character is at root)
Extract two nodes with the minimum frequency from the min heap. 
Create a new internal node with a frequency equal to the sum of the two nodes frequencies. Make the first extracted node as its left child and the other extracted node as its right child. Add this node to the min heap.
Repeat steps#2 and #3 until the heap contains only one node. The remaining node is the root node and the tree is complete.
