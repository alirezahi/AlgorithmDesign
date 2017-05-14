def permutation(lst):

    if len(lst) == 0:
        return []

    if len(lst) == 1:
        return [lst]

    l = []
    for i in range(len(lst)):
        m = lst[i]
        remLst = lst[:i] + lst[i + 1:]
        for p in permutation(remLst):
            l.append([m] + p)
    return l


n = int(input())
data=[i for i in range(n)]
table = [[int(i) for i in input().split(' ')] for j in range(n)]
min_num = 99999
result = []
for p in permutation(data):
    if min_num>table[0][p[0]]+table[1][p[1]]+table[2][p[2]]+table[3][p[3]]:
        min_num = table[0][p[0]]+table[1][p[1]]+table[2][p[2]]+table[3][p[3]]
        result = p
for i in result:
    print(i)