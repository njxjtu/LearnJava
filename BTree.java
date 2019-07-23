class BNode{
	int t;
	int count;
	boolean leaf;
	int[] key ;
	BNode[] child;
	
	
	BNode(int input_t){
		this.t = input_t;
		this.count = 0;
		this.leaf = true;
		this.key = new int[input_t*2-1];
		this.child = new BNode[input_t*2];
	}
}
public class BTree {

	int t;
	BNode root;
	int level = 0;
	BTree(int input_t, BNode input_root){
		this.t = input_t;
		this.root = input_root;
	}
	
	public BNode BTreeSearch(BNode root, int targetInt){
		//Search in root node
		BNode match = null;
		for (int i = 0; i<root.count; i++){
			if (targetInt<root.key[i]){
				level++;
				match = BTreeSearch(root.child[i], targetInt);
			}
			else if (targetInt == root.key[i]){
				return root;
			}
			else System.out.println("carry on");
			
		}
		
		return match;
	}
	
	public static void main(String[] args){
/*	
 *  	Construct a BTree
 *  
		|7|9|
	  /   |   \
|1|3|4|  |8|  |10|16|18|40|
*/
		BNode input_root = new BNode(3);
		input_root.count = 2;
		input_root.leaf = false;
		input_root.key[0]=7;
		input_root.key[1]=9;
		input_root.child[0] = new BNode(3);
		input_root.child[0].count = 3;
		input_root.child[1] = new BNode(3);
		input_root.child[1].count = 1;
		input_root.child[2] = new BNode(3);
		input_root.child[2].count = 4;
		input_root.child[0].key[0] = 1;
		input_root.child[0].key[1] = 3;
		input_root.child[0].key[2] = 4;
		input_root.child[1].key[0] = 8;
		input_root.child[2].key[0] = 10;
		input_root.child[2].key[1] = 16;
		input_root.child[2].key[2] = 18;
		input_root.child[2].key[3] = 40;
		BTree testT = new BTree(3, input_root);
		
		//Search for 8
		BNode result;
		result = testT.BTreeSearch(input_root,8);
		if (result != null){
		   for (int j : result.key){
		      System.out.println(j);
		   }
		}
		else System.out.println("result is null");
		
	}
}
