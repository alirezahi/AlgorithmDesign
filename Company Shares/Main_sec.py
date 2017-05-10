n = int(input())
num_ins = 150
comp_table = [[i] for i in range(num_ins)]
table = [[0 for i in range(num_ins)]for j in range(num_ins)]
for i in range(n):
    a = str(input()).split(' ')
    if int(a[2])>50:
        comp_table[int(a[0])-1].append(int(a[1])-1)
    table[int(a[0])-1][int(a[1])-1] = int(a[2])
for i in comp_table:
    tmp = []
    for j in range(num_ins):
        if j not in comp_table:
            sum = 0
            for z in i:
                sum += table[z][j]
            if sum > 50:
                tmp.append(j)
    i += tmp
for i in range(num_ins):
    for j in list(set(comp_table[i])):
        if j!=i:
            print(str(i+1) + " " + str(j+1))