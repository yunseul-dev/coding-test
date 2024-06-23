function solution(n, vertex) {
   const graph = Array.from({ length: n + 1 }, () => []);

   for (const [a, b] of vertex) {
     graph[a].push(b);
     graph[b].push(a);
   }

   const queue = [1];
   const distances = Array.from({ length: n + 1 }, () => -1);

   distances[1] = 0;

   while (queue.length > 0) {
     const cur = queue.shift();

     for (const next of graph[cur]) {
       if (distances[next] === -1) {  
         distances[next] = distances[cur] + 1;
         queue.push(next);
       }
     }
   }

   const maxDis = Math.max(...distances);

   return distances.filter((dis) => dis === maxDis).length;
}