import sys
from math import log2, ceil

n = int(sys.stdin.readline())
height = ceil(log2(n))
tree = [0] * 2 ** (height + 1)
lazy = [0] * 2 ** (height + 1)

for i in range(n):
    tree[2 ** height + i] = int(sys.stdin.readline())

for h in range(height - 1, -1, -1):
    for i in range(2 ** h, 2 ** (h + 1)):
        tree[i] = tree[2 * i] + tree[2 * i + 1]


def partial_sum(a: int, b: int, idx=1) -> int:
    level = 2 ** int(log2(idx))
    length = (2 ** height) // level
    start = (idx % level) * length
    mid = start + length // 2

    if lazy[idx]:
        tree[idx] += lazy[idx] * length
        if length > 2:
            lazy[2 * idx] += lazy[idx]
            lazy[2 * idx + 1] += lazy[idx]
        elif length == 2:
            tree[2 * idx] += lazy[idx]
            tree[2 * idx + 1] += lazy[idx]
        lazy[idx] = 0

    if (a == start) and (b == start + length - 1):
        return tree[idx] + length * lazy[idx]

    if b < mid:
        return partial_sum(a, b, 2 * idx)

    if mid <= a:
        return partial_sum(a, b, 2 * idx + 1)

    return partial_sum(a, mid - 1, 2 * idx) + partial_sum(mid, b, 2 * idx + 1)


def update(a: int, b: int, c: int, idx=1) -> None:
    level = 2 ** int(log2(idx))
    length = (2 ** height) // level
    start = (idx % level) * length
    mid = start + length // 2

    if lazy[idx]:
        tree[idx] += lazy[idx] * length
        if length > 2:
            lazy[2 * idx] += lazy[idx]
            lazy[2 * idx + 1] += lazy[idx]
        elif length == 2:
            tree[2 * idx] += lazy[idx]
            tree[2 * idx + 1] += lazy[idx]
        lazy[idx] = 0

    if (a == start) and (b == start + length - 1):
        if length == 1:
            tree[idx] += c
        else:
            lazy[idx] = c
        idx_ = idx
        while idx_ > 1:
            idx_ //= 2
            tree[idx_] += length * c

    elif b < mid:
        update(a, b, c, 2 * idx)

    elif mid <= a:
        update(a, b, c, 2 * idx + 1)

    else:
        update(a, mid - 1, c, 2 * idx)
        update(mid, b, c, 2 * idx + 1)
