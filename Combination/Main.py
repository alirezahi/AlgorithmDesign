def combination(n,r):
    comb_arr = [1]+[0]*r
    for i in range(n+1):
        z = min(i,r)
        if r + i - n > 1:
            w = r + i - n
        else:
            w = 1
        for j in range(z,w-2,-1):
            if j is 0 or j is i:
                comb_arr[j]=1
            else:
                comb_arr[j] = (comb_arr[j] + comb_arr[j-1])%1000000
        print(comb_arr)
    return comb_arr[r]

n = int(input())
r = int(input())

print(combination(n, r))
