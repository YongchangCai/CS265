#!/urs/bin/python
#
# id.py 
#
# CS265 Lab4 Python
# Yongchang Cai 10/15/2016
#
# Editor: Read file ids and store data as dictionary, sotred by id
#
import sys

def main():
	if len( sys.argv ) < 2: # no file name
		print 'ERROR: Please input file name as first command-line'
	else:
		fileName = sys.argv[1]
	
	read_file = file(fileName,"r")
	id_dict = dict()	
	while True:
		read_line = read_file.readline() 		# read each line
		if not read_line: break					# stop at the end of file
		split_array = read_line.split(' ',1)		# split by the first space as ID and name
		id_dict[int(split_array[0])] = split_array[1]	# add to id_dict
	for i in sorted(id_dict.keys()):
		print "%-9s %s" % (i, id_dict[i])		# print sotred value 
if __name__ == '__main__':
	main()
