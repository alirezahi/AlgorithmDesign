# def base10toN(num, base):
#     converted_string, modstring = "", ""
#     currentnum = num
#     if not 1 < base < 21:
#         return '0'
#     if not num:
#         return '0'
#     while currentnum:
#         mod = currentnum % base
#         currentnum = currentnum // base
#         converted_string = chr(48 + mod + 7*(mod > 10)) + converted_string
#     return converted_string
import string
digs = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ'

def base10toN(x, base):
    if x < 0:
        sign = -1
    elif x == 0:
        return digs[0]
    else:
        sign = 1

    x *= sign
    digits = []

    while x:
        digits.append(digs[x % base])
        x = int(x/base)

    if sign < 0:
        digits.append('-')

    digits.reverse()

    return ''.join(digits)

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
