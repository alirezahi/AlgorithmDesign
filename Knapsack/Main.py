w = int(input())
n = int(input())
c = ([0 for j in range(w+1)] for i in range(n+1))
c = list(c)
d = ([[0] for j in range(2)] for i in range(n))
d = list(d)

for i in range(n):
    a = input()
    d[i][0] = int(a.split(' ')[0])
    d[i][1] = int(a.split(' ')[1])
for i in range(1,n+1):
    for e in range(0,w+1):
        if d[i-1][0] <= e:
            if d[i-1][1] + c[i-1][e-d[i-1][0]] > c[i-1][e]:
                c[i][e] = d[i-1][1] + c[i-1][e-d[i-1][0]]
            else:
                c[i][e] = c[i-1][e]
        else:
            c[i][e] = c[i-1][e]
print(c[n][w])
