def find_zero(table):
    for i in range(9):
        for j in range(9):
            if table[i][j] == 0:
                return i,j
    return -1,-1

def solve(table):
    return 0

table = [[0 for i in range(9)] for j in range(9)]
for i in range(9):
    line = input().split(' ')
    for j in range(9):
        table[i][j] = line[j]

table = solve(table)