number_n = int(input())
number_k = int(input())
c = [[0 for f in range(number_k+1)] for w in range(number_n+1)]
for i in range(number_n+1):
    c[i][0] = 1
for j in range(number_k+1):
    c[j][j] = 1
def combination(n,k):
    if c[n][k] == 0:
        c[n][k] = (combination(n-1,k) + combination(n-1,k-1))%1000000
    return c[n][k]
print(combination(number_n, number_k))
