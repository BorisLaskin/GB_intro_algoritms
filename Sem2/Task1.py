from random import randint

list_rand_int = [randint(0, 100) for _ in range(10)]

print(*list_rand_int)
N = len(list_rand_int)


# for i in range(N):
#     for j in range(N-1):
#         if list_rand_int[j] > list_rand_int[j+1]:
#             list_rand_int[j], list_rand_int[j+1] = list_rand_int[j+1], list_rand_int[j]

def quickSort(list_int, low, high):

    if low < high:
        p = partition(list_int, low, high)
        quickSort(list_int, low, p)
        quickSort(list_int, p + 1, high)

def partition(list_int, low, high):
    pivot = list_int[int((low + high) / 2)]
    i = low
    j = high
    while True:
        while list_int[i] < pivot:
            i += 1
        while list_int[j] > pivot:
            j -= 1
        if i >= j:
            return j
        list_int[i], list_int[j] = list_int[j], list_int[i]
        i += 1
        j -= 1

quickSort(list_rand_int,0,N-1)
print(*list_rand_int)
