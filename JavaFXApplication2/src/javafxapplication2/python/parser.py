import re

#the dataset parsed as an array
data = list()

file = open(dataset)

#grab the column names
header = file.readline()
#split the line into column names
columns = header.split(';')

for line in file:
    #remove all whitespace
    temp = re.sub(r"\s", "", line)
    #ensure the line isn't an empty string
    if len(temp)>1:
        #ignore all the #ID-Device lines and blank lines
        if temp[1] != "#" and temp[1] != ';':
            #split the line on semicolons
            values = temp.split(';')
            #add the parsed line to the array
            data.append(values)


#convert times to Unix time
for entry in data:
    for i in range(0,len(entry)):
        entry[i] = re.sub(r"[^a-zA-Z0-9\.]", "", entry[i])
        
    tempFloat = float(re.sub(r"[^0-9\.]", "", entry[0]))
