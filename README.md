# dynamic_programming

Q. How to figure out the dimension of the Memoization array?
A. how many varaibles are modified inside the recursive calls? 
	1=> then it will be an array, list, set, etc...	
	2=> then it will be a m*n Matrix which is two dimensional.


1. draw the brute-force recursion tree
2. list all the possible values
3. in each branch draw to include or not to include the currenr choice
4. try to figure out the sub-problems from the tree
5. try to write a self contained recursive function which means all the needed variables for the calculation are passed as local variables
6. no static global varaibales, no tail recursion
7. figure out the base case and termination condition
8. iterate over the array of choices
9. can we include the current choice or does it violate the boundary, if it does recursively call the function with index+1 no change in the target value
10. we can include the current choice since it does not violate the boundary but do we want to
	a. figure out the maximum of inclusion and exclusion
	b. include target-sum- current and index, out targets-um -0 and index+1

