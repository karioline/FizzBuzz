# -*- coding: utf-8 -*-
"""
Created on Thu Mar  1 08:54:49 2018

@author: Kari
"""

def multiples(a, b, c):
    if( (a%b == 0) & (a%c ==0) ):
        print("FizzBuzz")
    elif(a%b == 0):
        print("Fizz")
    elif(a%c == 0):
        print("Buzz")
    else:
        print(a)
    
x = int(input("Enter in a value for x:"))
y = int(input("Enter in a value for y:"))
i = 0

for i in range(100):
    multiples(i, x, y)