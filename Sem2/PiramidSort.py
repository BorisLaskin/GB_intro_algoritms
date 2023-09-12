from random import randint

list_rand_int = [randint(0, 100) for _ in range(20)]

print(*list_rand_int)

def heapifyPiramid(array, size, root):
    largest = root
    leftChild = 2 * root + 1
    rightChild = 2 * root + 2
    if leftChild < size and array[leftChild] > array[largest]:
        largest = leftChild
    if rightChild < size and array[rightChild] > array[largest]:
        largest = rightChild

    if largest != root:
        array[largest], array[root] = array[root], array[largest]
        heapifyPiramid(array, size, largest)

def piramidSort(array):
    N = len(array)
    for i in range(int(N / 2) - 1, -1, -1):
        heapifyPiramid(array, N - i, i)

    # print(*array)

    for i in range(N -1,0,-1):
        array[i], array[0] = array[0], array[i]
        heapifyPiramid(array, i, 0)
        # print(*array)
        

piramidSort(list_rand_int)
print(*list_rand_int)
