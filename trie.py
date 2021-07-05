class Node:
    def __init__(self, key, data=None):
        self.key = key
        self.data = data
        self.child = {}


class Trie:
    def __init__(self):
        self.head = Node(None)

    def insert(self, string: str) -> None:
        cur_node = self.head
        for char in string:
            if char not in cur_node.child:
                cur_node.child[char] = Node(char)
            cur_node = cur_node.child[char]
        cur_node.data = string

    def search(self, string: str) -> bool:
        cur_node = self.head
        for char in string:
            if char not in cur_node.child:
                return False
            cur_node = cur_node.child[char]
        if cur_node.data is not None:
            return True
        return False
