import re

def parse(dataset):
    try:
        #the dataset parsed as an array
        data = list()
        
        with open(dataset) as file:
            #grab the column names
            header = file.readline()
            #split the line into column names
            columns = header.split(';')
            
            try:
                for line in file:
                    #remove all whitespace
                    temp = re.sub(r"\s", "", line)
                    #ensure the line isn't an empty string
                    if len(temp)>1:
                        #ignore all the #ID-Device lines
                        if temp[1] != "#":
                            #split the line on semicolons
                            values = temp.split(';')
                            #add the parsed line to the array
                            data.append(values)
            except:
                print("Parsing failed.")
                
        #convert times to Unix time
        try:
            for entry in data:
                tempFloat = float(re.sub(r"[^0-9\.]", "", entry[0]))
                entry[0] = int(round((tempFloat * 86400) - 2209161600))
        except:
           print("Unix time conversion failed.")
        
        return data
        
    except:
        print("File not found!")
        
testData = parse("test.csv")
for i in testData:
    for j in i:
        print(j)