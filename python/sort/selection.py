def selectionSort(arr):
    size = len(arr)
    for i in range(size):
        minIndex = i
        for j in range(i, size):
            if arr[j] < arr[minIndex]:
                minIndex = j
        arr[i], arr[minIndex] = arr[minIndex], arr[i]
    return arr
print(selectionSort([9,8,7,6,5,4,3,2,1]))