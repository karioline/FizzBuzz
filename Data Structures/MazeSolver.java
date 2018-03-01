MazeSolver(A, m, n)
//find the beginning of the maze, set to source s
for i = 1 to m{
   for j = 1 to n{
      if A[i][j] == 2{
         s = A[i][j]
         break
      }
   }
}
//find the end destination , set to destination d
for i = 1 to m{
   for i = 1 to n{
      if A[i][j] == 2{
         d = A[i][j]
         break
      }
   }
}
//color open spaces white, closed spaces black
for each vertex (i,j) != s{
   if A[i][j] = 0 or 2
         color(i,j) = white
   if A[i][j] = 1
         color (i,j) = black
}
//start using BFS code
for each vertex u in A where color == white{
   d[u] = infinity
   predecessor[u] = NIL
}
color[s] = gray
d[s] = 0
Q = null
ENQUEUE(Q, s)
while Q != null{
   u = DEQUEUE(Q)
   for each v in Adj[u]{
      if color[v] = white{
         color[v] == gray
         d[v] == d[u] + 1
         predecessor[v] == u
         ENQUEUE(Q, v)
      }
   }
   color[u] == black
}
//print the distance and shortest path from s to d
PRINT(d[d])
PUSH(predecessor[d...s]) into stack K
while k != null{
   t == POP(K)
   PRINT(t) 
}