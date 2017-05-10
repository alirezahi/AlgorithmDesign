V = 8
INF  = 99999
distances = []
def dfs(graph,start):
    visited , stack = [],[start]
    while stack:
        vertex = stack.pop()
        if vertex not in visited:
            visited.append(vertex)
            for i in range(len(graph[vertex])):
                if graph[vertex][i] > 0  and graph[vertex][i] < INF:
                    stack.append(i)
    visited.sort()
    return visited

def floydWarshall(graph):
    dist = graph
    for k in range(V):
        for i in range(V):
            for j in range(i+1,V):
                dist[i][j] = min(dist[min(i,j)][max(i,j)] ,dist[min(i,k)][max(i,k)]+ dist[min(k,j)][max(k,j)])
    return dist

def printSolution(dist):
    for i in range(V):
        for j in range(V):
            print(dist[i][j],end=' ')
        print()
    print()

def find_max_of_min(dist):
    min_num = 0
    for i in range(len(dist)):
        for j in range(i,len(dist[0])):
            if min_num<dist[i][j] and dist[i][j]!=INF:
                min_num = dist[i][j]
    return min_num

def find_max_dist(i,graph):
    tmp = 0
    for j in range(V):
        if graph[min(i,j)][max(i,j)] > tmp and graph[min(i,j)][max(i,j)]!= INF:
            tmp = graph[min(i,j)][max(i,j)]
    return tmp

V = int(input())
for i in range(V):
    distances.append([int(i) for i in input().split(' ')])
graph = []
for i in range(V):
    graph.append([int(letter) for letter in str(input())])
for i in range(len(graph)):
    for j in range(len(graph[0])):
        if i>j:
            graph[i][j] = INF
        elif i<j and graph[i][j] ==1:
            graph[i][j] = ((distances[i][0]-distances[j][0])**2+(distances[i][1]-distances[j][1])**2)**(1/2.0)
        elif i != j :
            graph[i][j] = INF
adj = dfs(graph, 0)
adj_sec = list(set([i for i in range(V)]) - set(adj))
result = 10000000
tmp_result = floydWarshall(graph)
check_result = find_max_of_min(graph)
final_res = INF
for i in adj:
    for j in adj_sec:
        tmp_new = ((distances[i][0]-distances[j][0])**2+(distances[i][1]-distances[j][1])**2)**(1/2.0)
        t_result = find_max_dist(i,graph) + find_max_dist(j,graph) + tmp_new
        if final_res>t_result:
            final_res = t_result
if check_result > final_res:
    final_res = check_result
print("%.6f" % final_res)

