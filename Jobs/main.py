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


data = [0,1,2,3]
table = [[9,2,7,8],[6,4,3,7],[5,8,1,8],[7,6,9,4]]
min_num = 99999
for p in permutation(data):
    min_num = min(table[0][p[0]]+table[1][p[1]]+table[2][p[2]]+table[3][p[3]],min_num)
print(min_num)