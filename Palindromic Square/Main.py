def base10toN(num, base):
    converted_string, modstring = "", ""
    currentnum = num
    if not 1 < base < 37:
        return '0'
    if not num:
        return '0'
    while currentnum:
        mod = currentnum % base
        currentnum = currentnum // base
        converted_string = chr(48 + mod + 7*(mod > 10)) + converted_string
    return converted_string

def is_palindrome(n):
    m = n[::-1]
    if n == m:
        return True
    return False

n = int(input())
for i in range(1,301):
    j = i**2
    if is_palindrome(base10toN(j, n)):
        print(base10toN(i, n) + ' ' +base10toN(j, n))
