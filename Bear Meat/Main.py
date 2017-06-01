n = int(input())
total = 0
for i in range(1,n+1):
    a = i + 0
    while a%2 is not 1:
        a = int(a/2)
        total += 1
    total += 1
print(total)
