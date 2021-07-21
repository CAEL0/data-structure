"""
In computer science, a segment tree, also known as a statistic tree, is a tree data structure used for storing
information about intervals, or segments. It allows querying which of the stored segments contain a given point. It
is, in principle, a static structure; that is, it's a structure that cannot be modified once it's built. A similar
data structure is the interval tree. A segment tree for a set I of n intervals uses O(n log n) storage and can be
built in O(n log n) time. Segment trees support searching for all the intervals that contain a query point in time O(
log n + k), k being the number of retrieved intervals or segments.
"""

import sys
from math import log2, ceil

n = int(sys.stdin.readline())
height = ceil(log2(n))
tree = [0] * 2 ** (height + 1)

for i in range(n):
    tree[2 ** height + i] = int(sys.stdin.readline())

for h in range(height - 1, -1, -1):
    for i in range(2 ** h, 2 ** (h + 1)):
        tree[i] = tree[2 * i] + tree[2 * i + 1]


def partial_sum(a: int, b: int) -> int:
    res = 0
    a += 2 ** height - 1
    b += 2 ** height - 1
    while a <= b:
        if a % 2:
            res += tree[a]
            a += 1
        if b % 2 == 0:
            res += tree[b]
            b -= 1
        a //= 2
        b //= 2

    return res


def change(k: int, c: int) -> None:
    idx = 2 ** height + k - 1
    gap = tree[idx] - c
    while idx >= 1:
        tree[idx] -= gap
        idx //= 2
