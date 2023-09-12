# Необходимо написать алгоритм, считающий сумму всех чисел
# от 1 до N. Согласно свойствам линейной сложности,
# количество итераций цикла будет линейно изменяться
# относительно изменения размера N.


# Написать алгоритм поиска простых чисел (делятся только на себя и
# на 1) в диапазоне от 1 до N. В алгоритме будет использоваться
# вложенный for, что явно говорит о квадратичной сложности, на этом
# стоит акцентировать внимание
import time


def recursiveFib(number):
    if ((number == 1) or (number == 2)):
        return 1
    else:
        return recursiveFib(number - 1) + recursiveFib(number - 2)


def recursiveFibTwo(number, myDict):
    if ((number == 1) or (number == 2)):
        return 1
    elif (number in myDict.keys()):
        return myDict[number]
    else:
        FibMinor = recursiveFibTwo(number - 1, myDict)
        FibMinorMinor = recursiveFibTwo(number - 2, myDict)
        myDict[number-1] = FibMinor
        myDict[number-2] = FibMinor
        return FibMinor + FibMinorMinor


def linearFib(number):
    temp = 1
    count = 1
    for i in range(3, number + 1):
        count = count + temp
        temp = count - temp
    return count


number = 400
data = dict()

start = time.perf_counter()
# print(recursiveFib(number))
rtime = time.perf_counter() - start

start = time.perf_counter()
print(linearFib(number))
ltime = time.perf_counter() - start

start = time.perf_counter()
print(recursiveFibTwo(number,data))
rTwoTime = time.perf_counter() - start

print(f"{rtime}\n{rTwoTime}\n{ltime}")
