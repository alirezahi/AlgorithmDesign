def count(S, m, n):

    table = [0 for k in range(n+1)]

    table[0] = 1

    for i in range(0,m):
        for j in range(S[i],n+1):
            table[j] += table[j-S[i]]

    return table[n]%1000000


input_n = str(input()).split(' ')
v = int(input_n[0])
n = int(input_n[1])

arr = []
for i in input().split(' '):
    arr.append(int(i))
arr.sort()
print(count(arr, v, n))
