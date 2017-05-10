max_num = 103
n = int(input())
my_list = [[0 for i in range(max_num)] for j in range(max_num)]
for i in range(n):
    a = str(input()).split(' ')
    my_list[int(a[0])-1][int(a[1])-1] = int(a[2])
result = []
for i in range(max_num-1,-1,-1):
    tmp_list = [j for j in my_list[i]]
    for j in range(max_num):
        if my_list[i][j]>50:
            for z in range(max_num):
                tmp_list[z] += my_list[j][z]
    for z in range(max_num):
        if tmp_list[z]>50 and z!=i:
            result.append([i+1,z+1])
result.sort()
for i in result:
    print(str(i[0]) + ' ' + str(i[1]))
