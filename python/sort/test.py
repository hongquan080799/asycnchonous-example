def threeSum(nums):
    result = []
    nums.sort()
    for index, value in enumerate(nums):
        target = 0 - value
        l, r = index + 1, len(nums) - 1
        while l < r:
            sum = nums[l] + nums[r]
            if sum > target:
                r -= 1
            elif sum < target:
                l += 1
            else:
                result.append([nums[index], nums[l], nums[r]])
                break
    return result
print(threeSum([-1,0,1,2,-1,-4]))