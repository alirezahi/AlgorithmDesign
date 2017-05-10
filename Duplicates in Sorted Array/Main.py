def merge_list(list1,list2):
    return list1[:-1] + [list1[-1]+list2[0]] + list2[1:]

def count_dup(new_list):
    if new_list[0] == new_list[-1]:
        return [len(new_list)]
    list1 = count_dup(new_list[:int(len(new_list)/2)])
    list2 = count_dup(new_list[int(len(new_list)/2):])
    if new_list[int(len(new_list)/2)-1] == new_list[int(len(new_list)/2)]:
        return merge_list(list1,list2)
    return list1+list2

n = int(input())
a = []
for i in range(n):
    a.append(int(input()))
for i in count_dup(a):
    print(i)