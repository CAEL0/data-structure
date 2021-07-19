"""
In computer science, a heap is a specialized tree-based data structure which is essentially an almost complete 
tree that satisfies the heap property: in a max heap, for any given node C, if P is a parent node of C, then the key 
(the value) of P is greater than or equal to the key of C. In a min heap, the key of P is less than or equal to the 
key of C. The node at the "top" of the heap (with no parents) is called the root node.
"""

import sys

array = [0]

while True:
    operation = int(sys.stdin.readline())
    idx = len(array)

    if operation:
        array.append(operation)
        while True:
            if idx == 1:
                break
            if array[idx] < array[idx // 2]:
                array[idx], array[idx // 2] = array[idx // 2], array[idx]
                idx //= 2
            else:
                break

    else:
        if len(array) == 1:
            print(0)
        elif len(array) == 2:
            print(array.pop())
        else:
            print(array[1])
            array[1] = array.pop()
            idx = 1
            while True:
                if len(array) <= 2 * idx:
                    break
                if len(array) == 2 * idx + 1:
                    if array[idx] > array[2 * idx]:
                        array[idx], array[2 * idx] = array[2 * idx], array[idx]
                    break
                if (array[idx] <= array[2 * idx]) and (array[idx] <= array[2 * idx + 1]):
                    break
                if array[idx] > array[2 * idx]:
                    if array[2 * idx] > array[2 * idx + 1]:
                        array[idx], array[2 * idx + 1] = array[2 * idx + 1], array[idx]
                        idx = 2 * idx + 1
                    else:
                        array[idx], array[2 * idx] = array[2 * idx], array[idx]
                        idx *= 2
                else:
                    array[idx], array[2 * idx + 1] = array[2 * idx + 1], array[idx]
                    idx = 2 * idx + 1
