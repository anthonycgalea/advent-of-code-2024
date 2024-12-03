import sys, re

filename = sys.argv[1]

sum = 0

pattern = r"mul\(\d+,\d+\)"
pattern2 = r"\d+"

with open(filename, "r") as f:
    for line in f:
        matches = re.findall(pattern, line)
        for match in matches:
            nums = re.findall(pattern2, match)
            sum += int(nums[0])*int(nums[1])

print("Answer: " + str(sum))