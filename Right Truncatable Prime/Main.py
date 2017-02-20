n = int(input())
def is_prime(n):
  if n == 2 or n == 3: return True
  if n < 2 or n%2 == 0: return False
  if n < 9: return True
  if n%3 == 0: return False
  r = int(n**0.5)
  f = 5
  while f <= r:
    if n%f == 0: return False
    if n%(f+2) == 0: return False
    f +=6
  return True

def die_hard_num(n):
    if n==1:
        return[2,3,5,7]
    else:
        array_list = []
        for i in die_hard_num(n-1):
            for j in [1,3,7,9]:
                z = i*10+j
                if is_prime(z):
                    array_list.append(z)
        return array_list

for number in die_hard_num(n):
    print (number)
