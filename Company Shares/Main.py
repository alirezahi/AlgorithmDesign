num_ins = 300
table = [[0 for i in range(num_ins)]for j in range(num_ins)]
table_check = [[] for i in range(num_ins)]
for i in range(int(input())):
    info = input().split(' ')
    if int(info[2])>50:
        table_check[int(info[0])].append(int(info[1]))
    table[int(info[0])][int(info[1])] = int(info[2])
for i in range(1, num_ins):
    while len(table_check[i])>0:
        for z in range(num_ins):
            tmp_var = table[i][z]
            table[i][z] += table[table_check[i][0]][z]
            if tmp_var<=50 and table[i][z]>50:
                table_check[i].append(z)
        del table_check[i][0]


for i in range(num_ins):
    for j in range(num_ins):
        if table[i][j]>50 and i!=j:
            print(str(i)+' '+str(j))