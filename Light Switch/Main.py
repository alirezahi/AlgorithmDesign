def comp_num(number):
    if number == '1':
        return '0'
    else:
        return '1'

def check_light(a1,a2,a3,a4,turn_on,turn_off,n):
    lights = ''
    for i in range(n):
        lights = lights + '1'
    tmp_light = ''
    if a1:
        for letter in lights:
            tmp_light = tmp_light + comp_num(letter)
        lights = tmp_light
        tmp_light = ''
    if a2:
        for i in range(n):
            if i%2==1:
                tmp_light = tmp_light+lights[i]
            else:
                tmp_light = tmp_light + comp_num(lights[i])
        lights = tmp_light
        tmp_light = ''
    if a3:
        for i in range(n):
            if i%2==0:
                tmp_light = tmp_light+lights[i]
            else:
                tmp_light = tmp_light + comp_num(lights[i])
        lights = tmp_light
        tmp_light = ''
    if a4:
        for i in range(n):
            if i%3==0:
                tmp_light = tmp_light +  comp_num(lights[i])
            else:
                tmp_light = tmp_light + lights[i]
        lights = tmp_light
    for i in turn_on:
        if lights[i-1] != '1':
            return None
    for i in turn_off:
        if lights[i-1] != '0':
            return None
    return lights

n = int(input())
c = int(input())
light_on = [int(i) for i in str(input()).split(' ')[:-1]]
light_off = [int(i) for i in str(input()).split(' ')[:-1]]
final_result = []


def check_zero_time():
    result = []
    a = check_light(False, False, False, False, light_on, light_off, n)
    if a != None:
        result.append(a)
    return result

def check_one_time():
    result = []
    a = check_light(True, False, False, False, light_on, light_off, n)
    if a != None:
        result.append(a)
    a = check_light(False, True, False, False, light_on, light_off, n)
    if a != None:
        result.append(a)
    a = check_light(False, False, True, False, light_on, light_off, n)
    if a != None:
        result.append(a)
    a = check_light(False, False, False, True, light_on, light_off, n)
    if a != None:
        result.append(a)
    return result

def check_two_time():
    result = []
    a = check_light(True, True, False, False, light_on, light_off, n)
    if a != None:
        result.append(a)
    a = check_light(False, True, True, False, light_on, light_off, n)
    if a != None:
        result.append(a)
    a = check_light(True, False, True, False, light_on, light_off, n)
    if a != None:
        result.append(a)
    a = check_light(False, False, True, True, light_on, light_off, n)
    if a != None:
        result.append(a)
    a = check_light(False, True, False, True, light_on, light_off, n)
    if a != None:
        result.append(a)
    a = check_light(True, False, False, True, light_on, light_off, n)
    if a != None:
        result.append(a)
    return result

def check_three_time():
    result = []
    a = check_light(True, True, True, False, light_on, light_off, n)
    if a != None:
        result.append(a)
    a = check_light(False, True, True, True, light_on, light_off, n)
    if a != None:
        result.append(a)
    a = check_light(True, False, True, True, light_on, light_off, n)
    if a != None:
        result.append(a)
    a = check_light(True, True, False, True, light_on, light_off, n)
    if a != None:
        result.append(a)
    return result

def check_four_time():
    result = []
    a = check_light(True, True, True, True, light_on, light_off, n)
    if a != None:
        result.append(a)
    return result


if c == 0:
    a = check_zero_time()
    if a!=[]:
        final_result.append(a)
elif c ==1 :
    a = check_one_time()
    if a!=[]:
        final_result.append(a)
elif c == 2 :
    a = check_zero_time()
    if a!=[]:
        final_result.append(a)
    a = check_two_time()
    if a!=[]:
        final_result.append(a)
elif c % 2 == 1 :
    a = check_one_time()
    if a!=[]:
        final_result.append(a)
    a = check_three_time()
    if a!=[]:
        final_result.append(a)
elif c % 2 == 0 :
    a = check_zero_time()
    if a!=[]:
        final_result.append(a)
    a = check_two_time()
    if a!=[]:
        final_result.append(a)
    a = check_four_time()
    if a!=[]:
        final_result.append(a)
resulted = False
final_arr = []
if final_result != []:
    for i in final_result:
        for j in i:
            final_arr.append(j)
            resulted = True
newlist = []
for i in final_arr:
  if i not in newlist:
      newlist.append(i)
newlist.sort()
for i in newlist:
    print(i)
if not resulted:
    print('IMPOSSIBLE')