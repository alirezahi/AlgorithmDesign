import sys
def len_substring(primitives,string):
    result = 0
    table = [False for i in range(len(string)+1)]
    table[0] = True
    for i in range(1,len(string)+1):
        for j in range(len(primitives)):
            if i-len(primitives[j]) >= 0 and table[i-len(primitives[j])] and string[i-len(primitives[j]):i] == primitives[j]:
                table[i] = True
                result = i
    return result
a = []
for i in input().split(' '):
    a.append(str(i).lower())
z = input()
while z!='.':
    for i in z.split(' '):
        a.append(str(i).lower())
    z = input()
string = ''
for line in sys.stdin:
    for var in line.split():
        string = string+str(var).lower()
print(len_substring(a, string))
