def bubbleSort(arr):
    size = len(arr)
    for i in range(size):
        for j in range(size - i - 1):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
    return arr
    
print(bubbleSort([9,8,7,6,5,4,3,2,1]))