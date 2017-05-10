
n = int(input())
def partition(n):
    sum = int(n * (n + 1) / 2)
    if (sum % 2 != 0):
        print(0)
    else:
        sum = int(sum / 2)
        my_arr = []
        for i in range(n+1):
            my_arr.append([])
            for j in range(sum+1):
                my_arr[i].append(0)
        for i in range(n + 1):
            my_arr[i][0] = 1

        for i in range(1, n + 1):
            for k in range(1, sum + 1):
                if j < i:
                    my_arr[i][k] = my_arr[i - 1][k]
                else:
                    my_arr[i][k] = my_arr[i - 1][k] + my_arr[i - 1][k - i]
        count = my_arr[n][sum] / 2
        print(int(count))

partition(n)
