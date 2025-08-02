# Closest-Binary-Search-Tree-Value-II
Challenge at LeetCode.com. Tags: Binary Search Tree, Two Pointers, Depth-First Search.

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

**The solution is implemented in two variants: Deque and Pseudo-Deque.**
-

**Solutions with Deque: Java, C++, Kotlin, Go.**

As of August 2025, of the programming languages I know, only those have an inbuilt Deque and/or Doubly Linked List (applied as Deque in this case). Thus, the solution is in those programming languages.


**Solution with Pseudo-Deque: Java, JavaScript, TypeScript, C++, C#, Kotlin, Go.**

In this variant, the inbuilt resizable container for the corresponding programming language is applied: ArrayList (Java), Array (JavaScript, TypeScript), Vector (C++), List (C#), Mutable List (Kotlin), Slice (Go). It is implemented with an integer named “front” which indicates the current valid start of the Pseudo-Deque. 

When there is a need to remove an element from the front, “front” is incremented, thus moving it one position closer to the back. If there is a need to remove an element from the back, the inbuilt method for the corresponding container is applied. New elements, just as in the solution with Deque, are always added from the back.

The constraints of the problem statement, namely the maximum number of nodes is no greater than 104, make such an implementation with Pseudo-Deque a feasible solution that is still memory efficient. Alternatively, with larger constraints, the Pseudo-Deque could be implemented as a Circular Array with size equal to the Target Number of Nodes. 

The constraints of the problem statement are as of August 2025, since these sometimes change.
