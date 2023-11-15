from string import ascii_lowercase

alphabet_dict = {}

for i in ascii_lowercase:
    alphabet_dict[i] = 0

inputStr = input()
for s in str(inputStr) :
    alphabet_dict[s] += 1

res = list(alphabet_dict.values())
result = " ".join(map(str, res))

print(result)