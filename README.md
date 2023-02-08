# CSB302_GraphProject
Purpose: To practice and demonstrate proficiency in using graph algorithms in implementation.

Skills Used: Java programming

Knowledge Goals: Floyd-Warshall Algorithm, Dijkstra's Algorithm, Bellman-Ford Algorithm, DAG-based Shortest Path Algorithm, Prim-Jarnik's Algorithm, Ford-Fulkerson Algorithm

 

Summary
In this project, you will work independently to implement several graph algorithms that we went over in class. You will you your own Github Repo for this and submit a link to it as submission. This assignment will be more general in its instructions than we are used to as it is optional. Please see under Assessment for what it will be worth.

You must create a graph of a minimum of 6 nodes and minimum of 7 edges.

Please complete between 1-3 algorithms (see Assessment below for value of doing 1-3). Restrictions on implementation are below each one.

Floyd-Warshall Algorithm for Transitive Closure
Must use a directed graph (digraph).
Djikstra's Algorithm
Must use an undirected graph and show which edges become relaxed as well as the shortest path.
Bellman-Ford Algorithm
Must use a directed graph (digraph) and result showing the shortest distances from the source to each vertex.
DAG-based Shortest Path Algorithm
Must use a directed acyclic graph (DAG) and result showing the shortest distances from the source to each vertex.
Prim-Jarnik's Algorithm
Must use an undirected graph and result showing the minimum spanning tree, as well as what edges are relaxed.
Ford-Fulkerson Algorithm
Must use directed graph (digraph) and show the flow weights before and after all iterations of the FF algorithm. Must also indicate what the maximum flow would be and which edges the min cut would cover.
 

Part 1: Designing the Program
Things to consider when designing your program:

You do not need to create UML diagrams for this project.
Where will you get your graph data structure code? Will you create it yourself? Will you use the code from AD 325 last quarter? That choice is yours.
Which algorithms will you implement for this project?
 

Part 2: Java Implementation
The implementation of this is largely up to you. Here are a few things I look for in well-designed implementations:

Follows principles of OOP: Inheritance, Polymorphism, Abstraction, Encapsulation
I'm not checking for each one of these. Obviously, there are situations where none or very few will be used and there are situations where all may be used. Use your discretion.
Well-organized project structure.
This could include multiple packages or possibly not. 
Use of Interfaces.
For any classes where it will be relevant, use of interfaces is a great idea. Not required for this project, but optional.
 

Part 3: Illustrating and Analyzing Results
Be sure that the grader can see results that SHOW you algorithms are working.
I am not going to hand-hold how you do this but if I cannot tell the algorithms are working, you will not get credit.
The best way I would say to do this is show the state of the graph before the algorithm is executed and then show the state of the graph after it is executed. Explain in your output from your program how the graph has changed and why it changed. If I can see that, you will get full credit.
Junit tests are amazing and I encourage them but I really need to see textual output showing the states of the graphs before and after the algorithm.  
I will make one provision in this regard. If you can provide me ample comments in your program about how each Junit test proves your algorithms work, I will consider that as acceptable. Documentation is absolutely key in this regard if you choose to go with a junit-test only output.
 

Some other items of importance
Use javadoc comments on your functions to explain what they do. You do not have to do this in the class implementations where there is an interface, you can use @inheritDoc.
Be sure your code is clean, legible and easy to read.
Feel free to go above and beyond!  Add new methods and functionality, test in different ways in addition to what you are required to do, be creative! The top grades go to those who go above and beyond. Strive for excellence.
You are not required to create unit tests but are welcome to do so if you wish.
Including the runtime as a comment on algorithms with loops in them will be seen as going above and beyond as well.
 

Format Requirements
Please ensure you follow the structure as listed above. Use IntelliJ to do your work. Use javadoc comments where appropriate.
Please use your own repo for this assignment.
