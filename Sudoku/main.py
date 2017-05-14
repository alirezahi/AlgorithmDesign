def print_table(table):
    for i in range(9):
        for j in range(9):
            print(table[i][j],end=' ')
        print()
def find_zero(table):
    for i in range(9):
        for j in range(9):
            if table[i][j] == 0:
                return i,j
    return -1,-1

def row_okay(test_num,row,col,table):
    for i in range(9):
        if i!=col and test_num == table[row][i]:
            return False
    return True

def col_okay(test_num,row,col,table):
    for i in range(9):
        if i!=row and test_num == table[i][col]:
            return False
    return True

def round_okay(test_num,row,col,table):
    for i in range(int(row/3)*3,int(row/3)*3+3):
        for j in range(int(col/3) * 3, int(col/3) * 3 + 3):
            if not(i==row and j==col) and test_num==table[i][j]:
                return False
    return True

def ok(test_num,row,col,table):
    if col_okay(test_num,row,col,table) and row_okay(test_num,row,col,table) and round_okay(test_num,row,col,table):
        return True
    return False

def solve(table):
    i,j = find_zero(table)
    if i+j == -2:
        print_table(table)
        return True
    for z in range(1,10):
        if ok(z,i,j,table):
            table[i][j]=z
            if not solve(table):
                table[i][j]=0
            else:
                return True
    return False

table = [[0 for i in range(9)] for j in range(9)]
for i in range(9):
    line = input().split(' ')
    for j in range(9):
        table[i][j] = int(line[j])

solve(table)