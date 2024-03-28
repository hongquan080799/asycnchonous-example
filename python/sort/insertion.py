def insertionSort(arr):
    for i in range(1 , len(arr)):
        j = i
        while j > 0 and arr[j - 1] > arr[j]:
            arr[j - 1], arr[j] = arr[j], arr[j - 1]
            j = j - 1
    return arr


print(insertionSort([9,8,7,6,5,4,3,2,1]))