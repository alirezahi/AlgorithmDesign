n = int(input())
a=[[],[]]
a[0] = [int(i) for i in input().split(' ')]
a[1] = [int(i) for i in input().split(' ')]
result = []
end_time = 0
for i in range(n):
    if end_time<=a[0][i]:
        end_time = a[1][i]
        result.append(i)
for i in result:
    print(i,end=' ')