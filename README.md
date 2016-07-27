# bug-fodder
I started by running FindBugs on the code. One bug in printSieve I noticed would cause the function to attempt to print and empty array. It printed if the array was empty, or if it was not null. This bug was found because the array was being checked for non-null after it is referenced, and action that would cause an exception if the array was null.

A few other small bugs were present. A variable was initialized but not used, and an exception was initialized instead of being thrown. The class name was not the same as the file name. I changed the class name to lowercase to match the filename, but they were both changed to beginning with a capital during style fixes.

The Style fixes were relatively straight forward. The thing that gave me the most trouble was the ordering of the imports in my test file. I looked at the xml sylte file to find the proper order.

As far as I know there are no bugs or style issues in SieveTest or Sieve.