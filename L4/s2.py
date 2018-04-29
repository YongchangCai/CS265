#!/usr/bin/python
#
# s2.py
#
#CS265 Lab4 Python 
#Yongchang Cai 10/15/2016
#
#Editor: Use to read file Students and print 2 columns: the name, followed by
#average score.

import sys
def main():
	
	if len( sys.argv ) < 2: # no file name
		print 'ERROR: Please input file name as first Command' #wrong input
	else:
		fileName = sys.argv[1] 
		read_file = file(fileName,"r") #read the file
		while True:
			read_line = read_file.readline()		# read each line
			if not read_line: break  				# stop at the end of file
			line_array = read_line.split(',') 		# split by "," 
			student_name = line_array[0]  	# get student name
			student_grade = line_array[1:]		# get student grade as array
			student_total = 0
			for i in student_grade:				# Calculate total grade
				student_total += int(i)
			student_average = student_total / float(len(student_grade))
			print "%-9s %s" % (student_name, student_average)   	# print out final output

if __name__ == '__main__':
	main()
