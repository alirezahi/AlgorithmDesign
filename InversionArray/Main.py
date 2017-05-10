

def find_split_inversion(fir_array,sec_array):
    final_inversion_count = 0
    i=0
    j=0
    final_arr = [0]*(len(fir_array)+len(sec_array))
    for k in range(len(fir_array)+len(sec_array)):
        if i is len(fir_array):
            while j<len(sec_array):
                final_arr[k]=sec_array[j]
                j = j +1
                k = k +1
        elif j is len(sec_array):
            while i<len(fir_array):
                final_arr[k]=fir_array[i]
                i = i + 1
                k = k +1
        else :
            if fir_array[i] <= sec_array[j]:
                final_arr[k] = fir_array[i]
                i = i + 1
            else:
                final_inversion_count = final_inversion_count + len(fir_array) - i
                final_arr[k] = sec_array[j]
                j = j + 1
    return final_arr , final_inversion_count



def find_inversion(sub_arr):
    if len(sub_arr) is 1:
        return sub_arr , 0
    else:
        mid = int(len(sub_arr)/2)
        first_sorted_array , num_1 = find_inversion(sub_arr[:mid])
        sec_sorted_array , num_2 = find_inversion(sub_arr[mid:])
        third_sorted_array , num_3 = find_split_inversion(first_sorted_array,sec_sorted_array)
        return third_sorted_array , num_1+num_2+num_3

n = int(input())
main_array = []
for i in range(n):
    main_array.append(int(input()))

main_a , count_inversion = find_inversion(main_array)
print(count_inversion)
