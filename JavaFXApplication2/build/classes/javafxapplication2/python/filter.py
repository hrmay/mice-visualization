import re
from json import *

values = [0]*25
for entry in data:
    if (entry[2] not in mice):
            data.remove(entry)
    #Unicode strings are the death of me
    RFID = int((re.sub(r"[^a-zA-Z0-9\.]", "", entry[3]))[4:])
    values[RFID] += int(re.sub(r"[^a-zA-Z0-9\.]", "", entry[4]))

row1 = [values[i] for i in [1,5,9,13,17,21]]
row2 = [values[i] for i in [2,6,10,14,18,22]]
row3 = [values[i] for i in [3,7,11,15,19,23]]
row4 = [values[i] for i in [4,8,12,16,20,24]]

heatValues = [row1, row2, row3, row4]

heatmapData = JSONEncoder().encode({'z': heatValues, 'type': 'heatmap'})