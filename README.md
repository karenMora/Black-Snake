# Black-Snake
- Part I - Introduction to threads in JAVA

* define the life cycle of a thread that prints the numbers between A and B on the screen.
![Alt text](I1.png)

* Create 3 threads of type CountThread, assigning the first interval [0..99], the second [99..199], and the third [200..299].
![Alt text](I21.png)

* Start the three threads with start(). Run and check the output on the screen. 
![Alt text]()

* Change the beginning with start() to run(). How does the output change? Why?. Cambia la salida porque con start() para el run() los subprocesos se estan ejecutando en un orden especifico y no simultaneamente.
![Alt text](I23run().png)


- Part II - Black List Search Exercise

* Create a Thread class that represents the life cycle of a thread that searches for a segment of the pool of available servers. Add to that class a method that allows you to ask the instances of it (the threads) how many occurrences of malicious servers it has found or found.
 
* Add to the checkHost method an integer parameter N, corresponding to the number of threads between which the search will be carried out (remember to take into account if N is even or odd!). Modify the code of this method so that it divides the search space between the indicated N parts, and parallels the search through N threads. Have that function wait until the N threads finish solving their respective sub-problem, add the occurrences found for each thread to the list that returns the method, and then calculate (adding the total number of occurrences found for each thread) if the Number of occurrences is greater than or equal to BLACK_LIST_ALARM_COUNT. If this is the case, in the end the host MUST be reported as reliable or not reliable, and the list should be shown with the numbers of the respective blacklists.

![Alt text]()

- Part III - Discussion
* How could the implementation be modified to minimize the number of queries in these cases? 

* What new element would this bring to the problem?


- Part IV - Performance Evaluation
* A single thread.
![Alt text]()

* As many threads as processing cores (have the program determine this using the Runtime API). 
![Alt text]()

* As many threads as twice the number of processing cores. 
![Alt text]()

* 50 threads 
![Alt text]()

* 100 threads
![Alt text]()

* According to Amdahls law, where S(n) is the theoretical improvement of performance, P the parallel fraction of the algorithm, and n the number of threads, the greater n, the better this improvement should be.

* Why is the best performance not achieved with the 500 threads? 
![Alt text]()

* How is this performance compared when using 200 ?.
![Alt text]()

* How does the solution behave using as many processing threads as cores compared to the result of using twice as much?
![Alt text]()

* According to the above, if for this problem instead of 100 threads in a single CPU could be used 1 thread in each of 100 hypothetical machines, Amdahls law would apply better ?. If x threads are used instead of 100/x distributed machines (where x is the number of cores of these machines), would it be improved? Explain your answer.
![Alt text]()


# Snake Race
- Part 1
- Part 2
- Part 3

