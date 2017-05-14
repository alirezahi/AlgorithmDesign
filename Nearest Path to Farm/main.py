
from collections import defaultdict
from heapq import *
max_num = 99999
edges = []

def dijkstra(f, t):
    graph_list = defaultdict(list)
    for l,r,c in edges:
        graph_list[l].append((c,r)) 
    q =  [(0,f,())]
    visited = set()
    while q:
        (cost,v1,path) = heappop(q)
        if v1 not in visited:
            visited.add(v1)
            path = (v1, path)
            if v1 == t:
                return (cost, path)
            for c, v2 in graph_list.get(v1, ()):
                if v2 not in visited:
                    heappush(q, (cost+c, v2, path))

    return max_num

if __name__ == "__main__":
    n = int(input())
    list_node = []
    for i in range(n):
        a = input().split(' ')
        if a[0] not in list_node and a[0] != 'Z' and a[0]>='A' and a[0]<'Z':
            list_node.append(a[0])
        if a[1] not in list_node and a[1] != 'Z' and a[1]>='A' and a[1]<'Z':
            list_node.append(a[1])
        edges.append((a[0],a[1],int(a[2])))
        edges.append((a[1],a[0],int(a[2])))
    min_num = max_num
    min_let = 'Z'
    for i in list_node:
        if min_num>dijkstra('Z',i)[0]:
            min_num = dijkstra('Z',i)[0]
            min_let = i
    print(min_let+' '+str(min_num))