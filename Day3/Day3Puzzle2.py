import sys, re

filename = sys.argv[1]

sum = 0

patternp2 = r"(?:^|do\(\))(.*?)(?=(?:don't\(\))|do\(\)|$)"
pattern = r"mul\(\d+,\d+\)"
pattern2 = r"\d+"

with open(filename, "r") as f:
    for line in f:
        p2matches = re.findall(patternp2, line)
        for m in p2matches:
            matches = re.findall(pattern, m)
            for match in matches:
                nums = re.findall(pattern2, match)
                sum += int(nums[0])*int(nums[1])

print("Answer: " + str(sum))