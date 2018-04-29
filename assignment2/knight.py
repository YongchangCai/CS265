#!/urs/bin/python
#
#Assignment 2: Knight's tour
#
#Description: To solve the Knight's Tour for a given board by luck.
#The Knight's Tour is an attempt to move the knight on a board, such that each space is visited exactly once.
#Input arguments:  rows, columns, attempts 
#
#Author: Yongchang Cai
#
#Date: 10/31/2016
#

import sys
import random

ROWS = int(sys.argv[1])				#Goble variable for input Rows
COLUMNS = int(sys.argv[2])		#Goble variable for input Columns
ATTEMPS = int(sys.argv[3])			#Goble variable for input Atteps			
POSSIBLE_MOVE = [[2,1],[1,2],[-2,1],[2,-1],[1,-2],[-1,2],[-1,-2],[-2,-1]]			#All the possible move for knights

def generateBoard():				#Function to generate the game board
	board = []								#The board buffer
	for i in range(ROWS):
		board.append([0]*COLUMNS)	#inital 0 in the board
	return board

def move(board,current_x,current_y,move_num):		#Function to move the knights to next position
	move_location = []					# Array to store all the possible position
	for move in POSSIBLE_MOVE : # Find possible position 
		test_y = move[0]+current_y
		test_x = move[1]+current_x
		if (test_x >= 0 and test_y>=0) and (test_x < COLUMNS) and (test_y<ROWS):	# Make sure position in side the board range 
			if (board[test_y][test_x] == 0) : 			# If the position have been taken
				move_location.append([test_y,test_x])	# add the cordinate to possible position array
			
	if (len(move_location) == 0): 	# Test if there is no possible position left
		return (False,current_x,current_y,move_num)	# Return with game finished value
	else:
		random_choice = random.choice(move_location)	# Pick a random move
		current_x = random_choice[1]							# Change columns to picked position
		current_y = random_choice[0]							# Change rows to picked position
		board[current_y][current_x] = move_num			# Mark that position with the steps number
		move_num	+= 1
		return (True,current_x,current_y,move_num)	# Return the update steps info
	
def playGame():						# Function to Solve Knight's Tour
	for i in range(ATTEMPS):		# Set the attemps time
		x = 0									# inital column position
		y = 0									# inital row position
		move_num = 2
		board = generateBoard()
		game_fail = False
		board[0][0] = 1
		able_move = True
		while (able_move == True):  # Move Knight until there is no possible position left
			(able_move,x,y,move_num)= move(board,x,y,move_num)
			
		for i in range(ROWS) :			# Change the lefted 0 to X signed for unfilled position
			for j in range(COLUMNS) :
				if (board[i][j] == 0) :
					board[i][j] = 'X'
					game_fail = True
					
		
		if (not game_fail): 					# Print Success output when it is success filled the board
			print('Success:')
			printBoard (board)
			return								# Stop the attempts when it success
			
	if (game_fail):							# Print the Last failure attemps
		print('Fail:')
		printBoard (board)
		return

def printBoard(board):					# Print function that used to print board
	for i in board:
		print ("   ".join('%5s' % str(j) for j in i))
			
		
		
def main( ) :
	if len(sys.argv)==4:	
		board = playGame()
	else:
		print('Wrong number of arguments. Please input as: knight.py rows columns attempts.')
		sys.exit

if __name__ == "__main__" :
	main()
		
