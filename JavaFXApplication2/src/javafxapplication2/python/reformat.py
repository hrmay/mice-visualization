for entry in data:
	if (entry[3] not in mice):
		data.remove(entry)
	RFID = int(entry[3][4:])
	values[RFID] += int(entry[4])

row1 = values[1,5,9,13,17,21]
row2 = values[2,6,10,14,18,22]
row3 = values[3,7,11,15,19,23]
row4 = values[4,8,12,16,20,34]

heatmapData = [row1, row2, row3, row4]