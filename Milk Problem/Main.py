
input_number = input().split(' ')
a = int(input_number[0])
b = int(input_number[1])
c = int(input_number[2])

def merge(a,b):
    c = []
    while len(a) != 0 and len(b) != 0:
        if a[0] < b[0]:
            c.append(a[0])
            a.remove(a[0])
        else:
            c.append(b[0])
            b.remove(b[0])
    if len(a) == 0:
        c += b
    else:
        c += a
    return c


def mergesort(x):
    if len(x) == 0 or len(x) == 1:
        return x
    else:
        middle = int(len(x)/2)
        a = mergesort(x[:middle])
        b = mergesort(x[middle:])
        return merge(a,b)

def cal_milk_cap(g_a,g_b,g_c,list_of_state=[]):
    if g_a is not 0:
        if g_b is not b:
            if (b-g_b)>g_a and [0, g_b+g_a, g_c] not in list_of_state:
                list_of_state.append([0, g_b+g_a, g_c])
                list_of_state = cal_milk_cap(0, g_b+g_a, g_c,list_of_state)
            elif g_a-(b-g_b)> -1 and [g_a-(b-g_b), b, g_c] not in list_of_state:
                list_of_state.append([g_a-(b-g_b), b, g_c])
                list_of_state = cal_milk_cap(g_a-(b-g_b), b, g_c,list_of_state)
        if g_c is not c:
            if (c-g_c)>g_a and [0, g_b, g_c+g_a] not in list_of_state:
                list_of_state.append([0, g_b, g_c+g_a])
                list_of_state = cal_milk_cap(0, g_b, g_c+g_a,list_of_state)
            elif g_a-(c-g_c)> -1 and [g_a-(c-g_c), g_b, c] not in list_of_state:
                list_of_state.append([g_a-(c-g_c), g_b, c])
                list_of_state = cal_milk_cap(g_a-(c-g_c), g_b, c,list_of_state)
    if g_b is not 0:
        if g_a is not a:
            if (a-g_a)>g_b and [g_b+g_a, 0, g_c] not in list_of_state:
                list_of_state.append([g_b+g_a, 0, g_c])
                list_of_state = cal_milk_cap(g_b+g_a, 0, g_c,list_of_state)
            elif g_b-(a-g_a)> -1 and [a, g_b-(a-g_a), g_c] not in list_of_state:
                list_of_state.append([a, g_b-(a-g_a), g_c])
                list_of_state = cal_milk_cap(a, g_b-(a-g_a), g_c,list_of_state)
        if g_c is not c:
            if (c-g_c)>g_b and [g_a, 0, g_c+g_b] not in list_of_state:
                list_of_state.append([g_a, 0, g_c+g_b])
                list_of_state = cal_milk_cap(g_a, 0, g_c+g_b,list_of_state)
            elif g_b-(c-g_c)> -1 and [g_a, g_b-(c-g_c), c] not in list_of_state:
                list_of_state.append([g_a, g_b-(c-g_c), c])
                list_of_state = cal_milk_cap(g_a, g_b-(c-g_c), c,list_of_state)
    if g_c is not 0:
        if g_b is not b:
            if (b-g_b)>g_c and [g_a, g_b+g_c, 0] not in list_of_state:
                list_of_state.append([g_a, g_b+g_c, 0])
                list_of_state = cal_milk_cap(g_a, g_b+g_c, 0,list_of_state)
            elif g_c-(b-g_b)> -1 and [g_a, b, g_c-(b-g_b)] not in list_of_state:
                list_of_state.append([g_a, b, g_c-(b-g_b)])
                list_of_state = cal_milk_cap(g_a, b, g_c-(b-g_b),list_of_state)
        if g_a is not a:
            if (a-g_a)>g_c and [g_a+g_c, g_b, 0] not in list_of_state:
                list_of_state.append([g_a+g_c, g_b, 0])
                list_of_state = cal_milk_cap(g_a+g_c, g_b, 0,list_of_state)
            elif g_c-(a-g_a)> -1 and [a, g_b, g_c-(a-g_a)] not in list_of_state:
                list_of_state.append([a, g_b, g_c-(a-g_a)])
                list_of_state = cal_milk_cap(a, g_b, g_c-(a-g_a),list_of_state)
    return list_of_state
initial_list = [[0,0,c]]
final_result = []
for i in cal_milk_cap(0, 0, c,initial_list):
    if i[0] is 0 and i[2] not in final_result:
        final_result.append(i[2])
final_result = mergesort(final_result)
for j in final_result:
    print(j,end=' ')
