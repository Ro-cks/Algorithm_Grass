using System;
using System.Collections.Generic;

class Solution 
{
    int[] dr = { -1, 0, 1, 0 };
    int[] dc = { 0, 1, 0, -1 };
    
    class Node
    {
        public int r;
        public int c;
        public int dist;
        
        public Node(int r, int c, int dist)
        {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    
    public int solution(int[,] maps) 
    {
        return bfs(maps, maps.GetLength(0), maps.GetLength(1));
    }
    
    public int bfs(int[,] maps, int n, int m)
    {
        Queue<Node> q = new Queue<Node>();
        bool[,] visited = new bool[n, m];

        q.Enqueue(new Node(0, 0, 1));
        visited[0, 0] = true;

        while (q.Count != 0)
        {
            Node curr = q.Dequeue();
            int cr = curr.r;
            int cc = curr.c;

            for (int d = 0; d < 4; ++d)
            {
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if (nr >= n || nr < 0 || nc >= m || nc < 0) continue;
                if (visited[nr, nc]) continue;
                if (maps[nr, nc] == 0) continue;

                if (nr == n - 1 && nc == m - 1) return curr.dist + 1;

                q.Enqueue(new Node(nr, nc, curr.dist + 1));
                visited[nr, nc] = true;
            }
        }

        return -1;
    }
}